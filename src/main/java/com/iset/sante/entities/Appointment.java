package com.iset.sante.entities;


import javax.persistence.*;

@Entity
@Table(name = "Appointment")
    public class Appointment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column()
        private Long id;
    @Column()
        private String name;
    @Column()
        private String number;
    @Column()
        private String email;
    @Column()
        private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Appointment() {
        this.id = id;
        this.name = name;
        this.number = number;
        this.email = email;
        this.date = date;
    }
// constructeurs, getters, setters, etc.

    }

