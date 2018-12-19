/**
 * 
 */
package com.pabs.app.entityManagers;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pabs.app.entities.ExchangeValue;

/**
 * @author peethanabhilash
 *
 */
public interface ExchangeValueEntityRepository extends JpaRepository<ExchangeValue, Long> {
	
	ExchangeValue findExchangeByFromAndTo(String from,String to);

}
