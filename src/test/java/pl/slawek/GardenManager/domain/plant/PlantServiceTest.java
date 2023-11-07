package pl.slawek.GardenManager.domain.plant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.slawek.GardenManager.domain.plant.repository.PlantRepository;
import pl.slawek.GardenManager.domain.plant.service.PlantService;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PlantServiceTest {

    @Autowired
    private PlantRepository repository;

    @Autowired
    private PlantService service;

    private Plant plant = new Plant();

    @BeforeEach
    void build() {
        plant.setName("Plant");
    }

    @Test
    void shouldSavePlantInDatabase() {
        service.create(plant);
        assertNotNull(repository.getReferenceById(plant.getId()));
    }

    @Test
    void shouldReturnPlantsList() {
        Plant plant2 = new Plant();
        plant.setName("Plant 1");

        repository.saveAll(Arrays.asList(plant,plant2));

        assertThat(service.plants()).hasSize(2);
    }

    @Test
    void shouldReturnPlant() {
        Long plantId = repository.save(plant).getId();

        assertNotNull(service.plant(plantId));
    }

    @Test
    void shouldUpdatePlant() {
        Long plantId = repository.save(plant).getId();

        Plant updatePlant = new Plant();
        updatePlant.setName("Plant 1");

        Plant updatedPlant = service.update(plant.getId(), updatePlant);

        assertNotNull(updatedPlant);
        assertEquals(plantId, updatedPlant.getId());
    }

    @Test
    void shouldDeletePlant() {
        Long plantId = repository.save(plant).getId();

        service.delete(plant);

        assertThat(repository.findById(plantId)).isEmpty();

    }


}