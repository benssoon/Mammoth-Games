package nl.benzelinsky.mammothgamesbackend.mappers;

import nl.benzelinsky.mammothgamesbackend.dtos.GameOutputDto;
import nl.benzelinsky.mammothgamesbackend.models.Game;

public class GameMapper {

    public static GameOutputDto toOutputDto(Game game) {
        GameOutputDto dto = new GameOutputDto();

        dto.id = game.getId();
        dto.title = game.getTitle();

        return dto;
    }
}
