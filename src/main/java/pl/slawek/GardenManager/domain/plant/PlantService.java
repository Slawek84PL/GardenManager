package pl.slawek.GardenManager.domain.plant;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlantService {

    private final PlantRepository repository;

    public PlantService(PlantRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Plant create(Plant plant) {
        return repository.save(plant);
    }

    @Transactional(readOnly = true)
    public Plant plant(Long id) {
        return repository.getReferenceById(id);
    }

    @Transactional(readOnly = true)
    public List<Plant> plants() {
        return repository.findAll();
    }

    @Transactional
    public Plant update(Long id, Plant plantRequest) {
        Plant plant = repository.getReferenceById(id);
        plant.setName(plantRequest.getName());

        return plant;
    }

    @Transactional
    public void delete(Plant plant) {
        repository.delete(plant);
    }

}
