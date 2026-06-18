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

import it.benefind.seatmap.entity.Desk;
import it.benefind.seatmap.service.DeskService;

@RestController
@RequestMapping("/desks")
public class DeskRestController {

	    private final DeskService deskService;

	    public DeskRestController(DeskService deskService) {
	        this.deskService = deskService;
	    }

	    @GetMapping("")
	    public List<Desk> findAll() { 
	        return deskService.findAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Desk> findById(@PathVariable Integer id) {
	        Optional<Desk> deskOptional = deskService.findById(id);
	        if (deskOptional.isPresent()) {
	            return ResponseEntity.ok(deskOptional.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PostMapping("")
	    public Desk create(@RequestBody Desk desk) throws Exception {
	        return deskService.create(desk);
	    }

	    @PutMapping("/edit")
	    public Desk edit(@RequestBody Desk desk) {
	        return deskService.edit(desk);
	    }

	    @DeleteMapping("/delete/{id}")
	    public void delete(@PathVariable Integer id) {
	        deskService.delete(id);
	    }
	}
