package pl.slawek.GardenMenager.domain.plant;

import jakarta.persistence.*;
import pl.slawek.GardenMenager.domain.BaseEntity;

import java.time.Instant;

@Entity
@Table(name = "planting_plants")
public class PlantingPlant extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plant plant;

    @Column(name = "planting_date", nullable = false)
    private Instant plantingDate;

}
