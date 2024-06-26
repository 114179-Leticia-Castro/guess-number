package proyecto.scaffolding.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.scaffolding.dtos.MatchDto;
import proyecto.scaffolding.entities.MatchEntity;

@Repository
public interface MatchRepository extends JpaRepository<MatchEntity, Long> {
}
