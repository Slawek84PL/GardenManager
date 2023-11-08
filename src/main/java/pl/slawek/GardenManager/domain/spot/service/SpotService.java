package pl.slawek.GardenManager.domain.spot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.slawek.GardenManager.domain.spot.Spot;
import pl.slawek.GardenManager.domain.spot.repository.SpotRepository;

import java.util.List;

@Service
public class SpotService {

    private final SpotRepository repository;

    public SpotService(SpotRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Spot create(Spot spot) {
        return repository.save(spot);
    }

    @Transactional(readOnly = true)
    public Spot spot(Long id) {
        return repository.getReferenceById(id);
    }

    @Transactional(readOnly = true)
    public List<Spot> spots() {
        return repository.findAll();
    }

    @Transactional
    public Spot update(Long id, Spot spotRequest) {
        Spot spot = repository.getReferenceById(id);
        spot.setName(spotRequest.getName());

        return spot;
    }

    @Transactional
    public void delete(Spot spot) {
        repository.delete(spot);
    }
}
