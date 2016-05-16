package com.isslng.terra.storage.repositories;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public class EntryHeaderRepositoryImpl implements EntryHeaderRepositoryCustom{
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public void save(List<Map<String,String>> entries){
		runScript(generateHeaderQuery(entries.get(0)));
		for(Map<String, String> entry: entries){
			runScript(generateEntryQuery(entry));
		}
		 
	
	}
	
	private int runScript(String sqlScript){
		System.out.println(sqlScript);
		Query q = entityManager.createNativeQuery(sqlScript );
	
		 return q.executeUpdate();
	}
	
	private String generateHeaderQuery(Map<String,String> entry){
		String template = "INSERT INTO ENTRYHEADER "
				+ "(orgId, serialNo, entryType) "
				+ "VALUES "
				+ "('%s','%s','%s')";
		return String.format(template, entry.get("orgId"), entry.get("serialNo"), entry.get("entryType"));
	}
	private String generateEntryQuery(Map<String,String> entry){
		String template = "INSERT INTO ENTRY "
				+ "(orgId, serialNo, entryType) "
				+ "VALUES "
				+ "('%s', '%s', '%s');";
		return String.format(template, entry.get("orgId"),
				entry.get("serialNo"), entry.get("entryType"));
	}
}
