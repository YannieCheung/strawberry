package edu.zipcloud.cloudstreetmarket.core.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 指数报价
 * @author Urumi
 *
 */
@Entity
@Table(name="index_quote")
public class IndexQuote extends Quote implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8489961093558359651L;
	/**指数**/
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="index_code")
	private Index index;

	public Index getIndex() {
		return index;
	}

	public void setIndex(Index index) {
		this.index = index;
	}
	
	
}
