package com.pabs.app.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyConversionBean {
	
	
	@Id
	private Long id;
	private String curr_from;
	private String curr_to;
	private BigDecimal quantity;
	private BigDecimal conversionRate;
	private BigDecimal totalConvertedAmount;
	private int port;
	
	public CurrencyConversionBean() {
		
	}
	
	
	public CurrencyConversionBean(Long id, String curr_from, String curr_to, BigDecimal quantity,
			BigDecimal conversionRate, BigDecimal totalConvertedAmount,int port) {
		super();
		this.id = id;
		this.curr_from = curr_from;
		this.curr_to = curr_to;
		this.quantity = quantity;
		this.conversionRate = conversionRate;
		this.totalConvertedAmount = totalConvertedAmount;
		this.port=port;
	}


	public String getCurr_from() {
		return curr_from;
	}

	public void setCurr_from(String curr_from) {
		this.curr_from = curr_from;
	}

	public String getCurr_to() {
		return curr_to;
	}

	public void setCurr_to(String curr_to) {
		this.curr_to = curr_to;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}


	public BigDecimal getConversionRate() {
		return conversionRate;
	}


	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}


	public BigDecimal getTotalConvertedAmount() {
		return totalConvertedAmount;
	}


	public void setTotalConvertedAmount(BigDecimal totalConvertedAmount) {
		this.totalConvertedAmount = totalConvertedAmount;
	}


	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}
	
}
