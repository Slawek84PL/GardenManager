package pl.slawek.GardenManager;

import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.slawek.GardenManager.domain.plant.Plant;

@Component()
public class Starter implements CommandLineRunner {

    private final EntityManager entityManager;

    public Starter(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void run(String... args) throws Exception {
            Plant plant = new Plant();
            plant.setName("Storczyk");
            entityManager.persist(plant);

    }
}
