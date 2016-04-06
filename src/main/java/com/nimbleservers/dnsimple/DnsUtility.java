package com.nimbleservers.dnsimple;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class DnsUtility {

	private static String email;
	private static String key;
	private static String domain;
	//used for registering new domains...
	private static String userId;
	private static String url;
	private static String domainToken;
	
	static {
		File f = new File("/opt/dnskeys.properties");		
		try {

		Properties p = new Properties();
		p.load(new FileReader(f));
		
		email = p.getProperty("dns.email");
		key = p.getProperty("dns.key");
		domain = p.getProperty("dns.test.domain");
		userId = p.getProperty("dns.id");
		url = p.getProperty("dns.url");
		domainToken = p.getProperty("dns.production.domainToken");
		
		} catch(Exception e) {
			throw new RuntimeException("failed to load properties file", e);
		}
		if(email == null)
			throw new IllegalArgumentException("property 'email' not found in properties file="+f.getAbsolutePath());
		else if(key == null)
			throw new IllegalArgumentException("property 'key' not found in properties file="+f.getAbsolutePath());
		else if(domain == null)
			throw new IllegalArgumentException("property 'domain' not found in properties file="+f.getAbsolutePath());
	}

	public static String getEmail() {
		return email;
	}

	public static String getKey() {
		return key;
	}

	public static String getDomainForTest() {
		return domain;
	}

	public static String getUserId() {
		return userId;
	}

	public static String getUrl() {
		return url;
	}

	public static String getToken() {
		return domainToken;
	}
	
}
