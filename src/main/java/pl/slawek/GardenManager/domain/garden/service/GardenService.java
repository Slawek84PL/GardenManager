package pl.slawek.GardenManager.domain.garden.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.slawek.GardenManager.domain.garden.Garden;
import pl.slawek.GardenManager.domain.garden.repository.GardenRepository;

import java.util.List;

@Service
public class GardenService {

    private final GardenRepository repository;

    public GardenService(GardenRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Garden create(Garden garden) {
        return repository.save(garden);
    }

    @Transactional(readOnly = true)
    public Garden garden(Long id) {
        return repository.getReferenceById(id);
    }

    @Transactional(readOnly = true)
    public List<Garden> gardens() {
        return repository.findAll();
    }

    @Transactional
    public Garden update(Long id, Garden gardenRequest) {
        Garden garden = repository.getReferenceById(id);
        garden.setName(gardenRequest.getName());

        return garden;
    }

    @Transactional
    public void delete(Garden garden) {
        repository.delete(garden);
    }
}
