package pl.slawek.GardenManager.domain.garden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.slawek.GardenManager.domain.garden.Garden;

@Repository
public interface GardenRepository extends JpaRepository<Garden, Long> {
}
