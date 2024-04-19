package com.ppp.tournamentmaker.repositories;

import com.ppp.tournamentmaker.models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
    @Query("Select t from Tournament t where t.id_tournament = ?1")
    Tournament findTournament(int id_tournament);
}
