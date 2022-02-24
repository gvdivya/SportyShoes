package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.controller.UsersRepo;

@Service
public class UsersDAO {

	
	@Autowired
	UsersRepo urepo;
	//insert a objects
	public Users insert(Users s) {
		return urepo.save(s);
	}
	
	//fetch a collection of objects
	public List <Users> getallusers(){
		return urepo.findAll();
		
	}
	
	public Users getByName(String name) {
		// TODO Auto-generated method stub
		return urepo.findByName(name);
	}
	
	
	//insert a collection of objects
	public List<Users> insertAll(List<Users> s){
		return urepo.saveAll(s);
	}

//fetch by using an id
	
	public Users getByid(int id) {
		return urepo.findById(id).orElse(null);
		
	}
	
	//detete by id
	
	public String deleteByid(int id) {
		urepo.deleteById(id);
		return "deleted the id value" +id;
		
	}
	


	

}
