package com.bookings.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookings.exception.BookingAlreadyExistsException;
import com.bookings.exception.BookingNotFoundException;
import com.bookings.model.Booking;
import com.bookings.repository.BookingRepository;

import jakarta.validation.Valid;

@Service
public class BookingServices {
	
	@Autowired
	BookingRepository repo;

	public List<Booking> getBookings() {
		// TODO Auto-generated method stub
		
		List<Booking> bookingList =   repo.findAll();
		if(bookingList.isEmpty()) {
			throw new BookingNotFoundException("No bookings found in database...!");
		}
		return bookingList;
	}

	public Optional<Booking> getBookings(@Valid int id) {
		 
		Optional<Booking> booking = repo.findById(id);
		if(booking.isEmpty()) {
			throw new BookingNotFoundException("Booking with ID: "+id+" not found in database...!");
		}
		return booking;
	}

	public String addBooking(@Valid Booking booking) {
		
//		repo.save(booking);
		Optional<Booking> bookingFound = repo.findById(booking.getBookingId());
		if(!bookingFound.isEmpty()) {
			throw new BookingAlreadyExistsException("Booking ID: "+booking.getBookingId()+" already present in database...");
		}
		
//		agar kisi crop ki booking ho rakhi h to usko dobara book nhi karenge
		
		List<Booking>allBookings = repo.findAll();
		
		for(Booking b:allBookings) {
			
			if(b.getCropId() == booking.getCropId()) {
				throw new BookingAlreadyExistsException("Booking for crop ID: "+booking.getCropId()+" already present in database...!");
			}
		}
		
		repo.save(booking);
		return "Booking confirm...!"+" with Booking ID: "+booking.getBookingId();
	}

	public String updateBooking(@Valid int id, @Valid Booking updatedBooking) {
 
		Optional<Booking> booking =  repo.findById(id);
		if(booking.isEmpty()) {
			throw new BookingNotFoundException("Booking for ID: "+id+" not found in database...!");
		}
	    repo.save(updatedBooking);
	    return "Booking updated successfully...!";
		
	}

	public String deleteBooking(@Valid int id) {
		
		Optional<Booking> booking =  repo.findById(id);
		if(booking.isEmpty()) {
			throw new BookingNotFoundException("Booking for ID: "+id+" not found in database...!");
		}
		
		repo.deleteById(id);
		return "Booking removed from database...!";
	}

	public String deleteBooking() {
		 
		repo.deleteAll();
		return "All bookings are removed from database...!";
	}
}
