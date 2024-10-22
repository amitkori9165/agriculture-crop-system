package com.dealers.controller;

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

import com.dealers.model.DealersBooking;
import com.dealers.service.DealersBookingServices;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/dealers")
public class DealersBookingController {

	@Autowired
	DealersBookingServices services;

//	 Endpoint to retrieve bookings by dealer ID
	@GetMapping("/showBookingsById/{dealerId}")
	public List<DealersBooking> getBookings(@Valid @PathVariable int dealerId) {
		// Call the service layer to fetch bookings by dealer ID
		return services.getBookings(dealerId);
	}

//	 Endpoint to add bookings
	@PostMapping("/addBookings")
	public String addBooking(@Valid @RequestBody DealersBooking booking) {
		// Call the service layer to add bookings
		return services.addBooking(booking);		
	}
	
//	 Endpoint to delete bookings by booking dealer ID and Booking ID
	@DeleteMapping("/deleteBookingById/{dealerId}/{bookingId}")
	public String deleteBooking(@Valid @PathVariable int dealerId, @PathVariable int bookingId) {
		// Call the service layer to delete bookings by dealer ID and Booking ID
		return services.deleteBooking(dealerId,bookingId);
	}
}
