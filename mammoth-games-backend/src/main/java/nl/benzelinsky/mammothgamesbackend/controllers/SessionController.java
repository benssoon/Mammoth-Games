package nl.benzelinsky.mammothgamesbackend.controllers;

import nl.benzelinsky.mammothgamesbackend.dtos.SessionOutputDto;
import nl.benzelinsky.mammothgamesbackend.services.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    private final SessionService service;

    public SessionController(SessionService sessionService) {
        this.service = sessionService;
    }

    @GetMapping
    public ResponseEntity<List<SessionOutputDto>> getAllSessions() {
        return ResponseEntity.ok(this.service.getAllSessions());
    }
}
