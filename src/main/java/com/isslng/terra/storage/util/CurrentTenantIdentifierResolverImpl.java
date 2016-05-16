package com.isslng.terra.storage.util;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

	public static final String DEFAULT_TENANT_ID = "NONE";
	
	@Override
	public String resolveCurrentTenantIdentifier() {
		
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		if(requestAttributes != null){
			ServletRequestAttributes servReq= (ServletRequestAttributes) requestAttributes;
			HttpServletRequest req = servReq.getRequest();
			if (req != null) {
				String identifier = (String) req.getHeader("X_TENANT_ID");
				if (identifier != null) {
					return identifier;
				}
			}
		}
		return DEFAULT_TENANT_ID;
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		return true;
	}
}
