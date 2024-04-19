package com.ppp.tournamentmaker.controllers;

import com.ppp.tournamentmaker.models.Team;
import com.ppp.tournamentmaker.repositories.User_TeamRepository;
import com.ppp.tournamentmaker.repositories.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/teams")
public class TeamController {
    private final TeamRepository teamRepository;
    private final User_TeamRepository user_teamRepository;

    public TeamController(final TeamRepository teamRepository, final User_TeamRepository user_teamRepository) {
        this.teamRepository = teamRepository;
        this.user_teamRepository = user_teamRepository;
    }

    @GetMapping
    public List<Team> getAllTeams() {
        return teamRepository.findAllByOrderByTypeAsc();
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody final Team team) {
        // If date is null set today
        if(team.getCreation_date() == null){
            team.setCreation_date(new Date());
        }

        Team teamInBDD = teamRepository.getByNameAndType(team.getName(), team.getType());
        if (teamInBDD == null) {
            teamInBDD = teamRepository.save(team);
            return new ResponseEntity<>(teamInBDD, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(teamInBDD, HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id_team}")
    public ResponseEntity<Team> getTeamById(@PathVariable final int id_team) {
        Team teamInBDD = teamRepository.getTeam(id_team);
        if(teamInBDD != null){
            return new ResponseEntity<>(teamInBDD, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id_team}/isComplete")
    public ResponseEntity<Boolean> isCompleteTeam(@PathVariable final int id_team) {
        Team teamInBDD = teamRepository.getTeam(id_team);
        if(teamInBDD != null){
            int nbUser = user_teamRepository.countInTeamByIdTeam(teamInBDD.getId_team());
            if(Objects.equals(teamInBDD.getType(), "2vs2")){
                if(nbUser < 2){
                    return new ResponseEntity<>(false, HttpStatus.OK);
                }
                else{
                    return new ResponseEntity<>(true, HttpStatus.OK);
                }
            }
            else{
                if(nbUser < 5){
                    return new ResponseEntity<>(false, HttpStatus.OK);
                }
                else{
                    return new ResponseEntity<>(true, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }
}
