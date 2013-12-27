package com.nimbleservers.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.nimbleservers.dnsimple.DnsimpleContext;
import com.nimbleservers.dnsimple.DnsUtility;
import com.nimbleservers.dnsimple.domain.Domain;
import com.nimbleservers.dnsimple.record.Record;
import com.nimbleservers.dnsimple.record.Record.Builder;

public class RecordsTest {

	@Test
	public void testRegisterDomain() {
		String email = DnsUtility.getEmail();
		String key = DnsUtility.getKey();
		String testUrl = DnsUtility.getTestUrl();
		DnsimpleContext ctx = new DnsimpleContext(email, key, testUrl);
		
		String id = DnsUtility.getUserId();
		Domain domain = ctx.addDomain("goosfsdfglexxxxx.com", id);
		
		System.out.println("domain="+domain);
	}
	
	@Test
	public void testBasicAdd() {
		String email = DnsUtility.getEmail();
		String key = DnsUtility.getKey();
		String testUrl = DnsUtility.getTestUrl();
		DnsimpleContext ctx = new DnsimpleContext(email, key, testUrl);

		String testDomain = DnsUtility.getDomainForTest();
		List<Record> records = ctx.getRecords(testDomain);
		
		String newDomain = "ours3.test";
		String ip = "127.0.0.1";
		
		for(Record r : records) {
			Assert.assertNotEquals(newDomain, r.getName());
			System.out.println("name="+r.getName()+" record="+r);
		}
		
		Builder builder = Record.getBuilder();
		builder.setName(newDomain).setRecordType("A").setContent("127.0.0.1");
		Record record = builder.build();
		Record fullRec = ctx.addRecord(testDomain, record);
		System.out.println("full record="+fullRec);
		
		List<Record> list = ctx.getRecords(testDomain);
		Record r = find(list, newDomain);
		Assert.assertNotNull(r);
		Assert.assertEquals(newDomain, r.getName());
		Assert.assertEquals(ip, r.getContent());
	}

	private Record find(List<Record> list, String newDomain) {
		for(Record r : list) {
			if(newDomain.equals(r.getName()))
				return r;
		}
		return null;
	}
	
}
