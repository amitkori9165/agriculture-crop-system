package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.model.Booking;
import com.admin.services.AdminBookingService;

@RestController
@RequestMapping("/admin")
public class AdminBookingController {

	@Autowired
	AdminBookingService bookingServices;

//	 Endpoint to retrieve all bookings
	@GetMapping("/showAllBookings")
	public List<Booking> getBookings() {
		// Call the service layer to fetch the list of bookings
		return bookingServices.getBookings();
	}

//	 Endpoint to retrieve bookings by booking ID
	@GetMapping("/showBookingById/{bookingId}")
	public Booking getBookings(@PathVariable int bookingId) {
		// Call the service layer to fetch the list of bookings with ID
		return bookingServices.getBookings(bookingId);
	}

//	 Endpoint to approving bookings by booking ID
	@PutMapping("/approveBookingById/{bookingId}")
	public String approveBooking(@PathVariable int bookingId) {
		// Call the service layer to approve the bookings 
		return bookingServices.updateBooking(bookingId);
	}

//	 Endpoint to declining bookings by booking ID
	@PutMapping("/declineBookingById/{bookingId}")
	public String declineBooking(@PathVariable int bookingId) {
		// Call the service layer to decline the bookings 
		return bookingServices.declineBooking(bookingId);
	}
}
