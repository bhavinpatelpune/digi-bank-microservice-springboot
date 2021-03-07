package com.payments.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.payments.entities.Account;

@Controller
public class AccountThymeleaf {
	
	@RequestMapping("/account")
	public String getAccount() {
		return "account";
	}
	
	@RequestMapping("/data")
	public ModelAndView sendData() {
		ModelAndView mav = new ModelAndView("data");
		mav.addObject("message", "Keep Learning!");
		return mav;
	}
	
	@RequestMapping("/accounts")
	public ModelAndView getAccountsSummary() {
		ModelAndView mav = new ModelAndView("accounts");
		Account acct = new Account();
		acct.setAccountNumber(1234567890);
		acct.setCustomerName("Bhavin Patel");
		mav.addObject("accounts", acct);
		
		return mav;
	}
	
	@RequestMapping("/accountList")
	public ModelAndView getAccountsList() {
		ModelAndView mav = new ModelAndView("accountList");
		
		Account acct = new Account();
		acct.setAccountNumber(1234567890);
		acct.setCustomerName("Bhavin Patel");
		
		Account acct1 = new Account();
		acct1.setAccountNumber(1122334455);
		acct1.setCustomerName("Ram Patel");
		
		List<Account> listAccount = Arrays.asList(acct,acct1);
		
		mav.addObject("accounts", listAccount);
		
		return mav;
	}
	
	
	@RequestMapping("/accountForm")
	public ModelAndView getAccountForm() {
		ModelAndView mav = new ModelAndView("accountForm");
		Account acct = new Account();
		acct.setAccountNumber(1234567890);
		acct.setCustomerName("Bhavin Patel");
		mav.addObject("account", acct);
		
		return mav;
	}
	
	
	@RequestMapping("/saveAccount")
	public ModelAndView saveAccount(@ModelAttribute Account account) {
		ModelAndView mav = new ModelAndView("result");
		System.out.println(account.getAccountNumber());
		System.out.println(account.getCustomerName());
		
		return mav;
	}

}
