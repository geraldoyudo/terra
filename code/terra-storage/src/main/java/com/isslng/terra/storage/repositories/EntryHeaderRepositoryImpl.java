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
				+ "(OrgId, SerialNo, EntryType,"
				+ "ApprovedBy,ApprovedFromIP,DocumentReference,"
				+ "DocumentType,EntryCount,"
				+ "FinancialRecord, FinancialYear, PostDate,"
				+ "PostedBy, PostedFromIP, PostingRecord,"
				+ "PostingYear, ProofTotal, Remarks,"
				+ "ReviewedBy, ReviewedFromIP, ValueDate) "
				+ "VALUES "
				+ "('%s','%s','%s'"
				+ ",'%s','%s','%s'"
				+ ",'%s',%s"
				+ ",'%s','%s',%s"
				+ ",'%s','%s','%s'"
				+ ",'%s',%s,'%s'"
				+ ",'%s','%s',%s)";
		return String.format(template,
				entry.get("orgId"), entry.get("serialNo"), entry.get("entryType")
				,entry.get("approvedBy"), entry.get("approvedFromIP"), entry.get("documentReference"),
				entry.get("documentType"), entry.getOrDefault("entryCount", "0"), 
				entry.get("financialRecord"), entry.get("financialYear"), entry.get("postDate"),
				entry.get("postedBy"), entry.get("postedFromIP"), entry.get("postingRecord"),
				entry.get("postingYear"), entry.getOrDefault("proofTotal", "0"), entry.get("remarks"),
				entry.get("reviewedBy"), entry.get("reviewedFromIP"), entry.get("valueDate"));
	}
	private String generateEntryQuery(Map<String,String> entry){
		String template = "INSERT INTO ENTRIES "
				+ "(OrgId, SerialNo, EntryType"
				+ ",AccountNo, Amount, CcyAmount,"
				+ "CcyCredit,CcyDebit,Credit,"
				+ "Currency,Debit,Narrative,"
				+ "Rate, TransactionAnalysisCode) "
				+ "VALUES "
				+ "('%s', '%s', '%s',"
				+ "'%s', %s, %s"
				+ ",%s, %s, %s"
				+ ",'%s', %s, '%s'"
				+ ",%s, '%s');";
		return String.format(template, entry.get("orgId"),
				entry.get("serialNo"), entry.get("entryType"),
				entry.get("accountNo"), entry.getOrDefault("amount", "0"), entry.getOrDefault("ccyAmount", "0"),
				entry.getOrDefault("ccyCredit", "true"), entry.getOrDefault("ccyDebit", "false"), entry.getOrDefault("credit", "true"),
				entry.get("currency"), entry.getOrDefault("debit", "false"), entry.get("narrative"),
				entry.getOrDefault("rate", "1"), entry.get("transactionAnalysisCode"));
	}
}
