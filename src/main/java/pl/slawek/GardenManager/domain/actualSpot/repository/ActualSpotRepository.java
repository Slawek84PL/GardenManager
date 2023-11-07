package pl.slawek.GardenManager.domain.actualSpot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.slawek.GardenManager.domain.actualSpot.ActualSpot;

@Repository
public interface ActualSpotRepository extends JpaRepository<ActualSpot, Long> {
}
