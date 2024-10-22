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
import com.admin.model.Farmer;
import com.admin.services.AdminFarmerService;

@RestController
@RequestMapping("/admin")
public class AdminFarmerController {

	@Autowired
	AdminFarmerService service;

//	 Endpoint to retrieve all farmers
	@GetMapping("/showAllFarmers")
	public List<Farmer> getFamer() {
		// Call the service layer to fetch the list of farmers
		return service.getFarmer();
	}

 
//	 Endpoint to retrieve all farmers by ID
	@GetMapping("/showFarmersById/{farmerId}")
	public Farmer getFarmer(@PathVariable int farmerId) {
		// Call the service layer to fetch the list of farmers by ID
		return service.getFarmer(farmerId);
	}

	
//	@PostMapping("/addFarmers")
//	public String addFarmer(@RequestBody Farmer farmer) {
//		  service.addFarmer(farmer);
//		  return "Added successfully...";
//	}

 
//	@PutMapping("/updateFarmersById/{farmerId}")
//	public String updateFarmer(@PathVariable int farmerId, @RequestBody Farmer updatedFarmer) {
//		return service.updateFarmer(farmerId, updatedFarmer);
//	}
//
////	delete dealer
////	jab admin dealer ko delete karega to uski bookings delete ho jani chahiye aur crop ka status booked se unsold ho jana chahiye
//	@DeleteMapping("/deleteDelarById/{dealerId}")
//	public String deleteDealer(@PathVariable int dealerId) {
//		return service.deleteDealer(dealerId);
//	}
}
