package com.farmerstest;

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

public class FarmerServicesImplTestGet {
	
	 @InjectMocks
	    private FarmerServicesImpl farmerServices;

	    @Mock
	    private FarmerRepository farmerRepo;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }
	    @Test
	    void testGetFarmerWhenFarmersExist() {
	        List<Farmer> farmerList = new ArrayList<>();
	        farmerList.add(new Farmer()); // Add a mock Farmer

	        when(farmerRepo.findAll()).thenReturn(farmerList);

	        List<Farmer> result = farmerServices.getFarmer();

	        assertEquals(1, result.size());
	        verify(farmerRepo, times(1)).findAll();
	    }

	    @Test
	    void testGetFarmerByIdWhenExists() {
	        Farmer farmer = new Farmer();
	        farmer.setFarmerId(1);

	        when(farmerRepo.findById(1)).thenReturn(Optional.of(farmer));

	        Optional<Farmer> result = farmerServices.getFarmer(1);

	        assertTrue(result.isPresent());
	        assertEquals(1, result.get().getFarmerId());
	        verify(farmerRepo, times(1)).findById(1);
	    }

	    @Test
	    void testGetFarmerByIdWhenNotExists() {
	        when(farmerRepo.findById(1)).thenReturn(Optional.empty());

	        Exception exception = assertThrows(FarmerNotFoundException.class, () -> {
	            farmerServices.getFarmer(1);
	        });

	        assertEquals("Farmer with ID: 1 is not present in database...!", exception.getMessage());
	    }

}

