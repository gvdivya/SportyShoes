package com.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
public class Users{
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	 int uid;
	 String name;
	 String email;

}
