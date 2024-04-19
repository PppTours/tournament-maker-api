package com.ppp.tournamentmaker.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "in_team")
public class In_Team {
    @EmbeddedId
    private In_TeamId id;
    private boolean owner;

    public In_Team() {
    }

    public In_TeamId getId() {
        return id;
    }

    public void setId(In_TeamId id) {
        this.id = id;
    }

    public boolean isOwner() {
        return owner;
    }

    public boolean getOwner() {
        return owner;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }
}
