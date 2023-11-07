package pl.slawek.GardenManager.domain.spot;

import jakarta.persistence.*;
import pl.slawek.GardenManager.domain.BaseEntity;
import pl.slawek.GardenManager.domain.garden.Garden;
import pl.slawek.GardenManager.domain.plant.PlantingPlant;

@Entity
@Table(name = "actual_spots")
public class ActualSpot extends BaseEntity {

    @OneToOne
    private Garden garden;

    @OneToOne
    private Spot gardenSpot;

    @ManyToOne
    private PlantingPlant plantingPlant;

}
