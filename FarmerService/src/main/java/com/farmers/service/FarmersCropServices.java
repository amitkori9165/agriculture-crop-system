package com.farmers.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.farmers.exception.CropNotFoundException;
import com.farmers.exception.FarmerNotFoundException;
import com.farmers.model.FarmersCrop;
import com.farmers.model.Farmer;

import jakarta.validation.Valid;

@Service
public class FarmersCropServices {

	@Autowired
	FarmerServicesImpl services;
	@Autowired
	RestTemplate restTemplate;

	final String ROOT_URI = "http://localhost:8080/crops";

	public List<FarmersCrop> getCrops() {
		FarmersCrop[] cropsArr = restTemplate.getForEntity(ROOT_URI + "/" + "showAllCrops", FarmersCrop[].class).getBody();
		return Arrays.asList(cropsArr);
	}

	public String updateCrop(int cropId,int farmerId, FarmersCrop updatedCrop) {
		
//		checks whether the farmer is present in data base or not if not then throwing exception
		Optional<Farmer> farmer = services.getFarmer(farmerId);
		
		
		FarmersCrop[] cropsArr = restTemplate.getForEntity(ROOT_URI + "/" + "showAllCrops", FarmersCrop[].class).getBody();


		List<FarmersCrop> cropsList = Arrays.asList(cropsArr);
		for (FarmersCrop c : cropsList) {

			if ((c.getFarmerId() == farmerId) && (c.getCropId() == cropId)) {
				restTemplate.put(ROOT_URI + "/updateCropsById/" + c.getCropId(), updatedCrop);
				return "Crop updated successfully...!";
			}
		}
		throw new FarmerNotFoundException("No crop found for farmer ID: " + farmerId + " in database...!");
	}

	public String delete(@Valid int cropId, @Valid int farmerId) {
		
//		checks whether the farmer is present in data base or not if not then throwing exception		
		Optional<Farmer> farmer = services.getFarmer(farmerId);
		 
		FarmersCrop[] cropsArr = restTemplate.getForEntity(ROOT_URI + "/" + "showAllCrops", FarmersCrop[].class).getBody();

		List<FarmersCrop> cropsList = Arrays.asList(cropsArr);

		for (FarmersCrop crop : cropsList) {
			if ((crop.getCropId() == cropId) && (crop.getFarmerId() == farmerId)) {
				System.out.println("inside if condtions");
				restTemplate.delete(ROOT_URI + "/" + "deleteCropsById" + "/" + cropId);
				return "Crop deleted Successfully...!";
			}
		}
		throw new CropNotFoundException("Crop with ID: " + cropId + " for farmer ID: "+farmerId+" not found in database...!");
	}

	public String addCrop(@Valid FarmersCrop crop) {
		
		Optional<Farmer>  farmer = services.getFarmer(crop.getFarmerId());
		
		if(!farmer.isEmpty()) {
		restTemplate.postForLocation(ROOT_URI +"/addCrops", crop);
		return "Crop added successfully...";
		}else {
			throw new FarmerNotFoundException("Farmer with ID: "+crop.getFarmerId()+" not found in database...!");
		}
	}
}
