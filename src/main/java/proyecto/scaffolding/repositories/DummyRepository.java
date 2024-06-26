package proyecto.scaffolding.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.scaffolding.entities.DummyEntity;

@Repository
public interface DummyRepository extends JpaRepository<DummyEntity, Long> {
}
