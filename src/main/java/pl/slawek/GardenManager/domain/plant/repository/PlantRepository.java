package pl.slawek.GardenManager.domain.plant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.slawek.GardenManager.domain.plant.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
}
