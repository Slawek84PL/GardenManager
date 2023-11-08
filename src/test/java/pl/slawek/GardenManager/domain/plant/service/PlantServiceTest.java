package pl.slawek.GardenManager.domain.plant.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.slawek.GardenManager.domain.plant.Plant;
import pl.slawek.GardenManager.domain.plant.repository.PlantRepository;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles({"test"})
@SpringBootTest
class PlantServiceTest {

    @Autowired
    private PlantRepository repository;

    @Autowired
    private PlantService service;

    private Plant plant1 = new Plant();
    private Plant plant2 = new Plant();

    @BeforeEach
    void build() {
        repository.deleteAll();

        plant1.setName("Storczyk");
        plant2.setName("Lilia");

        repository.saveAll(Arrays.asList(plant1, plant2));
    }

    @Test
    void shouldSavePlantInDatabase() {
        Plant plant = new Plant();
        plant.setName("Name");

        service.create(plant);

        assertNotNull(repository.getReferenceById(plant.getId()));
    }

    @Test
    void shouldReturnPlantsList() {
        assertThat(service.plants()).hasSize(2);
    }

    @Test
    void shouldReturnPlant() {
        assertNotNull(service.plant(plant1.getId()));
    }

    @Test
    void shouldUpdatePlant() {

        Plant plant = new Plant();
        plant.setName("Plant 1");

        Plant updatedPlant = service.update(plant1.getId(), plant);

        assertNotNull(updatedPlant);
        assertEquals(plant1.getId(), updatedPlant.getId());
        assertThat(updatedPlant.getName()).isEqualTo(plant.getName());
    }

    @Test
    void shouldDeletePlant() {

        service.delete(plant1);

        assertThat(repository.findById(plant1.getId())).isEmpty();
        assertThat(repository.findAll()).hasSize(1);

    }


}