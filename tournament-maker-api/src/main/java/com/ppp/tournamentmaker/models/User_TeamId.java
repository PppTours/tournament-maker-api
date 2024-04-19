package com.ppp.tournamentmaker.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class User_TeamId implements Serializable {
    private int id_team;
    private int id_user;

    public int getId_team() {
        return id_team;
    }

    public void setId_team(int id_team) {
        this.id_team = id_team;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
