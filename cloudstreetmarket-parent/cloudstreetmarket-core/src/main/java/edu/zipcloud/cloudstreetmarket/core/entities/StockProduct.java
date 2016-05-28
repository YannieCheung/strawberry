package edu.zipcloud.cloudstreetmarket.core.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="stock_product")
public class StockProduct extends Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6449185669040274522L;
	
	private String currency;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
