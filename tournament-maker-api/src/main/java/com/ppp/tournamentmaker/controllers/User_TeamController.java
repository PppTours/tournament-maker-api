package com.ppp.tournamentmaker.controllers;

import com.ppp.tournamentmaker.models.User_Team;
import com.ppp.tournamentmaker.models.User;
import com.ppp.tournamentmaker.repositories.User_TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user_team")
public class User_TeamController {
    private final User_TeamRepository user_teamRepository;

    public User_TeamController(User_TeamRepository user_teamRepository) {
        this.user_teamRepository = user_teamRepository;
    }

    @GetMapping
    public ResponseEntity<List<User_Team>> getAll() {
        return new ResponseEntity<>(user_teamRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/isInTeam/{id_team}/{id_user}")
    public ResponseEntity<Boolean> isInTeam(@PathVariable int id_team, @PathVariable int id_user) {
        User_Team in_TeamInBDD = this.user_teamRepository.getInTeam(id_team, id_user);
        if (in_TeamInBDD == null) {
            return ResponseEntity.ok(false);
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping
    public ResponseEntity<User_Team> addInTeam(@RequestBody User_Team in_team) {
        User_Team user_TeamInBDD = this.user_teamRepository.getInTeam(in_team.getId().getId_team(), in_team.getId().getId_user());
        if (user_TeamInBDD == null) {
            user_TeamInBDD = this.user_teamRepository.save(in_team);
            return new ResponseEntity<>(user_TeamInBDD, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(user_TeamInBDD, HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id_team}/players")
    public ResponseEntity<List<User>> getPlayersTeam(@PathVariable int id_team) {
        List<User> usersInTeam = this.user_teamRepository.getPlayersTeam(id_team);
        if (usersInTeam == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usersInTeam, HttpStatus.OK);
    }
}
