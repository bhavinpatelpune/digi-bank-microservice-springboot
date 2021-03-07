package com.payments.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payments.entities.Account;
import com.payments.repositories.AccountRepository;

//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.LoggerFactory;

@RestController
public class AccountController {
	
	//private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	AccountRepository acctRepo;
	
	@RequestMapping(value="/account/", method=RequestMethod.GET)
	@Transactional(readOnly=true)
	@Cacheable("account-cache")
	public List<Account> getAccountDetails(){
		return acctRepo.findAll();
	}
	
	@RequestMapping(value="/account/{id}", method=RequestMethod.GET)
	public Account getAccountDetails(@PathVariable("id") Long custId) {
//		LOGGER.debug("custId - " + custId);
		return acctRepo.findById(custId).get();
	}
	
	@RequestMapping(value="/account/", method=RequestMethod.POST)
	public Account createAccount(Account acct) {
		return acctRepo.save(acct);
	}
	
	@RequestMapping(value="/account/", method=RequestMethod.PUT)
	public Account updateAccount(Account acct) {
		return acctRepo.save(acct);
	}
	
	@RequestMapping(value="/account/{id}", method=RequestMethod.DELETE)
	@CacheEvict("account-cache")
	public void deleteAccount(@PathVariable("id") Long custId) {
		acctRepo.deleteById(custId);
	}

}
