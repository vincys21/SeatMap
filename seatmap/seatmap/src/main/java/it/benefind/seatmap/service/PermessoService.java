package it.benefind.seatmap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.benefind.seatmap.entity.Permesso;
import it.benefind.seatmap.repository.PermessoRepository;

@Service
public class PermessoService {

    private final PermessoRepository permessoRepository;

    public PermessoService(PermessoRepository permessoRepository) {
        this.permessoRepository = permessoRepository;
    }

    public List<Permesso> findAll() {
        return permessoRepository.findAll();
    }

    public Optional<Permesso> findById(Integer id) {
        return permessoRepository.findById(id);
    }

    public List<Permesso> findByRoleId(Integer roleId) {
        return permessoRepository.findByRole_Id(roleId);
    }

    public Permesso create(Permesso permesso) throws Exception {
        if (permesso.getId() != null) {
            throw new Exception("l'id deve essere null in fase di creazione");
        }
        return permessoRepository.save(permesso);
    }

    public Permesso save(Permesso permesso) {
        return permessoRepository.save(permesso);
    }

    public Permesso edit(Permesso updatedPermesso) {
        Permesso permesso = permessoRepository.findById(updatedPermesso.getId())
                .orElseThrow(() -> new RuntimeException("Permesso non trovato"));

        permesso.setId(updatedPermesso.getId());
        permesso.setAzione(updatedPermesso.getAzione());
        permesso.setRole(updatedPermesso.getRole());

        return permessoRepository.save(permesso);
    }

    public void delete(Integer id) {
        permessoRepository.deleteById(id);
    }

}
