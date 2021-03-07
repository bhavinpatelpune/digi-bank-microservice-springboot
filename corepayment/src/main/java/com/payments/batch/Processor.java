package com.payments.batch;

import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		System.out.println("Inside Process Class");
		return "PROCESSED - " + item.toUpperCase();
	}

}
