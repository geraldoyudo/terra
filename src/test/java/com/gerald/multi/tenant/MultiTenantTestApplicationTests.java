package com.gerald.multi.tenant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.isslng.terra.storage.MultiTenantTestApplication;
import com.isslng.terra.storage.entities.Entry;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MultiTenantTestApplication.class)
@WebAppConfiguration
public class MultiTenantTestApplicationTests {

	@Test
	public void contextLoads() {
		Entry entry = new Entry();
	}

}
