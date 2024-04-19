
DROP DATABASE IF EXISTS TournamentMaker;

CREATE database TournamentMaker CHARACTER SET utf8 COLLATE utf8_general_ci;
USE TournamentMaker;


DROP TABLE IF EXISTS tournament CASCADE;
DROP TABLE IF EXISTS game CASCADE;
DROP TABLE IF EXISTS team CASCADE;
DROP TABLE IF EXISTS user CASCADE;
DROP TABLE IF EXISTS map CASCADE;
DROP TABLE IF EXISTS round CASCADE;
DROP TABLE IF EXISTS participate_to_tournament CASCADE;
DROP TABLE IF EXISTS play_game CASCADE;
DROP TABLE IF EXISTS play_round CASCADE;
DROP TABLE IF EXISTS in_team CASCADE;
DROP TABLE IF EXISTS type_seq CASCADE;
DROP TABLE IF EXISTS user_seq CASCADE;

-- Creation Table tournament
CREATE TABLE tournament(
                           id_tournament INT AUTO_INCREMENT,
                           name VARCHAR(50) ,
                           starting_date TIMESTAMP,
                           status VARCHAR(50) ,
                           type VARCHAR(50) ,
                           PRIMARY KEY(id_tournament)
);

-- Creation Table game
CREATE TABLE game(
                     id_game INT AUTO_INCREMENT,
                     phase VARCHAR(50) ,
                     bo TINYINT,
                     ip VARCHAR(50) ,
                     rediff_link VARCHAR(50) ,
                     live_link VARCHAR(50) ,
                     match_date TIMESTAMP,
                     winner VARCHAR(50) ,
                     id_tournament INT NOT NULL,
                     PRIMARY KEY(id_game),
                     FOREIGN KEY(id_tournament) REFERENCES tournament(id_tournament)
);

-- Creation Table team
CREATE TABLE team(
                     id_team INT AUTO_INCREMENT,
                     name VARCHAR(50) ,
                     tag VARCHAR(50) ,
                     creation_date TIMESTAMP,
                     type VARCHAR(50) ,
                     PRIMARY KEY(id_team)
);

-- Creation Table _user_
CREATE TABLE user(
                       id_user INT AUTO_INCREMENT,
                       pseudo VARCHAR(50)  UNIQUE,
                       lastname VARCHAR(50) ,
                       firstname VARCHAR(50) ,
                       id_discord VARCHAR(50) ,
                       password VARCHAR(50) ,
                       role VARCHAR(50) ,
                       PRIMARY KEY(id_user)
);

-- Creation Table map
CREATE TABLE map(
                    id_map INT AUTO_INCREMENT,
                    name VARCHAR(50) ,
                    squad_1_score INT,
                    squad_2_score INT,
                    winner VARCHAR(50) ,
                    id_game INT,
                    PRIMARY KEY(id_map),
                    FOREIGN KEY(id_game) REFERENCES game(id_game)
);

-- Creation Table round
CREATE TABLE round(
                      id_round INT AUTO_INCREMENT,
                      id_map INT,
                      PRIMARY KEY(id_round),
                      FOREIGN KEY(id_map) REFERENCES map(id_map)
);

-- Creation Table participate_to_tournament
CREATE TABLE participate_to_tournament(
                                          id_tournament INT,
                                          id_team INT,
                                          PRIMARY KEY(id_tournament, id_team),
                                          FOREIGN KEY(id_tournament) REFERENCES tournament(id_tournament),
                                          FOREIGN KEY(id_team) REFERENCES team(id_team)
);

-- Creation Table play_game
CREATE TABLE play_game(
                          id_game INT,
                          id_team INT,
                          PRIMARY KEY(id_game, id_team),
                          FOREIGN KEY(id_game) REFERENCES game(id_game),
                          FOREIGN KEY(id_team) REFERENCES team(id_team)
);

-- Creation Table play_round
CREATE TABLE play_round(
                           id_user INT,
                           id_round INT,
                           nb_kill TINYINT,
                           nb_assist TINYINT,
                           nb_death TINYINT,
                           PRIMARY KEY(id_user, id_round),
                           FOREIGN KEY(id_user) REFERENCES user(id_user),
                           FOREIGN KEY(id_round) REFERENCES round(id_round)
);

-- Creation Table in_team
CREATE TABLE in_team(
                        id_team INT,
                        id_user INT,
                        owner BOOLEAN,
                        PRIMARY KEY(id_team, id_user),
                        FOREIGN KEY(id_team) REFERENCES team(id_team),
                        FOREIGN KEY(id_user) REFERENCES user(id_user)
);
