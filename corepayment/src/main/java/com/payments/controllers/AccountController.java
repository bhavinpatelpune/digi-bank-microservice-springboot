package com.payments.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payments.entities.Account;
import com.payments.repositories.AccountRepository;

@RestController
public class AccountController {
	
	@Autowired
	AccountRepository acctRepo;
	
	@RequestMapping(value="/account/", method=RequestMethod.GET)
	public List<Account> getAccountDetails(){
		return acctRepo.findAll();
	}
	
	@RequestMapping(value="/account/{id}", method=RequestMethod.GET)
	public Account getAccountDetails(@PathVariable("id") Long custId) {
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
	public void deleteAccount(@PathVariable("id") Long custId) {
		acctRepo.deleteById(custId);
	}

}
