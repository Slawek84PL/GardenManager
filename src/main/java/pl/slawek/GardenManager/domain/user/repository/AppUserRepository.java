package pl.slawek.GardenManager.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.slawek.GardenManager.domain.user.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
}
