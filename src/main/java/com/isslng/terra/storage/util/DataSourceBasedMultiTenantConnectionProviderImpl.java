package com.isslng.terra.storage.util;

import java.util.HashMap;

import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DataSourceBasedMultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

	private static final long serialVersionUID = 8168907057647334460L;
	private static final String DEFAULT_TENANT_ID = "tenant_1";
	@Autowired
	@Qualifier("multitenancy")
	private HashMap<String, DataSource> map;
	@Autowired
	private DataSource defaultDataSource;

	@Override
	protected DataSource selectAnyDataSource() {
		return defaultDataSource;
	}

	@Override
	protected DataSource selectDataSource(String tenantIdentifier) {
		System.out.println("Identifier = " + tenantIdentifier);
		if(tenantIdentifier.equals(DataSourceBasedMultiTenantConnectionProviderImpl.DEFAULT_TENANT_ID))
			return defaultDataSource;
		DataSource d = map.get(tenantIdentifier);
		System.out.println(d);
		return d;
	}
}
