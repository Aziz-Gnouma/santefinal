package com.iset.sante.entities;

import javax.persistence.*;

@Entity
@Table(name = "Action")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAction;

    @Column(name = "nom_evenement")
    private String nomEvenement;

    @Column(name = "nom_user")
    private String nomUser;

    // Constructors, getters, and setters
    @ManyToOne
    private Evenement evenement;


    public Action() {

    }

    public Action(String nomEvenement, String nomUser, Evenement evenement) {
        this.nomEvenement = nomEvenement;
        this.nomUser = nomUser;
        this.evenement = evenement;
    }

    public Long getIdAction() {
        return idAction;
    }

    public void setIdAction(Long idAction) {
        this.idAction = idAction;
    }

    public String getNomEvenement() {
        return nomEvenement;
    }

    public void setNomEvenement(String nomEvenement) {
        this.nomEvenement = nomEvenement;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }
    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

}
