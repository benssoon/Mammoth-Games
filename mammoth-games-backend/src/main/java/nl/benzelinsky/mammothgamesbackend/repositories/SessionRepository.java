package nl.benzelinsky.mammothgamesbackend.repositories;

import nl.benzelinsky.mammothgamesbackend.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
