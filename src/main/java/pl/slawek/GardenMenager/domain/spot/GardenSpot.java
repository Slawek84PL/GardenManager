package pl.slawek.GardenMenager.domain.spot;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import pl.slawek.GardenMenager.domain.BaseEntity;
import pl.slawek.GardenMenager.domain.plant.Plant;

import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
@Entity
@Table(name = "garden_spot")
public class GardenSpot extends BaseEntity {


    @ManyToMany
    private List<Plant> plants;

}
