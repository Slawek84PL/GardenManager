package pl.slawek.GardenMenager.domain.spot;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import pl.slawek.GardenMenager.domain.BaseEntity;

@RequiredArgsConstructor
@Entity
@Table(name = "garden_spot")
public class GardenSpot extends BaseEntity {

}
