package edu.zipcloud.cloudstreetmarket.core.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import edu.zipcloud.cloudstreetmarket.core.entities.Product;

@XStreamAlias("product")
public class ProductOverviewDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String code;
	private String name;
	private String market;
	private String currency;
	private BigDecimal latestValue;
	private BigDecimal latestChange;
	private BigDecimal latestChangePercent;
	private BigDecimal prevCloase;
	private BigDecimal high;
	private BigDecimal low;
	
	public ProductOverviewDTO() {}

	public ProductOverviewDTO(String code, String name, String market, String currency, BigDecimal latestValue,
			BigDecimal latestChange, BigDecimal latestChangePercent, BigDecimal prevCloase, BigDecimal high,
			BigDecimal low) {
		super();
		this.code = code;
		this.name = name;
		this.market = market;
		this.currency = currency;
		this.latestValue = latestValue;
		this.latestChange = latestChange;
		this.latestChangePercent = latestChangePercent;
		this.prevCloase = prevCloase;
		this.high = high;
		this.low = low;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getLatestValue() {
		return latestValue;
	}

	public void setLatestValue(BigDecimal latestValue) {
		this.latestValue = latestValue;
	}

	public BigDecimal getLatestChange() {
		return latestChange;
	}

	public void setLatestChange(BigDecimal latestChange) {
		this.latestChange = latestChange;
	}

	public BigDecimal getLatestChangePercent() {
		return latestChangePercent;
	}

	public void setLatestChangePercent(BigDecimal latestChangePercent) {
		this.latestChangePercent = latestChangePercent;
	}

	public BigDecimal getPrevCloase() {
		return prevCloase;
	}

	public void setPrevCloase(BigDecimal prevCloase) {
		this.prevCloase = prevCloase;
	}

	public BigDecimal getHigh() {
		return high;
	}

	public void setHigh(BigDecimal high) {
		this.high = high;
	}

	public BigDecimal getLow() {
		return low;
	}

	public void setLow(BigDecimal low) {
		this.low = low;
	}
	
	public static ProductOverviewDTO build(Product product){
		return new ProductOverviewDTO(
				product.getCode(), 
				product.getName(), 
				product.getMarket().getName(), 
				product.getCurrency(), 
				product.getDailyLatestValue(), 
				product.getDailyLatestChange(),
				product.getDailyLatestChangePercent(),
				product.getPreviousClose(), 
				product.getHigh(), 
				product.getLow());
	}
}
