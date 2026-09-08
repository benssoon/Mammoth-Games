package nl.benzelinsky.mammothgamesbackend.controllers;

import nl.benzelinsky.mammothgamesbackend.dtos.GameOutputDto;
import nl.benzelinsky.mammothgamesbackend.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameOutputDto> getGameById(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.getGameById(id));
    }
}
