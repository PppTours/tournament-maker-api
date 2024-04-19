package com.ppp.tournamentmaker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Tournament {
    @Id
    private int id_tournament;
    private String name;
    private Date starting_date;
    private String status;
    private String type;

    public Tournament() {}

    public int getId_tournament() {
        return id_tournament;
    }

    public void setId_tournament(int id_tournament) {
        this.id_tournament = id_tournament;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(Date starting_date) {
        this.starting_date = starting_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
