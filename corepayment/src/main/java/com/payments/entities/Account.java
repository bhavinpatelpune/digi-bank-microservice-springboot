package com.payments.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author : Bhavin Patel 
 * @Date   : 04-03-2021
 * @Details: Account entity class to use for DAO operation 
 */

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long accountNumber;
	
	private String idCustomer;	
	private String customerName;
	private String singleJoint;
	private String accountType;
	private String accountStatus;
	private String currency;
	private String chqeuebook;
	private String overdraft;
	private String standingOrder;
	private double minBalance;
	private double availableBalance;
	private double dailyWithdrawalLimit;
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getSingleJoint() {
		return singleJoint;
	}
	public void setSingleJoint(String singleJoint) {
		this.singleJoint = singleJoint;
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
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getChqeuebook() {
		return chqeuebook;
	}
	public void setChqeuebook(String chqeuebook) {
		this.chqeuebook = chqeuebook;
	}
	public String getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(String overdraft) {
		this.overdraft = overdraft;
	}
	public String getStandingOrder() {
		return standingOrder;
	}
	public void setStandingOrder(String standingOrder) {
		this.standingOrder = standingOrder;
	}
	public double getMinBalance() {
		return minBalance;
	}
	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	public double getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}
	public double getDailyWithdrawalLimit() {
		return dailyWithdrawalLimit;
	}
	public void setDailyWithdrawalLimit(double dailyWithdrawalLimit) {
		this.dailyWithdrawalLimit = dailyWithdrawalLimit;
	}	
}
