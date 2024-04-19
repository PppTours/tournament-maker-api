package com.ppp.tournamentmaker.controllers;

import com.ppp.tournamentmaker.models.In_Team;
import com.ppp.tournamentmaker.models.User;
import com.ppp.tournamentmaker.repositories.In_TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/in_teams")
public class In_TeamController {
    private final In_TeamRepository in_teamRepository;

    public In_TeamController(In_TeamRepository in_teamRepository) {
        this.in_teamRepository = in_teamRepository;
    }

    @GetMapping
    public ResponseEntity<List<In_Team>> getAll() {
        return new ResponseEntity<>(in_teamRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/isInTeam/{id_team}/{id_user}")
    public ResponseEntity<Boolean> isInTeam(@PathVariable int id_team, @PathVariable int id_user) {
        In_Team in_TeamInBDD = this.in_teamRepository.getInTeam(id_team, id_user);
        if (in_TeamInBDD == null) {
            return ResponseEntity.ok(false);
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping
    public ResponseEntity<In_Team> addInTeam(@RequestBody In_Team in_team) {
        In_Team in_TeamInBDD = this.in_teamRepository.getInTeam(in_team.getId().getId_team(), in_team.getId().getId_user());
        if (in_TeamInBDD == null) {
            in_TeamInBDD = this.in_teamRepository.save(in_team);
            return new ResponseEntity<>(in_TeamInBDD, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(in_TeamInBDD, HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id_team}/players")
    public ResponseEntity<User[]> getPlayersTeam(@PathVariable int id_team) {
        User[] usersInTeam = this.in_teamRepository.getPlayersTeam(id_team);
        if (usersInTeam == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usersInTeam, HttpStatus.OK);
    }
}
