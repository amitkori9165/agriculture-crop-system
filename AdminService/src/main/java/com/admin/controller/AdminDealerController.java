package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.model.Dealer;
import com.admin.services.AdminDealerService;

@RestController
@RequestMapping("/admin")
public class AdminDealerController {
	
	@Autowired
	AdminDealerService service;

	
//	 Endpoint to retrieve all dealers 
	@GetMapping("/showAllDealers")
	public List<Dealer> getDealer(){
		// Call the service layer to fetch the list of dealers
		return service.getDealer();
	}
	
//	 Endpoint to retrieve all dealers by dealer ID
	@GetMapping("/showDealersById/{dealerId}")
	public Dealer getDealer(@PathVariable int dealerId) {
		// Call the service layer to fetch the list of dealers by ID
		return service.getDealer(dealerId);
	}
	
//	add dealer
//	@PostMapping("/addDealers")
//	public String addDealer(@RequestBody Dealer dealer) {
//		return service.addDealer(dealer);
//	}
	
//	update dealer
//	@PutMapping("/updateDealersById/{dealerId}")
//	public String updateDealer(@PathVariable int dealerId, @RequestBody Dealer updatedDealer) {
//		return service.updateDealer(dealerId,updatedDealer);
//	}
	
//	delete dealer
//	jab admin dealer ko delete karega to uski bookings delete ho jani chahiye aur crop ka status booked se unsold ho jana chahiye
//	@DeleteMapping("/deleteDelarById/{dealerId}")
//	public String deleteDealer(@PathVariable int dealerId) {
//		return service.deleteDealer(dealerId);
//	}
	
}
