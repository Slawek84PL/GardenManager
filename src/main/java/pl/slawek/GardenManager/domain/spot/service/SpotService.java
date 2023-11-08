package pl.slawek.GardenManager.domain.spot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.slawek.GardenManager.domain.spot.Spot;
import pl.slawek.GardenManager.domain.spot.repository.SpotRepository;

import java.util.List;

@Service
public class SpotService {

    public SpotService(SpotRepository repository) {
    }

    public Spot create(Spot spot) {
    }

    public Spot spot(Long id) {
    }

    public List<Spot> spots() {
    }

    public Spot update(Long id, Spot spotRequest) {
    }

    public void delete(Spot spot) {
    }
}
