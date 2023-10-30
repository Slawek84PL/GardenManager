package pl.slawek.GardenMenager.domain.garden;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import pl.slawek.GardenMenager.domain.BaseEntity;
import pl.slawek.GardenMenager.domain.spot.GardenSpot;
import pl.slawek.GardenMenager.domain.user.AppUser;

import java.util.List;

@Entity
public class Garden extends BaseEntity {

    @ManyToMany
    private List<AppUser> users;

    @ManyToMany
    private List<GardenSpot> gardenSpots;
}
