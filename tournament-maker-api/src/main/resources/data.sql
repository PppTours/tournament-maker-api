-- Add defaults users
INSERT INTO user(pseudo, lastname, firstname, id_discord, password, role)
VALUES ('player','yer','pla','#player','player','PLAYER');

INSERT INTO user(pseudo, lastname, firstname, id_discord, password, role)
VALUES ('admin','min','ad','#admin','admin','ADMIN');


-- Add some teams
INSERT INTO team(name, tag, creation_date, type)
VALUES ('Equipe 1', 'T1', null, '2vs2');

INSERT INTO team(name, tag, creation_date, type)
VALUES ('Equipe 1', 'T1', null, '5vs5');

INSERT INTO team(name, tag, creation_date, type)
VALUES ('Equipe 2', 'T2', null, '5vs5');


-- Add some tournaments
INSERT INTO tournament(name, starting_date, status, type)
VALUES ('Tournoi 1', null, 'CREATION', '2vs2');

INSERT INTO tournament(name, starting_date, status, type)
VALUES ('Tournoi 2', null, 'CREATION', '5vs5');

INSERT INTO tournament(name, starting_date, status, type)
VALUES ('Tournoi 3', null, 'IN_PROGRESS', '2vs2');

INSERT INTO tournament(name, starting_date, status, type)
VALUES ('Tournoi 4', null, 'ENDED', '2vs2');
