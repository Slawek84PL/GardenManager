package pl.slawek.GardenMenager.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import pl.slawek.GardenMenager.domain.BaseEntity;

@RequiredArgsConstructor
@Entity
@Table(name = "app_users")
public class AppUser extends BaseEntity {

    private String nickName;

    private String email;

    private String password;

    private String surname;
}
