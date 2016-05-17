package com.isslng.terra.storage.util;

import java.util.Map;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("terra")
public class MultiTenantProperties {
	public Map<String, DataSourceProperties> multiTenancy;

	public Map<String, DataSourceProperties> getMultiTenancy() {
		return multiTenancy;
	}

	public void setMultiTenancy(Map<String, DataSourceProperties> multiTenancy) {
		this.multiTenancy = multiTenancy;
	}
	
}
