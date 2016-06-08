package edu.zipcloud.cloudstreetmarket.core.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.zipcloud.cloudstreetmarket.core.enums.QuotesInterval;
/**
 * 历史记录表
 * @author Urumi
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "historic_type")
@Table(name="historic")
public abstract class Historic {
	
	private static final long serialVersionUID = -802306391915956578L;

	@Id
	@GeneratedValue
	private int id;
	/**开盘价**/
	private BigDecimal open;
	/**最高价**/
	private BigDecimal high;
	/**最低价**/
	private BigDecimal low;
	/**收盘价**/
	private BigDecimal close;
	/**量**/
	private double volume;
	/**经过调整后的收盘价**/
	@Column(name="adj_close")
	private BigDecimal adjClose;
	/**百分比**/
	@Column(name="change_percent")
	private double changePercent;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="from_date")
	private Date fromDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="to_date")
	private Date toDate;
	/**时间间隔**/
	@Enumerated(EnumType.STRING)
	@Column(name="quotes_interval")
	private QuotesInterval interval;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getOpen() {
		return open;
	}

	public void setOpen(BigDecimal open) {
		this.open = open;
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

	public BigDecimal getClose() {
		return close;
	}

	public void setClose(BigDecimal close) {
		this.close = close;
	}

	public BigDecimal getAdjClose() {
		return adjClose;
	}

	public void setAdjClose(BigDecimal adjClose) {
		this.adjClose = adjClose;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public QuotesInterval getInterval() {
		return interval;
	}

	public void setInterval(QuotesInterval interval) {
		this.interval = interval;
	}

	public double getChangePercent() {
		return changePercent;
	}

	public void setChangePercent(double changePercent) {
		this.changePercent = changePercent;
	}

}
