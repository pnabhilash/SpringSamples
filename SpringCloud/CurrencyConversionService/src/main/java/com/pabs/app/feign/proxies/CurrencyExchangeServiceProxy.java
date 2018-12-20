package com.pabs.app.feign.proxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pabs.app.entity.CurrencyConversionBean;

//@FeignClient(name="currency-exchange-service",url="localhost:8000")  //this model is used when Ribbon is not configured
//@FeignClient(name="currency-exchange-service") // here URL is not used since Ribbon decides which URL to be invoked 

/*
 * Now since we have configured Zuul as API Gate way we need to deroute our app call via Zuul server.
 * hence we need to configure Zuul application service name need to be provided instead of direct consuming service.
 * 
 * @FeignClient(name="netflix-zuul-api-gateway-server") 
 * 
 * Secondly the URL details for @GetMapping alos needs modification. it is as below.
 * 
 *  /{Application-Name}/{/URL}
 * /{ConsumingServerApplictionName}/{ConsumingServiceMapping URL}.
 * 
 * Thus it turns out to be as follows :
 * http://localhost:8765/currency-conversion-service/currency-converter-feign/from/EUR/to/INR/quantity/1500
 * 
 * Essentially we are saying Feign to connect to API Server - and from API Server find out the service name we need 
 * and then rest method exposed
 * 
 */
 

@FeignClient(name="netflix-zuul-api-gateway-server")  
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	//@GetMapping("currency-exchange/from/{from}/to/{to}")
	@GetMapping("currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to);

}
