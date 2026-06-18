package it.benefind.seatmap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.benefind.seatmap.entity.Desk;
import it.benefind.seatmap.repository.DeskRepository;

@Service
public class DeskService {

    private final DeskRepository deskRepository;

    public DeskService(DeskRepository deskRepository) {
        this.deskRepository = deskRepository;
    }

    public List<Desk> findAll() {
        return deskRepository.findAll();
    }

    public Optional<Desk> findById(Integer id) {
        return deskRepository.findById(id);
    }
    
	public Desk create(Desk desk) throws Exception {
		
		if(desk.getId() != null) {
			throw new Exception("l'id deve essere null in fase di creazione");
		} return deskRepository.save(desk);
	}

    public Desk save(Desk desk) {
        return deskRepository.save(desk);
    }

    public Desk edit(Desk updatedDesk) {

        Desk desk = deskRepository.findById(updatedDesk.getId())
                .orElseThrow(() -> new RuntimeException("Desk non trovata"));

        desk.setId(updatedDesk.getId());
        desk.setCode(updatedDesk.getCode());
        desk.setX(updatedDesk.getX());
        desk.setY(updatedDesk.getY());

        return deskRepository.save(desk);
    }

    public void delete(Integer id) {
        deskRepository.deleteById(id);
    }
}