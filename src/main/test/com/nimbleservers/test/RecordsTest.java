package com.nimbleservers.test;

import java.util.List;

import org.junit.Test;

import com.nimbleservers.dnsimple.DnsimpleContext;
import com.nimbleservers.dnsimple.record.Record;

public class RecordsTest {

	@Test
	public void testBasicList() {
		String email = Utility.getEmail();
		String key = Utility.getKey();
		String testDomain = Utility.getDomain();
		DnsimpleContext ctx = new DnsimpleContext(email, key);
		
		List<Record> records = ctx.getRecords(testDomain);
		
		for(Record r : records) {
			System.out.println("record="+r);
		}
	}
}
