package nl.benzelinsky.mammothgamesbackend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {
    public User() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    @NonNull
    private String username;

    @Column(nullable = false)
    @NonNull
    private String password;

    @Column(nullable = false, unique = true)
    @NonNull
    private String email;

    @Column(nullable = false)
    @NonNull
    private Date registrationDate;

    @ManyToMany
    @JoinTable(
            name = "current_sessions",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "session_id")
    )
    private List<Session> currentSessions = new ArrayList<>();

    @OneToMany(
            targetEntity = Role.class,
            mappedBy = "userId"
    )
    private Set<Role> roles = new HashSet<>();
}
