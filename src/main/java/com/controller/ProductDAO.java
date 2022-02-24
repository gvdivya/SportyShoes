package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.controller.ProductRepo;

@Service
public class ProductDAO {

	
	@Autowired
	ProductRepo prepo;
	
	
	//insert a objects
	public Product insertproduct(Product p) {
		return prepo.save(p);
	}
	
	//fetch a collection of objects
	public List <Product> getallproducts(){
		return prepo.findAll();
		
	}
	

//fetch by using an id
	
	public Product getByproductid(int pid) {
		return prepo.findById(pid).orElse(null);
		
	}
	
	//detete by id
	
	public String deleteBypid(int pid) {
		prepo.deleteById(pid);
		return "deleted the id value" +pid;
		
	}
	
	//update
	
	public Product editproduct(Product p) {
		
		Product existing=prepo.findById(p.getPid()).orElse(null);
		existing.setPname(p.getPname());
		existing.setPrice(p.getPrice());
		existing.setGender(p.getGender());
		existing.setCategories(p.getCategories());
		return prepo.save(existing);
		
	}

	public Product findByName(String pname) {
		// TODO Auto-generated method stub
		return prepo.findByPname(pname);
	}

}
