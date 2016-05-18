package com.isslng.terra.journal.service;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DroolsImporter {
	@Value("${app.drools.rules.validation}")
	private String validationFolder;
	@Value("${app.drools.rules.processing}")
	private String processingFolder;
	@PostConstruct
	public void moveFiles(){
		String[] destn = new String[]{"/rules/validation", "/rules/processing"};
		String[] src = {validationFolder,processingFolder};
		for(int i=0; i< destn.length; ++i ){
			if(src[i] != null){
				try {
				File source = new File(src[i]);
				URL url = this.getClass().getResource(destn[i]);
				
				File dest = new File(url.toURI());
				
				    FileUtils.copyDirectory(source, dest);
				    System.out.println( String.format("Files for %s successfully loaded to %s",src[i],
				    		destn[i]));
				} catch (IOException e) {
				    e.printStackTrace();
				} catch (Exception e){
					 e.printStackTrace();
				}
			}else{
				System.out.println(String.format("Files at %s not loaded to %s",src[i], destn[i]));
			}
		}
		
		
		
	}
}
