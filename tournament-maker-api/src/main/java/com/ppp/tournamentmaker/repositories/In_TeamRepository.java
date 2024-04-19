package com.ppp.tournamentmaker.repositories;

import com.ppp.tournamentmaker.models.In_Team;
import com.ppp.tournamentmaker.models.In_TeamId;
import com.ppp.tournamentmaker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface In_TeamRepository extends JpaRepository<In_Team, In_TeamId> {
    @Query("select count (in_t) from In_Team in_t where in_t.id.id_team = ?1")
    int countInTeamByIdTeam(int id_team);

    @Query("select in_t from In_Team in_t where in_t.id.id_team = ?1 and in_t.id.id_user = ?2")
    In_Team getInTeam(int id_team, int id_user);

    @Query("select u from In_Team in_t join User u on in_t.id.id_user = u.id_user  where in_t.id.id_team = ?1")
    User[] getPlayersTeam(int idTeam);
}
