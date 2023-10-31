package pl.slawek.GardenManager.domain.plant;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.slawek.GardenManager.domain.BaseEntity;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name ="plants")
public class Plant extends BaseEntity {


}
