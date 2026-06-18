package it.benefind.seatmap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.benefind.seatmap.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}