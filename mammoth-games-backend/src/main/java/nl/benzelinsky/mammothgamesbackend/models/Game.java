package nl.benzelinsky.mammothgamesbackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    @NonNull
    private String title;

    @Column
    private int minPlayers;

    @Column
    private int maxPlayers;

    @Column
    private String gameStatus;

    @Column
    private String description;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "rules_id")
    private  List<GameRules> rules;

    @OneToMany(mappedBy = "game")
    private List<Session> activeSessions = new ArrayList<>();
}
