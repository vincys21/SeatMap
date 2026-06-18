package it.benefind.seatmap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.benefind.seatmap.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository <Booking, Integer>{

}
