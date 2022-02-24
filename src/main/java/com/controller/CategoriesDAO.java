package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.controller.StudentRepo;

@Service
public class CategoriesDAO {

	
	@Autowired
	CategoriesRepo crepo;
	//insert a objects
	public Categories insertcategory(Categories s) {
		return crepo.save(s);
	}
	
	//fetch a collection of objects
	public List <Categories> getallcategories(){
		return crepo.findAll();
		
	}
	//insert a collection of objects
	public List<Categories> insertAll(List<Categories> s){
		return crepo.saveAll(s);
	}

//fetch by using an id
	
	public Categories getBycid(int cid) {
		return crepo.findById(cid).orElse(null);
		
	}
	
	//detete by id
	
	public String deleteBycid(int cid) {
		crepo.deleteById(cid);
		return "deleted the id value" +cid;
		
	}
	
	//update
	
	public Categories editcategories(Categories c) {
		
		Categories existing=crepo.findById(c.getCid()).orElse(null);
		existing.setCname(c.getCname());
		return crepo.save(existing);
		
	}
	
	public List<Categories> findAllByCategoriesName(String name) {
		// TODO Auto-generated method stub
		return crepo.findAllByCategoriesName(name);
	}

		


	public Categories findByCategoriesName(String name) {
		// TODO Auto-generated method stub
		return crepo.findByCategoriesName(name);
	}

}
