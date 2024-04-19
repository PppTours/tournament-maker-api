package com.ppp.tournamentmaker.repositories;

import com.ppp.tournamentmaker.models.User_Team;
import com.ppp.tournamentmaker.models.User_TeamId;
import com.ppp.tournamentmaker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface User_TeamRepository extends JpaRepository<User_Team, User_TeamId> {
    @Query("select count (in_t) from User_Team in_t where in_t.id.id_team = ?1")
    int countInTeamByIdTeam(int id_team);

    @Query("select in_t from User_Team in_t where in_t.id.id_team = ?1 and in_t.id.id_user = ?2")
    User_Team getInTeam(int id_team, int id_user);

    @Query("select u from User_Team in_t join User u on in_t.id.id_user = u.id_user  where in_t.id.id_team = ?1")
    List<User> getPlayersTeam(int idTeam);
}
