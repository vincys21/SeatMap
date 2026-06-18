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

import it.benefind.seatmap.entity.Permesso;
import it.benefind.seatmap.service.PermessoService;

@RestController
@RequestMapping("/permessi")
public class PermessoRestController {

    private final PermessoService permessoService;

    public PermessoRestController(PermessoService permessoService) {
        this.permessoService = permessoService;
    }

    @GetMapping("")
    public List<Permesso> findAll() {
        return permessoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permesso> findById(@PathVariable Integer id) {
        Optional<Permesso> permessoOptional = permessoService.findById(id);
        if (permessoOptional.isPresent()) {
            return ResponseEntity.ok(permessoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/byRole/{roleId}")
    public List<Permesso> findByRole(@PathVariable Integer roleId) {
        return permessoService.findByRoleId(roleId);
    }

    @PostMapping("")
    public Permesso create(@RequestBody Permesso permesso) throws Exception {
        return permessoService.create(permesso);
    }

    @PutMapping("/edit")
    public Permesso edit(@RequestBody Permesso permesso) {
        return permessoService.edit(permesso);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        permessoService.delete(id);
    }

}
