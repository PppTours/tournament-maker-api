package com.ppp.tournamentmaker.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_team")
public class User_Team {
    @EmbeddedId
    private User_TeamId id;
    private boolean is_owner;

    public User_Team() {
    }

    public User_TeamId getId() {
        return id;
    }

    public void setId(User_TeamId id) {
        this.id = id;
    }

    public boolean getIs_owner() {
        return is_owner;
    }

    public void setIs_owner(boolean is_owner) {
        this.is_owner = is_owner;
    }
}
