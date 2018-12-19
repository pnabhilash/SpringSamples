package com.pabs.app.controller;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import com.pabs.app.entity.CurrencyConversionBean;
import com.pabs.app.feign.proxies.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionServiceController {
	
	@GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrrency
	(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		Map<String, String> uriVariables = new HashMap<String,String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		/*
		 * Though ExchangeService is returning ExchangeValue bean there are few fields which stands mapped with 
		 * CurrencyConversionBean (such as from,to,conversionRate etc).
		 * 
		 * In other cases we need to do explicit mapping such totalConvertedAmount with quantity.multiply(response.getConversionRate())
		 * 
		 */

		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);

		CurrencyConversionBean response = responseEntity.getBody();

		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionRate(), quantity,
				quantity.multiply(response.getConversionRate()), response.getPort());
		
		
	}
	/*
	 * Feign Tools helps to resolve following issues :
	 * Feign provides an abstractions over REST-based calls via annotation by which MS communicate with other.
	 * A declarative web service - makes web service client calls easier.
	 * Spring Cloud integrates Ribbon and Eureka LB. 
	 * 
	 * 
	 * Step 1 : At starter level class - add @EnableFeignClients("com.pabs.app") (respective package name for comp scan)
	 * Step 2 : Define a Client Proxy interface with @FeinClient annotation by providing Client Service application name 
	 *          and Server with port no.
	 * Step 3:  In the above interface define the rest service method exposed by the Service Client Rest Controller
	 *          (The only difference would be the return object would be of Receiving end server bean.
	 *          
	 * Step :4  Come to the controller and Autowired the above defined interface.                    
	 * 
	 * 
	 */

	
	
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
	
	
	@GetMapping("currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrrencyFeign
	(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		Map<String, String> uriVariables = new HashMap<String,String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		/*
		 * Though ExchangeService is returning ExchangeValue bean there are few fields which stands mapped with 
		 * CurrencyConversionBean (such as from,to,conversionRate etc).
		 * 
		 * In other cases we need to do explicit mapping such totalConvertedAmount with quantity.multiply(response.getConversionRate())
		 * 
		 */

		

		CurrencyConversionBean response = currencyExchangeServiceProxy.retrieveExchangeValue(from, to);

		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionRate(), quantity,
				quantity.multiply(response.getConversionRate()), response.getPort());
		
		
	}
	
	
}
