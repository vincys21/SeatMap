package it.benefind.seatmap.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.benefind.seatmap.entity.Booking;
import it.benefind.seatmap.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingRestController {

	private final BookingService bookingService;
	
	public BookingRestController(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
    @GetMapping("")
    public List<Booking> findAll() { 
        return bookingService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> findById(@PathVariable Integer id) {
        Optional<Booking> bookingOptional = bookingService.findById(id);
        if (bookingOptional.isPresent()) {
            return ResponseEntity.ok(bookingOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("")
    public Booking create(@RequestBody Booking booking) throws Exception {
        return bookingService.create(booking);
    }

    @PutMapping("/edit")
    public Booking edit(@RequestBody Booking booking) {
        return bookingService.edit(booking);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
    	bookingService.delete(id);
    }
}
