package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class Categories{
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cid")
	int cid;
	
	
	@Column(name = "cname" ,unique=true, nullable = false)
	String cname;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "categories", 
			cascade = CascadeType.DETACH)
    @JsonIgnoreProperties("categories")
    List<Product> productList = new ArrayList<>();

}
