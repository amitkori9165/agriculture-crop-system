package com.admintest;

//package com.admin_service;
import com.admin.controller.AdminController;
import com.admin.model.Admin;
import com.admin.services.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AdminControllerTestGet {
	 @InjectMocks
	    private AdminController adminController;

	    @Mock
	    private AdminService ser;

	    private Admin admin;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	        admin = new Admin(1, "adminUser", "adminPass");
	    }
//	    @Test
//	    void testGetAllAdmins() {
//	        List<Admin> admins = new ArrayList<>();
//	        admins.add(admin);
//
//	        when(ser.getAdmin()).thenReturn(admins);
//
//	        List<Admin> result = adminController.getAdmin();
//	        assertEquals(0, result.size());
//	        assertEquals(admin, result.get(0));
//	        verify(ser, times(1)).getAdmin();
//	    }
	    @Test
	    void testGetAllAdmins() {
	        List<Admin> admins = new ArrayList<>();
	        admins.add(admin);

	        when(ser.getAdmin()).thenReturn(admins);

	        List<Admin> result = adminController.getAdmin();
	        
	        // Check the size of the result list
	        assertEquals(1, result.size());
	        
	        // Check that the admin object has the correct properties
	        Admin returnedAdmin = result.get(0);
	        assertEquals(1, returnedAdmin.getId()); // Check that ID is an integer
	        assertEquals("adminUser", returnedAdmin.getUsername()); // Check username is a string
	        assertEquals("adminPass", returnedAdmin.getPassword()); // Check password is a string

	        // Verify that the service method was called
	        verify(ser, times(1)).getAdmin();
	    }
}

