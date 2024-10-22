package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.model.Admin;
import com.admin.model.Crop;
import com.admin.model.Dealer;
import com.admin.model.Farmer;
import com.admin.services.AdminService;

import jakarta.validation.Valid;

//@RestController
@Validated
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService ser;
//	
////	 Endpoint to retrieve all admins
//	@GetMapping("/show")
//	public List<Admin> getAdmin(){
//		return ser.getAdmin();
//				
//	}
//	
//	@PostMapping("/addAdmin")
//	public String addAdmin( Admin a) {
//		return ser.addAdmin(a);
//	}
//	
//	@DeleteMapping("/delete")
//	public String deleteAdmin() {
//		return ser.deleteAdmin();
//	}
	
}
