package com.pabs.app.feign.proxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pabs.app.entity.CurrencyConversionBean;

//@FeignClient(name="currency-exchange-service",url="localhost:8000")  //this model is used when Ribbon is not configured
@FeignClient(name="currency-exchange-service") // here URL is not used since Ribbon decides which URL to be invoked 
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to);

}
