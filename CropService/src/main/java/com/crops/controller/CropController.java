package com.crops.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crops.model.Crop;
import com.crops.service.CropServices;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/crops")
public class CropController {
	
	@Autowired
	CropServices services;
	
//	 Endpoint to retrieve all crops
	@GetMapping("/showAllCrops")
	public List<Crop> getCrops(){
		// Call the service layer to fetch the list of crops
		return services.getCrops();
				
	}
	
//	 Endpoint to retrieve crops by Id
	@GetMapping("/showCropsById/{id}")
	public Optional<Crop> getCrops(@Valid @PathVariable int id) {
		// Call the service layer to fetch the list of crops by Id
		return services.getCrops(id);
	}
	
//	 Endpoint to retrieve crops by name
	@GetMapping("/showCropsByName/{name}")
	public List<Crop> getCrops(@Valid @PathVariable String name) {
		// Call the service layer to fetch the list of crops by name
		return services.getCrops(name);
	}
	
//	 Endpoint to retrieve crops above the specified quantity
	@GetMapping("/showCropsByQuantity/{quantity}")
	public List<Crop> getCropsByQuantity(@Valid @PathVariable int quantity){
		// Call the service layer to fetch the list of crops above the specified quantity
		return services.getCropsByQuantity(quantity);
	}
	
//	 Endpoint to retrieve crops by booking ID
	@GetMapping("/showCropsByBookingId/{bookingId}")
	public Crop getCropsByBookingId(@Valid @PathVariable int bookingId) {
		// Call the service layer to fetch the list of crops
		return services.getCropsByBookingId(bookingId);
	}
	
//	 Endpoint to add crops
	@PostMapping("/addCrops")
	public String addCrop(@Valid @RequestBody Crop crop) {
		// Call the service layer to add crops
		return services.addCrop(crop);
		
	}
	
//	 Endpoint to update crops by crop ID
	@PutMapping("/updateCropsById/{id}")
	public String updateCrop(@Valid @PathVariable int id, @Valid @RequestBody Crop updatedCrop) {
		// Call the service layer to update crops
		return services.updateCrop(id, updatedCrop);
	}
	
//	 Endpoint to update crops by crop name
//	@PutMapping("/updateCropsByName/{name}")
//	public String updateCrop(@Valid @PathVariable String name,@Valid @RequestBody Crop updatedCrop) {
//		// Call the service layer to update crops by name
//		return services.updateCrop(name,updatedCrop);
//	}
	
//	@DeleteMapping("/deleteCropsByName/{name}")
//	public String delete(@Valid @PathVariable String name) {
//		return services.delete(name);
//	}
	
//	 Endpoint to delete crops by crop ID
	@DeleteMapping("/deleteCropsById/{id}")
	public String delete(@Valid @PathVariable int id) {
		// Call the service layer to delete crops by ID
		return services.delete(id);
	}
	
//	 Endpoint to delete all crops
	@DeleteMapping("/deleteAllCrops")
	public String delete() {
		// Call the service layer to delete all crops
		return services.delete();
	}
	
//	@DeleteMapping("/deleteByBookingId")

}
