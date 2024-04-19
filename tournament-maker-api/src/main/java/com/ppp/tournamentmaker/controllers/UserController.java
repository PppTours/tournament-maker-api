package com.ppp.tournamentmaker.controllers;


import com.ppp.tournamentmaker.models.User;
import com.ppp.tournamentmaker.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        //Check if the pseudo is not already used
        User userBDD = userRepository.findByPseudo(user.getPseudo());
        if (userBDD != null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        else{
            User newUser = userRepository.save(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }

    }

    @PostMapping("/connect")
    public ResponseEntity<User> connectUser(@RequestBody User user) {
        User userBDD = userRepository.connectUser(user.getPseudo(), user.getPassword());
        if(userBDD != null) {
            return new ResponseEntity<>(userBDD, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
