package pl.slawek.GardenManager.domain.plant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PlantService {

    private final PlantRepository repository;

    private Plant create(String name) {
        Plant plant = new Plant();
        plant.setName(name);
        return repository.save(plant);
    }

    private List<Plant> plants() {
        return repository.findAll();
    }

    private Optional<Plant> plant(Long id) {
        return Optional.of(repository.findById(id).orElseThrow());
    }

    private void delete(Plant plant) {
        repository.delete(plant);
    }

}
