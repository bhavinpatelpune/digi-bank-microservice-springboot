package com.payments.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author : Bhavin Patel 
 * @Date   : 25-02-2021
 * @Details: Account summary entity class to use for DAO operation 
 */

@Entity
public class AccountSummary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String idCustomer;
	
	private String customerName;
	private String accountNumber;
	private String tranactionRefNo;
	private String transactionDesc;
	
	private String StatementMonth;
	private String StatementYear;
	
	private String debit;
	private String credit;
	
	private Date txnValueDate;
	private Date startDate;
	private Date endDate;
	
	private String currency;
	private double openingBalance;
	private double closingBalance;
	private double availableBalance;
	
	protected AccountSummary() {}
	
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
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getTranactionRefNo() {
		return tranactionRefNo;
	}
	public void setTranactionRefNo(String tranactionRefNo) {
		this.tranactionRefNo = tranactionRefNo;
	}
	public String getTransactionDesc() {
		return transactionDesc;
	}
	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}
	public String getStatementMonth() {
		return StatementMonth;
	}
	public void setStatementMonth(String statementMonth) {
		StatementMonth = statementMonth;
	}
	public String getStatementYear() {
		return StatementYear;
	}
	public void setStatementYear(String statementYear) {
		StatementYear = statementYear;
	}
	public String getDebit() {
		return debit;
	}
	public void setDebit(String debit) {
		this.debit = debit;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public Date getTxnValueDate() {
		return txnValueDate;
	}
	public void setTxnValueDate(Date txnValueDate) {
		this.txnValueDate = txnValueDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}
	public double getClosingBalance() {
		return closingBalance;
	}
	public void setClosingBalance(double closingBalance) {
		this.closingBalance = closingBalance;
	}
	public double getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}
	
}