package com.demo.springbatch.config;


import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.demo.springbatch.model.Account;

@Configuration
public class BatchConfig {
	
	@Autowired
	private StepBuilderFactory sbf;
	
	@Autowired
	private JobBuilderFactory jbf;
	
	@Bean
	public Job job() {
		return jbf.get("job1")
				  .incrementer(new RunIdIncrementer())
				  .start(step())
				  .build();
	}
	
	@Bean
	public Step step() {
		return sbf.get("step1")
				  .<Account,Account>chunk(3)
				  .reader(reader())
				  .processor(processor())
				  .writer(writer())
				  .build();
	}
	
	@Bean
	public ItemReader<Account> reader(){
		FlatFileItemReader<Account> reader = new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("accounts.csv"));
		
		DefaultLineMapper<Account> linemapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("accountNumber","accountType","accountStatus");
		
		BeanWrapperFieldSetMapper<Account> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Account.class);
		
		linemapper.setLineTokenizer(lineTokenizer);
		linemapper.setFieldSetMapper(fieldSetMapper);
		
		reader.setLineMapper(linemapper);
		
		return reader;
	}
	
	@Bean
	public ItemProcessor<Account, Account> processor(){
		return (a)-> {
			a.setBalance(a.getBalance() + 100);
			return a;
		};
	}
	
	@Bean
	public ItemWriter<Account> writer(){
		JdbcBatchItemWriter<Account> writer = new JdbcBatchItemWriter<>();
		writer.setDataSource(dataSource());
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Account>());
		writer.setSql("INSERT INTO account(accountnumber,accounttype,accountstatus,balance) VALUES(:accountNumber,:accountType,:accountStatus,:balance)");
		
		return writer;		
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/digibank");
		datasource.setUsername("root");
		datasource.setPassword("password");
		return datasource;
	}

}
