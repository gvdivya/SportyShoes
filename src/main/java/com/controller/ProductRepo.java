package com.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository <Product,Integer >{
	@Query("select product from Product product where product.pname=?1")
	public    Product findByPname(String pname);

}
