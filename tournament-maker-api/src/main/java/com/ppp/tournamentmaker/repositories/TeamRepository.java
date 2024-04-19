package com.ppp.tournamentmaker.repositories;

import com.ppp.tournamentmaker.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {

    @Query("Select t from Team t where t.name = ?1 and t.type = ?2")
    Team getByNameAndType(String name, String type);

    @Query("Select t from Team t where t.id_team = ?1")
    Team getTeam(int idTeam);

    @Query("Select t from Team t order by t.type asc")
    List<Team> findAllByOrderByTypeAsc();
}
