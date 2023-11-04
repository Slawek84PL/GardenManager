package pl.slawek.GardenManager.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.Instant;
@Getter
@Setter
@RequiredArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "name", length = 50)
    private String name;

    @PrePersist
    protected void prePersist() {
        createdAt = Instant.now();
    }

    @PreUpdate
    protected void preUpdate() {
        updatedAt = Instant.now();
    }
}
