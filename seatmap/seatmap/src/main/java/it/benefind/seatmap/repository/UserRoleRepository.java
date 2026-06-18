package it.benefind.seatmap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.benefind.seatmap.entity.UserRole;
import it.benefind.seatmap.entity.UserRoleId;

@Repository
public interface UserRoleRepository
        extends JpaRepository<UserRole, UserRoleId> {

}