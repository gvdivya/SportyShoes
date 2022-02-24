package com.controller;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class Product{
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	 int pid;
	
	 String pname;
	 String gender;
	 int price;
	
	 @ToString.Exclude
	 @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	    @JoinColumn(name = "c_id", referencedColumnName = "cid")
	    @JsonIgnoreProperties("productList")
	    Categories categories;
	 
	

}
