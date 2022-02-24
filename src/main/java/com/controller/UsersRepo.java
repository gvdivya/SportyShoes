package com.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepo extends JpaRepository <Users,Integer >{
	@Query("select users from Users users where users.name=?1")
	public   Users findByName(String name);

}
