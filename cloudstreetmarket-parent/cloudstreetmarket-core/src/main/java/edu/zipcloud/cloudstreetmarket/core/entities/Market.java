package edu.zipcloud.cloudstreetmarket.core.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 市场
 * @author Urumi
 *
 */
@Entity
@Table(name="market")
public class Market implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5143236480872000036L;
	@Id
	private String id;
	
	private String name;
	
	@OneToMany(mappedBy="market",cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	private Set<Index> indices = new HashSet<Index>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Index> getIndices() {
		return indices;
	}

	public void setIndices(Set<Index> indices) {
		this.indices = indices;
	}
	
	

}
