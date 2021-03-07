package com.demo.springbatch;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbatchdemoApplicationTests {

	@Autowired
	JobLauncher launcher;
	
	@Autowired
	private Job job;
	
	@Test
	public void testBatch() throws JobExecutionAlreadyRunningException, 
								   JobRestartException, 
								   JobInstanceAlreadyCompleteException, 
								   JobParametersInvalidException {
		launcher.run(job, new JobParametersBuilder().addLong("time",System.currentTimeMillis()).toJobParameters());
	}

}
