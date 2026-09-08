package nl.benzelinsky.mammothgamesbackend.models;

import jakarta.persistence.*;

@Entity
public class GameRules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
}
