package com.farmers.controller;

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

import com.farmers.model.FarmersCrop;
import com.farmers.service.FarmersCropServices;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
//@Validated
@RequestMapping("/farmers")
public class FarmersCropController {
	
	@Autowired
	FarmersCropServices services;
	
	
//	 Endpoint to retrieve all crops
	@GetMapping("/showAllCrops")
	public List<FarmersCrop> getCrops(){
		// Call the service layer to fetch the list of crops
		return services.getCrops();
				
	}
	
//	@GetMapping("/showCropsById/{id}")
//	public Crop getCrops(@Valid @PathVariable int id) {
//		return services.getCrops(id);
//	}
//	
//	@GetMapping("/showCropsByName/{name}")
//	public Optional<Crop> getCrops(@Valid @PathVariable String name) {
//		
//		return services.getCrops(name);
//	}
//	
//	@GetMapping("/showCropsByQuantity/{quantity}")
//	public List<Crop> getCropsByQuantity(@Valid @PathVariable int quantity){
//		
//		return services.getCropsByQuantity(quantity);
//	}

//	 Endpoint to add crops
	@PostMapping("/addCrops")
	public String addCrop(@Valid @RequestBody FarmersCrop crop) {
		// Call the service layer to add crops
		return services.addCrop(crop);
		
	}
	
//	Endpoint to update crops by crop ID and farmer ID
	@PutMapping("/updateCropsById/{cropId}/{farmerId}")
	public String updateCrop(@PathVariable int cropId,@PathVariable int farmerId,@RequestBody FarmersCrop updatedCrop) {
		// Call the service layer to update crop by crop ID and farmer ID
		return services.updateCrop(cropId,farmerId, updatedCrop);
	}
//	
//	@PutMapping("/updateCropsByName/{name}")
//	public String updateCrop(@Valid @PathVariable String name,@Valid @RequestBody Crop updatedCrop) {
//		
//		return services.updateCrop(name,updatedCrop);
//	}
//	
//	@DeleteMapping("/deleteCropsByName/{name}")
//	public String delete(@Valid @PathVariable String name) {
//		return services.delete(name);
//	}

//	Endpoint to delete crops by crop ID and farmer ID
	@DeleteMapping("/deleteCropsById/{cropId}/{farmerId}")
	public String delete(@Valid @PathVariable int cropId,@Valid @PathVariable int farmerId ) {
		// Call the service layer to delete crop by crop ID and farmer ID
		return services.delete(cropId, farmerId);
	}
//	
//	@DeleteMapping("/deleteAllCrops")
//	public String delete() {
//		return services.delete();
//	}

}
