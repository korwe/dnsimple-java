package com.nimbleservers.dnsimple;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class DnsUtility {

	private static String email;
	private static String key;
	private static String domain;

	static {
		File f = new File("/opt/dnskeys.properties");		
		try {

		Properties p = new Properties();
		p.load(new FileReader(f));
		
		email = p.getProperty("email");
		key = p.getProperty("key");
		domain = p.getProperty("domain");
		
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

	public static String getDomain() {
		return domain;
	}
	
}
