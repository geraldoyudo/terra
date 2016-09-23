package com.isslng.terra.journal.entrypoint;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isslng.banking.processor.entities.TransactionInput;
import com.isslng.banking.processor.exception.TransactionProcessingException;
import com.isslng.banking.processor.exception.TransactionValidatorException;
import com.isslng.banking.processor.utils.EntryBuilder;
import com.isslng.terra.journal.service.TransactionInputProcessor;
import com.isslng.terra.journal.service.TransactionInputValidator;

@Component
public class RequestHandler {
	@Autowired
	private TransactionInputValidator validator;
	@Value("${app.terra-storage-url}")
	private String terraStorageUrl;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private JmsOperations jmsOp;
	@Autowired
	private TransactionInputProcessor processor;
	
	@JmsListener( destination="${app.destination}")
	public void onRequest(byte[] message ,Message request) throws  JMSException, IOException{
		try{
	      	TransactionInput ti = objectMapper.readValue(new String(message), TransactionInput.class);
			validator.evaluate(ti);
			EntryBuilder builder = new EntryBuilder(ti);
			List<Map<String,Object>> journal = processor.process(builder);
			ResponseEntity<String> result =  submit(journal, ti.getOrgCode());
			sendReply(request, result);
		}catch(HttpServerErrorException |TransactionValidatorException | TransactionProcessingException ex ){
			sendReply(ex.getMessage(), "FAILURE",request);
		}catch(Exception ex){
			sendReply(ex.getMessage(), "FAILURE",request);
		}
	}
	private void sendReply(String message, String status, Message request) throws JmsException, JMSException{
		jmsOp.send(request.getJMSReplyTo(), new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				
				Message m = session.createTextMessage(message);
				m.setJMSCorrelationID(request.getJMSCorrelationID());
				m.setStringProperty("status", status);
				return m;
			}
		});
	}
	private void sendReply(Message request,ResponseEntity<String> result) throws JmsException, JMSException {
		jmsOp.send(request.getJMSReplyTo(), new MessageCreator() {
					
					@Override
					public Message createMessage(Session session) throws JMSException {
						String body = result.getBody();
						if(body == null){
							body = "";
						}
						Message m = session.createTextMessage(body);
						m.setJMSCorrelationID(request.getJMSCorrelationID());
						m.setStringProperty("status", result.getStatusCode().is2xxSuccessful()?"SUCCESS":"FAILURE");
						return m;
					}
				});
	}
	
	private ResponseEntity<String> submit(List<Map<String, Object>> journal, String tenantId) {
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("X_TENANT_ID", tenantId);
		HttpEntity<List<Map<String,Object>>> entity = new HttpEntity<>(journal, headers);	
		ResponseEntity<String> resp =template.exchange(terraStorageUrl,HttpMethod.POST, entity, String.class);
		return resp;
	}
}
