package com.iset.sante.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Evenement")
public class Evenement {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(name = "NomEvenement")
    private String NomEvenement;

    @Column(name = "Nom_club")
    private String Nom_club;

    @Column(name = "email")
    private String email;

    @Column(name = "Time")
    private Date Time;

    @Column(name = "Description")
    private String Description;
    @OneToMany(mappedBy = "evenement")
    private List<Action> actions;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNomEvenement() {
        return NomEvenement;
    }
    public void setNomEvenement(String NomEvenement) {
        this.NomEvenement = NomEvenement;
    }
    public String getNom_club() {
        return Nom_club;
    }
    public void setNom_club(String Nom_club) {
        this.Nom_club = Nom_club;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Date getTime() {
        return Time;
    }
    public void setTimeme(Date Time) {
        this.Time = Time;
    }


    public String getDescription() {
        return Description;
    }
    public void setDescription(String Description) {
        this.Description = Description;
    }

    public List<Action> getactions() {
        return actions;
    }
    public void setactions(List<Action> actions) {
        this.actions = actions;
    }

}
