package com.gerald.multi.tenant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.isslng.terra.storage.MultiTenantTestApplication;
import com.isslng.terra.storage.entities.Entry;
import com.isslng.terra.storage.entities.EntryHeader;
import com.isslng.terra.storage.repositories.EntryHeaderRepository;
import com.isslng.terra.storage.repositories.EntryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MultiTenantTestApplication.class)
@WebAppConfiguration
@Transactional
public class MultiTenantTestApplicationTests {
@Autowired
EntryHeaderRepository ehRepo;
@Autowired
EntryRepository eRepo;
	
	public void contextLoads() {
		Entry entry = new Entry();
		EntryHeader eh = new EntryHeader();
		
		eh.setOrgId("232");
		eh.setEntryType("type");
		eh.setSerialNo("serialNo");
		eh.getEntries().add(entry);
		ehRepo.save(eh);
		System.out.println(ehRepo.count());
		System.out.println(eRepo.count());
	}
	@Test
	public void testSaveEntryMap(){
		System.out.println(ehRepo.count());
		System.out.println(eRepo.count());
		List<Map<String,String>> entries = new ArrayList<>();
		HashMap<String,String> entry = new HashMap<>();
		entry.put("orgId", "5432323");
		entry.put("serialNo", "jkjkkkjjj");
		entry.put("entryType", "sasddddd");
		entries.add(entry);
		ehRepo.save(entries);
		System.out.println(ehRepo.count());
		System.out.println(eRepo.count());
		 
	}

}
