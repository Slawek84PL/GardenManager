package pl.slawek.GardenMenager.domain.plant;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import pl.slawek.GardenMenager.domain.BaseEntity;

@RequiredArgsConstructor
@Entity
@Table(name ="plants")
public class Plant extends BaseEntity {


}
