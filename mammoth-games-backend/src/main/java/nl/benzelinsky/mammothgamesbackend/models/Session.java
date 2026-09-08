package nl.benzelinsky.mammothgamesbackend.models;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY) // This is lazy because the name of the Game will not always be needed.
    @JoinColumn(name = "game_id")
    private Game game;

    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private SessionStatus status;

    @ManyToOne
    @JoinColumn(name = "host_id")
    private User host;

    @ManyToMany(mappedBy = "currentSessions")
    private List<User> players = new ArrayList<>();
}
