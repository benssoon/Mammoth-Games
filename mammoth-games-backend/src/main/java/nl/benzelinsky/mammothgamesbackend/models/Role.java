package nl.benzelinsky.mammothgamesbackend.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "roles")
public class Role implements Serializable {
    @Id
    @Column(nullable = false)
    private Long userId;

    @Id
    @Column(nullable = false)
    private String role;

    public Role() {
    }

    public Role(Long userId, String role) {
        this.userId = userId;
        this.role = role;
    }

}
