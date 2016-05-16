package com.isslng.terra.storage;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.isslng.terra.storage.util.MultiTenantProperties;

@Configuration
public class DatasourceConfig {
	@Autowired
	private MultiTenantProperties tenantProperties;
	@Bean(name = "multitenancy")
	public HashMap<String,DataSource> dataSources(){
		HashMap<String, DataSource> dataSourceMap = new HashMap<>();
		DataSourceProperties prop;
		System.out.println(tenantProperties.getMultiTenancy().toString());
		for(String tenant: tenantProperties.getMultiTenancy().keySet()){
			prop = tenantProperties.getMultiTenancy().get(tenant);
			if(prop == null) continue;
			DataSourceBuilder factory = DataSourceBuilder
					.create(prop.getClassLoader())
					.driverClassName(prop.getDriverClassName())
					.username(prop.getUsername())
					.password(prop.getPassword())
					.url(prop.getUrl());
			dataSourceMap.put(tenant, factory.build());
		}
		System.out.println(dataSourceMap);
		return dataSourceMap;
	}
}
