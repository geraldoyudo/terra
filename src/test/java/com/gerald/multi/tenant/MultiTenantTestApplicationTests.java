package com.gerald.multi.tenant;

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
	@Test
	public void contextLoads() {
		Entry entry = new Entry();
		EntryHeader eh = new EntryHeader();
		
		eh.setOrgId("232");
		eh.setType("type");
		eh.setSerialNo("serialNo");
		eh.getEntries().add(entry);
		ehRepo.save(eh);
		System.out.println(ehRepo.count());
		System.out.println(eRepo.count());
	}

}
