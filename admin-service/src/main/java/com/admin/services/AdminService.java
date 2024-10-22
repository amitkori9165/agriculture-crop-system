package com.admin.services;



import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.admin.exception.AdminAlreadyLoginException;
import com.admin.exception.AdminNotFoundException;
import com.admin.model.Admin;
import com.admin.model.Crop;
import com.admin.model.Dealer;
import com.admin.model.Farmer;
import com.admin.repo.AdminRepo;

import jakarta.validation.Valid;

@Service
public class AdminService  {
	@Autowired //for automatic dependency injection, no need manual bean configuration.
	AdminRepo repo;
	
	public List<Admin> getAdmin() {
		List<Admin> admin = repo.findAll();
		if(admin.isEmpty())
			throw new AdminNotFoundException("No Admin login at this moment.");
			return repo.findAll();
	}
	
	public String addAdmin(@Valid @RequestBody Admin a) {
		List<Admin> admin = repo.findAll();
		if(!admin.isEmpty())
			throw new AdminAlreadyLoginException("Admin already login");
		repo.save(a);
		return "Admin added successfully";
		
	}
	
	public String deleteAdmin() {
		List<Admin> admin = repo.findAll();
		if(admin.isEmpty())
			throw new AdminNotFoundException("No Admin login at this moment.");
		repo.deleteAll();
		return "Admin deleted successfully";
		
	}

	
	
	
}
