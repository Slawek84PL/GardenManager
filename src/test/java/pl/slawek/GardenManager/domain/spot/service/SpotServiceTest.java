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

    private Spot spot = new Spot();

    @BeforeEach
    void build() {
        spot.setName("Spot");
    }

    @Test
    void shouldSaveSpotInDatabase() {
        service.create(spot);
        assertNotNull(repository.getReferenceById(spot.getId()));
    }

    @Test
    void shouldReturnSpotsList() {
        Spot spot1 = new Spot();
        spot.setName("Spot2");

        repository.saveAll(Arrays.asList(spot, spot1));

        assertThat(service.spots()).hasSize(2);
    }

    @Test
    void shouldReturnSpot() {
        Long plantId = repository.save(spot).getId();

        assertNotNull(service.spot(plantId));
    }

    @Test
    void shouldUpdateSpot() {
        Long spotId = repository.save(spot).getId();

        Spot updateSpot = new Spot();
        updateSpot.setName("Spot 1");

        Spot updatedSpot = service.update(spot.getId(), updateSpot);

        assertNotNull(updatedSpot);
        assertEquals(spotId, updatedSpot.getId());
    }

    @Test
    void shouldDeleteSpot() {
        Long spotId = repository.save(spot).getId();

        service.delete(spot);

        assertThat(repository.findById(spotId)).isEmpty();

    }

}