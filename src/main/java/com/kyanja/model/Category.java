package com.kyanja.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
 
@Entity
@Table(name = "category")
public class Category implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")  
    private Long id;
    private String name;
 
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    @OneToMany(mappedBy = "category",fetch=FetchType.LAZY)
    private Set<Product> products;
 
    public Category() {
    }
 
    public Category(String name) {
        this.name = name;
    }
 
 
  
 
 
   
    public Set<Product> getProducts() {
        return products;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Category(long id, String name, Set<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
 
    // other getters and setters
	
	
	
}
