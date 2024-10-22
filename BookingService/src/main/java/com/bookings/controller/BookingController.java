package com.bookings.controller;

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

import com.bookings.model.Booking;
import com.bookings.service.BookingServices;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/bookings")
public class BookingController {
	
	@Autowired
	BookingServices services;
	
//	 Endpoint to retrieve all bookings
	@GetMapping("/showAllBookings")
	public List<Booking> getBookings(){
		// Call the service layer to fetch the list of bookings
		return services.getBookings();
	}
	
//	 Endpoint to retrieve bookings by ID
	@GetMapping("/showBookingsById/{id}")
	public Optional<Booking> getBookings(@Valid @PathVariable int id) {
		// Call the service layer to fetch bookings by ID
		return services.getBookings(id);
	}
	
//	 Endpoint to add bookings
	@PostMapping("/addBookings")
	public String addBooking(@Valid @RequestBody Booking booking) {
		// Call the service layer to add bookings
		return services.addBooking(booking);
		
	}
	
//	 Endpoint to update bookings by booking id
	@PutMapping("/updateBookings/{id}")
	public String updateBooking(@Valid @PathVariable int id, @Valid @RequestBody Booking updatedBooking) {
		// Call the service layer to update booking by id
		return services.updateBooking(id,updatedBooking);
		
	}
	
//	 Endpoint to delete bookings by booking id
	@DeleteMapping("/deleteBookingsById/{id}")
	public String deleteBooking(@Valid @PathVariable int id) {
		// Call the service layer to delete booking by id
		return services.deleteBooking(id);
	}
	
//	 Endpoint to delete all the bookings
	@DeleteMapping("/deleteAllBookings")
	public String deleteBooking() {
		// Call the service layer to delete booking by id
		return services.deleteBooking();
	}
}
