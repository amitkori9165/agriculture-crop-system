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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class FarmerServicesImplTestDelete {
	 @InjectMocks
	    private FarmerServicesImpl farmerServices;

	    @Mock
	    private FarmerRepository farmerRepo;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }
	    @Test
	    void testDeleteFarmerWhenExists() {
	        when(farmerRepo.findById(1)).thenReturn(Optional.of(new Farmer()));

	        String result = farmerServices.deleteFarmer(1);

	        assertEquals("Farmer removed from the database....!", result);
	        verify(farmerRepo, times(1)).deleteById(1);
	    }

	    @Test
	    void testDeleteFarmerWhenNotExists() {
	        when(farmerRepo.findById(1)).thenReturn(Optional.empty());

	        Exception exception = assertThrows(FarmerNotFoundException.class, () -> {
	            farmerServices.deleteFarmer(1);
	        });

	        assertEquals("Farmer with ID: 1 is not present in database...!", exception.getMessage());
	    }

	    @Test
	    void testDeleteAllFarmers() {
	        String result = farmerServices.deleteFarmer();

	        assertEquals("All farmers are removed from database...!", result);
	        verify(farmerRepo, times(1)).deleteAll();
	    }

}
