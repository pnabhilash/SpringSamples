/*
 * This is another method of creating repository. There is another way of creating repository with extending to
 * JPA Repository. Please refer the other program called ExchangeValueEntityRepository
 */


package com.pabs.app.entityManagers;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pabs.app.entities.ExchangeValue;

@Repository
public class ExchangeValueEntityManager {
	
	@Autowired
	EntityManager entityManager;
	
	public ExchangeValue findExchangRate(String cur_from,String cur_to) {
		TypedQuery<ExchangeValue> exchangeValueQuery= entityManager.createNamedQuery("find_exchange_rate",ExchangeValue.class);
		exchangeValueQuery.setParameter("curr_frm", cur_from);		
		exchangeValueQuery.setParameter("curr_to", cur_to);
		return exchangeValueQuery.getSingleResult();
	}
	
	

}
