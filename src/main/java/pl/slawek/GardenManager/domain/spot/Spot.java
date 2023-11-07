package pl.slawek.GardenManager.domain.spot;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import pl.slawek.GardenManager.domain.BaseEntity;

@RequiredArgsConstructor
@Entity
@Table(name = "spots")
public class Spot extends BaseEntity {

}
