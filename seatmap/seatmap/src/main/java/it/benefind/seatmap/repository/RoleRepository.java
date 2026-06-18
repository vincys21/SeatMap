package it.benefind.seatmap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.benefind.seatmap.entity.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
