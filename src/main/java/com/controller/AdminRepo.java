package com.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo extends JpaRepository <Admin,String >{
	@Query("select admin from Admin admin where admin.aname=?1")
	public Admin findByaName(String name);
	
	

}