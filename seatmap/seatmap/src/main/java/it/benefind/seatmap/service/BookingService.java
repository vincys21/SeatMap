package it.benefind.seatmap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.benefind.seatmap.entity.Booking;
import it.benefind.seatmap.repository.BookingRepository;

@Service
public class BookingService {
	private final BookingRepository bookingRepository;

	public BookingService(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}
	
	public List<Booking> findAll() {
		return bookingRepository.findAll();
	}
	
    public Optional<Booking> findById(Integer id) {
        return bookingRepository.findById(id);
    }
    
public Booking create(Booking booking) throws Exception {
		
		if(booking.getId() != null) {
			throw new Exception("l'id deve essere null in fase di creazione");
		} return bookingRepository.save(booking);
	}

    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }
    
    public Booking edit(Booking updateBooking) {

    	Booking booking = bookingRepository.findById(updateBooking.getId())
                .orElseThrow(() -> new RuntimeException("Booking non trovata"));

        booking.setId(updateBooking.getId());
        booking.setUser_id(updateBooking.getUser_id());
        booking.setDesk_id(updateBooking.getDesk_id());
        booking.setBooking_date(updateBooking.getBooking_date());
        
        
        return bookingRepository.save(booking);
    }

    public void delete(Integer id) {
        bookingRepository.deleteById(id);
    }
}
