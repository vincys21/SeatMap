package it.benefind.seatmap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.benefind.seatmap.entity.Permesso;

@Repository
public interface PermessoRepository extends JpaRepository<Permesso, Integer> {

    // find permessi by role id
    List<Permesso> findByRole_Id(Integer roleId);

}
