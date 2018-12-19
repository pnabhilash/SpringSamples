 package com.pabs.app.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name="find_exchange_rate",query="Select e from ExchangeValue e Where e.from= :curr_frm and e.to= :curr_to")
public class ExchangeValue {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="currency_from")
	private String from;
	
	@Column(name="currency_to")
	private String to;
	
	private BigDecimal conversionRate;
	
	private int port;
	

	public BigDecimal getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}

	public ExchangeValue() {
	
	}

	public ExchangeValue(Long id, String from, String to,BigDecimal conversionRate) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionRate=conversionRate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	
	public void setPort(int port) {
		this.port = port;
	}
	
	public int getPort() {
		return port;
	}

	@Override
	public String toString() {
		return String.format("ExchangeValue [id=%s, from=%s, to=%s, conversionRate=%s, port=%s]", id, from, to,
				conversionRate, port);
	}
	

}
