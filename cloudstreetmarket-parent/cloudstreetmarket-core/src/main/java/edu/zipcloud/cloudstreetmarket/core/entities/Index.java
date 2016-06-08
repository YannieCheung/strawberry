package edu.zipcloud.cloudstreetmarket.core.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 指数
 * @author Urumi
 *
 */
@Entity
@Table(name="index_value")
public class Index implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6615072632752778333L;
	/**指数代码**/
	@Id
	private String code;
	/**值数名称**/
	private String name;
	/**每日最新指数**/
	@Column(name="daily_latest_value")
	private BigDecimal dailyLatestValue;
	/**每日最新指数变动**/
	@Column(name="daily_latest_change")
	private BigDecimal dailyLatestChange;
	/**每日变动百分比**/
	@Column(name="daily_latest_change_pc")
	private BigDecimal dailyLatestChangePercent;
	/**前交易日收盘指数**/
	@Column(name="previous_close")
	private BigDecimal previousClose;
	/**指数最高值**/
	private BigDecimal high;
	/**指数最低值**/
	private BigDecimal low;
	/**市场**/
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="market_id",nullable=true)
	private Market market;
	/**股票**/
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="stock_indices",joinColumns={@JoinColumn(name="index_code")},
			inverseJoinColumns={@JoinColumn(name="stock_code")})
	private Set<StockProduct> stocks = new LinkedHashSet<>();

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

	public Market getMarket() {
		return market;
	}

	public void setMarket(Market market) {
		this.market = market;
	}

	public Set<StockProduct> getStocks() {
		return stocks;
	}

	public void setStocks(Set<StockProduct> stocks) {
		this.stocks = stocks;
	}

	public BigDecimal getDailyLatestValue() {
		return dailyLatestValue;
	}

	public void setDailyLatestValue(BigDecimal dailyLatestValue) {
		this.dailyLatestValue = dailyLatestValue;
	}

	public BigDecimal getDailyLatestChange() {
		return dailyLatestChange;
	}

	public void setDailyLatestChange(BigDecimal dailyLatestChange) {
		this.dailyLatestChange = dailyLatestChange;
	}

	public BigDecimal getDailyLatestChangePercent() {
		return dailyLatestChangePercent;
	}

	public void setDailyLatestChangePercent(BigDecimal dailyLatestChangePercent) {
		this.dailyLatestChangePercent = dailyLatestChangePercent;
	}

	public BigDecimal getPreviousClose() {
		return previousClose;
	}

	public void setPreviousClose(BigDecimal previousClose) {
		this.previousClose = previousClose;
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
	
}
