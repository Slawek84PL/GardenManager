package pl.slawek.GardenManager.domain.spot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.slawek.GardenManager.domain.spot.Spot;

@Repository
public interface SpotRepository extends JpaRepository<Spot, Long> {
}
