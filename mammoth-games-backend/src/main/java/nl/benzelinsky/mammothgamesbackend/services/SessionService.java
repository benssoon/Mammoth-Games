package nl.benzelinsky.mammothgamesbackend.services;

import nl.benzelinsky.mammothgamesbackend.dtos.SessionOutputDto;
import nl.benzelinsky.mammothgamesbackend.mappers.SessionMapper;
import nl.benzelinsky.mammothgamesbackend.repositories.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<SessionOutputDto> getAllSessions() {
        List<SessionOutputDto> allSessions = new ArrayList<>();
        this.sessionRepository.findAll().
                forEach(session ->
                        allSessions.add(SessionMapper.toOutputDto(session)));
        return allSessions;
    }
}
