package nl.benzelinsky.mammothgamesbackend.mappers;

import nl.benzelinsky.mammothgamesbackend.dtos.SessionOutputDto;
import nl.benzelinsky.mammothgamesbackend.models.Session;

public class SessionMapper {
    public static SessionOutputDto toOutputDto(Session session) {
        SessionOutputDto dtoOut = new SessionOutputDto();

        dtoOut.id = session.getId();
        dtoOut.name = session.getName();
        dtoOut.game = GameMapper.toOutputDto(session.getGame());
        dtoOut.status = session.getStatus().name();

        return dtoOut;
    }
}
