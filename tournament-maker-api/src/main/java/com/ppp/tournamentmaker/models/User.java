package com.ppp.tournamentmaker.models;


import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;

    private String pseudo;
    private String firstname;
    private String lastname;
    private String id_discord;
    private String password;
    private String role;

    public User(int id_user, String pseudo, String firstname, String lastname, String id_discord, String password, String role) {
        this.id_user = id_user;
        this.pseudo = pseudo;
        this.firstname = firstname;
        this.lastname = lastname;
        this.id_discord = id_discord;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getId_discord() {
        return id_discord;
    }

    public void setId_discord(String id_discord) {
        this.id_discord = id_discord;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
