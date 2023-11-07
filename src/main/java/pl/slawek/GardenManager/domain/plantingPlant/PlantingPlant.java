package pl.slawek.GardenManager.domain.plantingPlant;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import pl.slawek.GardenManager.domain.BaseEntity;
import pl.slawek.GardenManager.domain.plant.Plant;
import pl.slawek.GardenManager.domain.spot.ActualSpot;

@Entity
@Table(name = "planting_plants")
public class PlantingPlant extends BaseEntity {

    @OneToOne
    private Plant plant;

    @OneToOne
    private ActualSpot actualSpot;
}
