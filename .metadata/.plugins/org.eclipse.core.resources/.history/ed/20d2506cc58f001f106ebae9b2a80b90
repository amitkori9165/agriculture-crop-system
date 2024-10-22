package com.bookings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bookings.controller.BookingController;
import com.bookings.model.Booking;
import com.bookings.service.BookingServices;

public class BookingControllerTestGet {
	 @InjectMocks
	    private BookingController bookingController;

	    @Mock
	    private BookingServices bookingServices;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    void testGetBookings() {
	        Booking booking1 = new Booking(401, 301, 201, 101,500.00,"Paid" );
	        Booking booking2 = new Booking(402, 302, 202, 102,300.00 , "Pending");

	        when(bookingServices.getBookings()).thenReturn(Arrays.asList(booking1, booking2));

	        List<Booking> bookings = bookingController.getBookings();

	        assertEquals(2, bookings.size());

	        // Check fields of the first booking
	        assertEquals(401, bookings.get(0).getBookingId());
	        assertEquals(101, bookings.get(0).getCropId());
	        assertEquals(201, bookings.get(0).getDealerId());
	        assertEquals(301, bookings.get(0).getFarmerId());
	        assertEquals(500.00, bookings.get(0).getTotalAmount());
	        assertEquals("Paid", bookings.get(0).getPaymentStatus());

	        // Check fields of the second booking
	        assertEquals(402, bookings.get(1).getBookingId());
	        assertEquals(102, bookings.get(1).getCropId());
	        assertEquals(202, bookings.get(1).getDealerId());
	        assertEquals(302, bookings.get(1).getFarmerId());
	        assertEquals(300.00, bookings.get(1).getTotalAmount());
	        assertEquals("Pending", bookings.get(1).getPaymentStatus());

	        verify(bookingServices, times(1)).getBookings();
	    }
	    @Test
	    void testGetBookingsById() {
	        Booking booking = new Booking(1, 301, 201, 101,500.00 ,"Paid" );

	        when(bookingServices.getBookings(1)).thenReturn(Optional.of(booking));

	        Optional<Booking> foundBooking = bookingController.getBookings(1);

	        assertTrue(foundBooking.isPresent());
	        
	        // Check fields of the found booking
	        assertEquals(1, foundBooking.get().getBookingId());
	        assertEquals(101, foundBooking.get().getCropId());
	        assertEquals(201, foundBooking.get().getDealerId());
	        assertEquals(301, foundBooking.get().getFarmerId());
	        assertEquals("Paid", foundBooking.get().getPaymentStatus());
	        assertEquals(500.00, foundBooking.get().getTotalAmount());

	        verify(bookingServices, times(1)).getBookings(1);
	    }
}
