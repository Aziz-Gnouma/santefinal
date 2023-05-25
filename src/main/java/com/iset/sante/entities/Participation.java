package com.iset.sante.entities;

import javax.persistence.*;

@Entity
@Table(name = "participations")
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Evenement event;

    @Column(nullable = false)
    private boolean participating;

    // getters and setters
    // Constructor
    public Participation() {}

    // Getters
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Evenement getEvent() {
        return event;
    }

    public boolean isParticipating() {
        return participating;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEvent(Evenement event) {
        this.event = event;
    }

    public void setParticipating(boolean participating) {
        this.participating = participating;
    }
}
