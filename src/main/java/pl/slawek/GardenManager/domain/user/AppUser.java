package pl.slawek.GardenManager.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import pl.slawek.GardenManager.domain.BaseEntity;

@RequiredArgsConstructor
@Entity
@Table(name = "app_users")
public class AppUser extends BaseEntity {

    private String nickName;

    private String email;

    private String password;

    private String surname;

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNickName() {
        return nickName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSurname() {
        return surname;
    }
}
