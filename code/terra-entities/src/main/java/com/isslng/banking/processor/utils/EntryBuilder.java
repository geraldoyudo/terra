package com.isslng.banking.processor.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.converters.DoubleConverter;

import com.isslng.banking.processor.entities.TransactionInput;

public class EntryBuilder {
	private TransactionInput transactionInput;
	private Map<String, Object> currentEntry = new HashMap<>();
	private List<Map<String,Object>> entries = new ArrayList<>();
	public static final boolean DEBIT = false;
	public static final boolean CREDIT = true;
	public EntryBuilder() {
	
	}
	public EntryBuilder(TransactionInput ti){
		this.transactionInput = ti;
	}
	public EntryBuilder put(String key, Object value){
		currentEntry.put(key, value);
		return this;
	}
	public EntryBuilder putTransactionField(String key){	
		Object property;
		property = getProperty(key);	
		currentEntry.put(key,
				property);
		return this;
	}
	
	public EntryBuilder putTransactionField(String[] keys){
		Object property;
		for(String key: keys){
			property = getProperty(key);
			currentEntry.put(key, property);
		}
		return this;
	}
	public EntryBuilder putTransactionField(String sourceKey, String destinationKey){
		Object property;
		property = getProperty(sourceKey);
		currentEntry.put(destinationKey, property);
		return this;
	}
	public EntryBuilder putTransactionField(String[] sourceKeys, String[] destinationKeys){
		int length = sourceKeys.length;
		if(length > destinationKeys.length){
			length = destinationKeys.length;
		}
		Object property;
		for(int i=0; i<length; ++i){
			property = getProperty(sourceKeys[i]);
			currentEntry.put(destinationKeys[i], property);
		}
		return this;
	}
	public EntryBuilder newEntry(){
		currentEntry = new HashMap<>(currentEntry);
		return this;
	}
	public EntryBuilder add(){
		entries.add(currentEntry);
		return newEntry();
	}
	public List<Map<String,Object>> build(){
		return entries;
	}
	public TransactionInput getTransactionInput() {
		return transactionInput;
	}
	public void setTransactionInput(TransactionInput transactionInput) {
		this.transactionInput = transactionInput;
	}
	
	public Object getProperty(String key) {
		Object property;
		BeanMap tiMap = new BeanMap(transactionInput);
		property = tiMap.get(key);
		if(property == null){
			property = transactionInput.getTransactionFields().get(key);
		}
		if(property == null){
			property = transactionInput.meta(key);
		}
		return property;
	}
	
	public EntryBuilder putAmount(String property, boolean credit){
		Object amt = getProperty(property);
		BigDecimal amount;
		if(amt == null){
			amount = new BigDecimal(0);
		}else{
			amount = new BigDecimal(amt.toString());
		}
		return putAmount(amount, credit);
		
	}
	public EntryBuilder putAmount(BigDecimal amount, boolean credit){
			Object rateObj = getProperty("rate");
			
			if(rateObj == null){
				rateObj = 1;
			}
			BigDecimal ccyAmount = amount.multiply(new BigDecimal(rateObj.toString()));
			if(credit){
				return this.put("amount", amount)
						.put("ccyAmount",  ccyAmount)
						.put("ccyCredit", ccyAmount)
						.put("credit", amount)
						.put("ccyDebit", 0)
						.put("debit", 0);
			}else{
				return this.put("amount", amount.negate())
						.put("ccyAmount",  ccyAmount.negate())
						.put("ccyDebit", ccyAmount)
						.put("debit", amount)
						.put("ccyCredit", 0)
						.put("credit", 0);
			}
	}
}
