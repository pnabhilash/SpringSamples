package com.pabs.app.entityManagers;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pabs.app.CurrencyExchangeServiceApplication;
import com.pabs.app.entities.ExchangeValue;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=CurrencyExchangeServiceApplication.class)
public class ExchangeValueEntityManagerTest {
	
	@Autowired
	ExchangeValueEntityManager exchangeValueEntityManager;

	@Test
	public void testCurrencyExchange() {
		ExchangeValue exchangeValue=exchangeValueEntityManager.findExchangRate("USD", "INR");
		assertNotNull(exchangeValue);
		System.out.println("ExchangeValueEntityManagerTest.testCurrencyExchange()"+exchangeValue);
	}

}
