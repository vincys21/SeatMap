package it.benefind.seatmap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.benefind.seatmap.entity.Desk;

@Repository
public interface DeskRepository extends JpaRepository <Desk, Integer>{

}
