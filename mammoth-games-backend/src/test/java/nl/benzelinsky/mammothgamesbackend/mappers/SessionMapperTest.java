package nl.benzelinsky.mammothgamesbackend.mappers;

import nl.benzelinsky.mammothgamesbackend.dtos.SessionOutputDto;
import nl.benzelinsky.mammothgamesbackend.models.Game;
import nl.benzelinsky.mammothgamesbackend.models.Session;
import nl.benzelinsky.mammothgamesbackend.models.SessionStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SessionMapperTest {

    private Session createSession(SessionStatus status) {
        Game game = new Game("Ticket to Ride");
        game.setId(1L);

        Session session = new Session();
        session.setId(2L);
        session.setName("Friday night trains");
        session.setGame(game);
        session.setStatus(status);

        return session;
    }

    @Test
    void toOutputDtoMapsAllFields() {
        SessionOutputDto dto = SessionMapper.toOutputDto(this.createSession(SessionStatus.OPEN));

        assertEquals(2L, dto.id);
        assertEquals("Friday night trains", dto.name);
        assertEquals(1L, dto.game.id);
        assertEquals("Ticket to Ride", dto.game.title);
        assertEquals("OPEN", dto.status);
    }

    @ParameterizedTest
    @EnumSource(SessionStatus.class)
    void toOutputDtoMapsStatusToItsName(SessionStatus status) {
        SessionOutputDto dto = SessionMapper.toOutputDto(this.createSession(status));

        assertEquals(status.name(), dto.status);
    }
}
