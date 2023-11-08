package pl.slawek.GardenManager.domain.garden.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.slawek.GardenManager.domain.garden.Garden;
import pl.slawek.GardenManager.domain.garden.repository.GardenRepository;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles({"test"})
@SpringBootTest
class GardenServiceTest {

    @Autowired
    private GardenRepository repository;

    @Autowired
    private GardenService service;

    private Garden garden1 = new Garden();
    private Garden garden2 = new Garden();

    @BeforeEach
    void build() {
        repository.deleteAll();

        garden1.setName("Ogród");
        garden2.setName("Ogródek");

        repository.saveAll(Arrays.asList(garden1, garden2));
    }

    @Test
    void shouldSaveGardenInDatabase() {
        Garden garden = new Garden();
        garden.setName("Name");

        service.create(garden);

        assertNotNull(repository.getReferenceById(garden.getId()));
    }

    @Test
    void shouldReturnGardenList() {
        assertThat(service.gardens()).hasSize(2);
    }

    @Test
    void shouldReturnGarden() {
        assertNotNull(service.garden(garden1.getId()));
    }

    @Test
    void shouldUpdateGarden() {

        Garden garden = new Garden();
        garden.setName("Garden 1");

        Garden updatedGarden = service.update(garden1.getId(), garden);

        assertNotNull(updatedGarden);
        assertEquals(garden1.getId(), updatedGarden.getId());
        assertThat(updatedGarden.getName()).isEqualTo(garden.getName());
    }

    @Test
    void shouldDeletePlant() {

        service.delete(garden1);

        assertThat(repository.findById(garden1.getId())).isEmpty();
        assertThat(repository.findAll()).hasSize(1);

    }

}