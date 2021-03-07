package com.payments.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Reader implements ItemReader<String> {
	
	private String[] acctType = {"Saving","Current","Fixed"};
	private int count;

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("Inside Reader Method");
		if(count<acctType.length) {
			return acctType[count++];
		} else {
			count = 0;
		}
		return null;
	}

}
