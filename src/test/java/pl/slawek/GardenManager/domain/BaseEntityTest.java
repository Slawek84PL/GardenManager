package pl.slawek.GardenManager.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class BaseEntityTest {

    @Test
    void shuldReturnNullInId() {
        BaseEntity baseEntity = new BaseEntity();
        assertNull(baseEntity.getId());
    }

    @Test
    void shouldReturnNullInCreatedDateAfterCreate() {
        BaseEntity entity = new BaseEntity();
        assertNull(entity.getCreatedAt());
    }

    @Test
    void shouldReturnNullInUpdateDateAfterCreate() {
        BaseEntity entity = new BaseEntity();
        assertNull(entity.getUpdatedAt());
    }

    @Test
    void shouldReturnNameAfterSetName() {
        BaseEntity entity = new BaseEntity();
        String name = "Storczyk";

        entity.setName(name);

        assertEquals(name, entity.getName());
    }

    @Test
    void shouldReturnNullCreatedDateAfterCreate() {
        BaseEntity entity = new BaseEntity();
        assertNull(entity.getCreatedAt());
    }

    @Test
    void shouldReturnNullUpdatedDateAfterUpdate() {
        BaseEntity entity = new BaseEntity();
        assertNull(entity.getUpdatedAt());
    }

}