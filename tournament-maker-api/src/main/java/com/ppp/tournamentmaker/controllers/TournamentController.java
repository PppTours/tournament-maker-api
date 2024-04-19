package com.ppp.tournamentmaker.controllers;

import com.ppp.tournamentmaker.models.Tournament;
import com.ppp.tournamentmaker.repositories.TournamentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/tournaments")
public class TournamentController {
    private final TournamentRepository tournamentRepository;

    public TournamentController(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    @GetMapping("/{id_tournament}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable int id_tournament) {
        Tournament tournamentInBDD = tournamentRepository.findTournament(id_tournament);

        if (tournamentInBDD == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(tournamentInBDD, HttpStatus.OK);
        }
    }
}
