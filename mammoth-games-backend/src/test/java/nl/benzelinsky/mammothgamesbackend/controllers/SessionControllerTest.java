package nl.benzelinsky.mammothgamesbackend.controllers;

import nl.benzelinsky.mammothgamesbackend.dtos.GameOutputDto;
import nl.benzelinsky.mammothgamesbackend.dtos.SessionOutputDto;
import nl.benzelinsky.mammothgamesbackend.services.SessionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class SessionControllerTest {

    @Mock
    private SessionService sessionService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new SessionController(this.sessionService))
                .build();
    }

    @Test
    void getAllSessionsReturnsOkWithSessions() throws Exception {
        GameOutputDto game = new GameOutputDto();
        game.id = 1L;
        game.title = "Ticket to Ride";

        SessionOutputDto session = new SessionOutputDto();
        session.id = 2L;
        session.name = "Friday night trains";
        session.game = game;
        session.status = "OPEN";

        when(this.sessionService.getAllSessions()).thenReturn(List.of(session));

        this.mockMvc.perform(get("/sessions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value(2))
                .andExpect(jsonPath("$[0].name").value("Friday night trains"))
                .andExpect(jsonPath("$[0].game.id").value(1))
                .andExpect(jsonPath("$[0].game.title").value("Ticket to Ride"))
                .andExpect(jsonPath("$[0].status").value("OPEN"));
    }

    @Test
    void getAllSessionsReturnsOkWithEmptyListWhenThereAreNoSessions() throws Exception {
        when(this.sessionService.getAllSessions()).thenReturn(List.of());

        this.mockMvc.perform(get("/sessions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));
    }
}
