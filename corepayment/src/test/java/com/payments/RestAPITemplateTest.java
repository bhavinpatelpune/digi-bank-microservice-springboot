package com.payments;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.payments.entities.Account;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestAPITemplateTest {

	@Value("${account-test-url}")
	private String BASE_URL;

	@Test
	public void testGetAccounts() {
		RestTemplate restTemplate = new RestTemplate();
		Account act = restTemplate.getForObject(BASE_URL + "1", Account.class);
		assertNotNull(act);
		assertEquals("12345", act.getAccountNumber());
	}
	
	@Test
	public void testCreateAccounts() {
		RestTemplate restTemplate = new RestTemplate();
		Account act = new Account();
		act.setAccountNumber(12345);
		act.setIdCustomer("123");
		act.setCustomerName("Bhavin Patel");
		act.setSingleJoint("Single");
		act.setAccountType("Saving");
		act.setAccountStatus("Active");
		act.setCurrency("INR");
		act.setChqeuebook("Yes");
		act.setOverdraft("Yes");
		act.setStandingOrder("Yes");
		act.setMinBalance(100);
		act.setAvailableBalance(200);
		act.setDailyWithdrawalLimit(300);
		
		Account response = restTemplate.postForObject(BASE_URL, act, Account.class);
		
		assertNotNull(response);
		assertNotNull(response.getAccountNumber());
		assertEquals("12345", act.getAccountNumber());
	}
	
	@Test
	public void testUpdateAccounts() {
		RestTemplate restTemplate = new RestTemplate();
		Account act = restTemplate.getForObject(BASE_URL + "1", Account.class);
		act.setChqeuebook("Yes");
		restTemplate.put(BASE_URL + "11", act);
		
		assertNotNull(act);
		assertEquals("12345", act.getAccountNumber());
	}
	
	@Test
	public void testDeleteAccounts() {
		RestTemplate restTemplate = new RestTemplate();
		Account act = restTemplate.getForObject(BASE_URL + "1", Account.class);
		restTemplate.delete(BASE_URL);
		
		assertNotNull(act);
		assertEquals("12345", act.getAccountNumber());
	}
}
