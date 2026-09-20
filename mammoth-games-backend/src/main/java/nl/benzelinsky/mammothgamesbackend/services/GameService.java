package nl.benzelinsky.mammothgamesbackend.services;

import nl.benzelinsky.mammothgamesbackend.dtos.GameOutputDto;
import nl.benzelinsky.mammothgamesbackend.exceptions.RecordNotFoundException;
import nl.benzelinsky.mammothgamesbackend.mappers.GameMapper;
import nl.benzelinsky.mammothgamesbackend.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final SessionService sessionService;

    public GameService(GameRepository gameRepository, SessionService sessionService) {
        this.gameRepository = gameRepository;
        this.sessionService = sessionService;
    }

    public GameOutputDto getGameById(Long id) {
        return GameMapper.toOutputDto(
                this.gameRepository.findById(id)
                        .orElseThrow(() ->
                                new RecordNotFoundException("Game", id)));
    }

    public List<GameOutputDto> getAllGames() {
        List<GameOutputDto> allGames = new ArrayList<>();
        this.gameRepository.findAll().
                forEach(game ->
                        allGames.add(GameMapper.toOutputDto(game)));
        return allGames;
    }
}