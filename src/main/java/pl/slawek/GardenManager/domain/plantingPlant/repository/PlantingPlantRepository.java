package pl.slawek.GardenManager.domain.plantingPlant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.slawek.GardenManager.domain.plantingPlant.PlantingPlant;

@Repository
public interface PlantingPlantRepository extends JpaRepository<PlantingPlant, Long> {
}
