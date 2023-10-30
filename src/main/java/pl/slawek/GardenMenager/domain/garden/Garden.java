package pl.slawek.GardenMenager.domain.garden;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import pl.slawek.GardenMenager.domain.BaseEntity;
import pl.slawek.GardenMenager.domain.spot.ActualGardenSpot;
import pl.slawek.GardenMenager.domain.user.AppUser;

import java.util.List;

@Entity
@Table(name = "gardens")
public class Garden extends BaseEntity {

    @ManyToMany
    @JoinColumn(name = "user_id")
    private List<AppUser> users;

    @ManyToMany
    @JoinColumn(name = "actual_garden_spot_id")
    private List<ActualGardenSpot> gardenSpots;
}
