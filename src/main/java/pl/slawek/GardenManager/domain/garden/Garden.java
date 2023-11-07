package pl.slawek.GardenManager.domain.garden;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import pl.slawek.GardenManager.domain.BaseEntity;
import pl.slawek.GardenManager.domain.user.AppUser;

import java.util.List;

@Entity
@Table(name = "gardens")
public class Garden extends BaseEntity {

    @OneToMany
    private List<AppUser> users;
}
