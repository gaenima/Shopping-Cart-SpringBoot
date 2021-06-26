package com.springbootshoppingcart.models.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Roles")
public class Rol {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    @Column(length=45,nullable=false,unique=true)
	public Long getId() {
		return id;
	}
    
    @ManyToMany
	private Set<User> users;
	
    
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    
}
