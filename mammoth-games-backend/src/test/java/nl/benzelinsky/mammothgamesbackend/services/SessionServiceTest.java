package nl.benzelinsky.mammothgamesbackend.services;

import nl.benzelinsky.mammothgamesbackend.dtos.SessionOutputDto;
import nl.benzelinsky.mammothgamesbackend.models.Game;
import nl.benzelinsky.mammothgamesbackend.models.Session;
import nl.benzelinsky.mammothgamesbackend.models.SessionStatus;
import nl.benzelinsky.mammothgamesbackend.repositories.SessionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SessionServiceTest {

    @Mock
    private SessionRepository sessionRepository;

    @InjectMocks
    private SessionService sessionService;

    private Session createSession(Long id, String name, SessionStatus status) {
        Game game = new Game("Ticket to Ride");
        game.setId(1L);

        Session session = new Session();
        session.setId(id);
        session.setName(name);
        session.setGame(game);
        session.setStatus(status);

        return session;
    }

    @Test
    void getAllSessionsReturnsEverySessionAsDto() {
        when(this.sessionRepository.findAll()).thenReturn(List.of(
                this.createSession(1L, "Friday night trains", SessionStatus.OPEN),
                this.createSession(2L, "Sunday rematch", SessionStatus.FULL)));

        List<SessionOutputDto> result = this.sessionService.getAllSessions();

        assertEquals(2, result.size());

        assertEquals(1L, result.get(0).id);
        assertEquals("Friday night trains", result.get(0).name);
        assertEquals("Ticket to Ride", result.get(0).game.title);
        assertEquals("OPEN", result.get(0).status);

        assertEquals(2L, result.get(1).id);
        assertEquals("Sunday rematch", result.get(1).name);
        assertEquals("Ticket to Ride", result.get(1).game.title);
        assertEquals("FULL", result.get(1).status);

        verify(this.sessionRepository).findAll();
    }

    @Test
    void getAllSessionsReturnsEmptyListWhenThereAreNoSessions() {
        when(this.sessionRepository.findAll()).thenReturn(List.of());

        List<SessionOutputDto> result = this.sessionService.getAllSessions();

        assertTrue(result.isEmpty());
    }
}
