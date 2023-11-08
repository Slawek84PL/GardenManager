package pl.slawek.GardenManager.domain.spot.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.slawek.GardenManager.domain.spot.Spot;
import pl.slawek.GardenManager.domain.spot.repository.SpotRepository;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles({"test"})
@SpringBootTest
class SpotServiceTest {

    @Autowired
    private SpotRepository repository;

    @Autowired
    private SpotService service;

    private Spot spot1 = new Spot();
    private Spot spot2 = new Spot();

    @BeforeEach
    void build() {
        repository.deleteAll();

        spot1.setName("Donica");
        spot2.setName("Skrzynia");

        repository.saveAll(Arrays.asList(spot1, spot2));
    }

    @Test
    void shouldSaveSpotInDatabase() {
        assertNotNull(repository.getReferenceById(spot1.getId()));
    }

    @Test
    void shouldReturnSpotsList() {
        assertThat(service.spots()).hasSize(2);
    }

    @Test
    void shouldReturnSpot() {
        assertNotNull(service.spot(spot1.getId()));
    }

    @Test
    void shouldUpdateSpot() {

        Spot spot = new Spot();
        spot.setName("Spot 1");

        Spot updatedSpot = service.update(spot1.getId(), spot);

        assertNotNull(updatedSpot);
        assertEquals(spot1.getId(), updatedSpot.getId());
        assertThat(updatedSpot.getName()).isEqualTo(spot.getName());
    }

    @Test
    void shouldDeleteSpot() {

        service.delete(spot1);

        assertThat(repository.findById(spot1.getId())).isEmpty();
        assertThat(repository.findAll()).hasSize(1);
    }

}