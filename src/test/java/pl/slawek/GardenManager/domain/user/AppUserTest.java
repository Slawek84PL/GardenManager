package pl.slawek.GardenManager.domain.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {

    AppUser user = new AppUser();

    @BeforeEach
    void build() {
        user.setCreatedAt(Instant.now());
        user.setName("User");
        user.setId(1L);
        user.setNickName("NickName");
        user.setEmail("email@email.pl");
        user.setPassword("pass");
        user.setSurname("Surname");
    }

    @Test
    void shouldReturnAllDetailAfterCreateUser() {

        assertEquals(user.getName(), "User");
        assertEquals(user.getId(), (1L));
        assertEquals(user.getNickName(), "NickName");
        assertEquals(user.getEmail(), "email@email.pl");
        assertEquals(user.getPassword(), "pass");
        assertEquals(user.getSurname(), "Surname");
    }

    @Test
    void shouldThrowExceptionAfterAddNotUniqueNickName() {

    }

    @Test
    void shouldThrowExceptionAfterAddNotUniqueEmail() {

    }

}