package com.pabs.app.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pabs.app.entities.ExchangeValue;
import com.pabs.app.entityManagers.ExchangeValueEntityRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueEntityRepository exchangeValueEntityRepository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		/*
		 * This is the most direct and primary way of getting data for test purpose -Ignoring this now,
		 * since we got JPARepository defined.
		 * ExchangeValue exchangeValue=new ExchangeValue(101L,from,to,BigDecimal.valueOf(65));
		 */
		
		ExchangeValue exchangeValue=exchangeValueEntityRepository.findExchangeByFromAndTo(from, to);
		String runningPort=environment.getProperty("local.server.port");
		System.out.println("*************************** "+runningPort);
		exchangeValue.setPort(Integer.parseInt(runningPort));	
		return exchangeValue;		
	}
	
	

}
