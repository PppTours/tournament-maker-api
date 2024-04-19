package com.ppp.tournamentmaker.repositories;

import com.ppp.tournamentmaker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.pseudo = ?1 and u.password = ?2")
    User connectUser(String pseudo, String password);

    @Query("select u from User u where u.pseudo = ?1")
    User findByPseudo(String pseudo);
}
