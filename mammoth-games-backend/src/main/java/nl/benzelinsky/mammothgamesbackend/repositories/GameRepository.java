package nl.benzelinsky.mammothgamesbackend.repositories;

import nl.benzelinsky.mammothgamesbackend.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
