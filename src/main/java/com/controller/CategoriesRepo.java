package com.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriesRepo extends JpaRepository <Categories,Integer >{
	@Query("select categories from Categories categories where categories.cname=?1")
	public   Categories findByCategoriesName(String name);

	@Query("select categories from Categories categories where categories.cname=?1")
	public   List<Categories> findAllByCategoriesName(String name);
}
