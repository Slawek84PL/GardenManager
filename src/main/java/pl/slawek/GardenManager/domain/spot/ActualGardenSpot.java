package pl.slawek.GardenManager.domain.spot;

import jakarta.persistence.*;
import pl.slawek.GardenManager.domain.BaseEntity;
import pl.slawek.GardenManager.domain.plant.PlantingPlant;

import java.util.List;

@Entity
@Table(name = "actual_garden_spots")
public class ActualGardenSpot extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "garden_spot_id")
    private GardenSpot gardenSpot;

    @OneToMany
    @JoinColumn(name = "plants_id")
    private List<PlantingPlant> plants;

}
