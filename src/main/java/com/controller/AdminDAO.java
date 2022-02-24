package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminDAO {

	@Autowired
	AdminRepo aRepo;

	// insert a objects
	public Admin insert(Admin a) {
		return aRepo.save(a);
	}

	public Admin getByaName(String aname) {
		return aRepo.findByaName(aname);

	}

	// update

	public Admin changepassword(Admin a) {

		Admin existing = aRepo.findByaName(a.getAname());
		existing.setPwd(a.getPwd());
		return aRepo.save(existing);

	}

}
