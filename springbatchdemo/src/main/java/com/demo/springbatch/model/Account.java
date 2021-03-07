package com.demo.springbatch.model;


/*
CREATE TABLE `digibank`.`account` (
		  `accountnumber` INT NOT NULL,
		  `accounttype` VARCHAR(45) NULL,
		  `accountstatus` VARCHAR(45) NULL,
		  `balance` DOUBLE NULL,
		  PRIMARY KEY (`accountnumber`))
		COMMENT = 'account table';
*/

public class Account {
	
	private Integer accountNumber;
	private String accountType;
	private String accountStatus;
	private double balance;
	
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
