package com.farmerstest;

import com.farmers.exception.FarmerAlreadyExistsException;
import com.farmers.exception.FarmerNotFoundException;
import com.farmers.model.Farmer;
import com.farmers.repository.FarmerRepository;
import com.farmers.service.FarmerServicesImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class FarmerServicesImplTestAdd {
	 @InjectMocks
	    private FarmerServicesImpl farmerServices;

	    @Mock
	    private FarmerRepository farmerRepo;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }
	    @Test
	    void testAddFarmerWhenNotExists() {
	        Farmer farmer = new Farmer();
	        farmer.setFarmerId(1);

	        when(farmerRepo.findAll()).thenReturn(new ArrayList<>());

	        String result = farmerServices.addFarmer(farmer);

	        assertEquals("Farmer added successfully...!", result);
	        verify(farmerRepo, times(1)).save(farmer);
	    }

	    @Test
	    void testAddFarmerWhenAlreadyExists() {
	        Farmer farmer = new Farmer();
	        farmer.setFarmerId(1);
	        List<Farmer> farmerList = new ArrayList<>();
	        farmerList.add(farmer);

	        when(farmerRepo.findAll()).thenReturn(farmerList);

	        Exception exception = assertThrows(FarmerAlreadyExistsException.class, () -> {
	            farmerServices.addFarmer(farmer);
	        });

	        assertEquals("Farmer with ID: 1 is already present in database...!", exception.getMessage());
	    }

	    @Test
	    void testUpdateFarmerWhenExists() {
	        Farmer updatedFarmer = new Farmer();
	        updatedFarmer.setFarmerId(1);

	        when(farmerRepo.findById(1)).thenReturn(Optional.of(new Farmer()));

	        String result = farmerServices.updateFarmer(1, updatedFarmer);

	        assertEquals("Farmer updated successfully...!", result);
	        verify(farmerRepo, times(1)).save(updatedFarmer);
	    }

	    @Test
	    void testUpdateFarmerWhenNotExists() {
	        Farmer updatedFarmer = new Farmer();

	        when(farmerRepo.findById(1)).thenReturn(Optional.empty());

	        Exception exception = assertThrows(FarmerNotFoundException.class, () -> {
	            farmerServices.updateFarmer(1, updatedFarmer);
	        });

	        assertEquals("Farmer with ID: 1 is not present in database...!", exception.getMessage());
	    }

}
