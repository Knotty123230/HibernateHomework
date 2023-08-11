INSERT INTO client(name)
VALUES ('Vitaliy'),
       ('Kolia'),
       ('Zhenia'),
       ('Vasia'),
       ('Oleg'),
       ('Abraham'),
       ('Morbius'),
       ('Payk'),
       ('Migra'),
       ('Polo');
INSERT INTO planet(id, name)
VALUES ('MARS', 'Mars'),
       ('VENERA', 'Venera'),
       ('EARTH', 'Earth'),
       ('MERCURY', 'Mercury'),
       ('PLUTON', 'Pluton');
INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id)
VALUES ('2020-12-30 13:08:54.193', 1, 'MARS', 'EARTH'),
       ('2019-11-30 13:08:54.193', 2, 'EARTH', 'MARS'),
       ('2018-11-30 13:08:54.193', 3, 'MARS', 'PLUTON'),
       ('2017-11-30 13:08:54.193', 4, 'VENERA', 'MARS'),
       ('2016-11-30 13:08:54.193', 5, 'EARTH', 'VENERA'),
       ('2015-11-30 13:08:54.193', 6, 'PLUTON', 'EARTH'),
       ('2015-08-30 13:08:54.193', 7, 'EARTH', 'MERCURY'),
       ('2015-09-30 13:08:54.193', 8, 'MARS', 'VENERA'),
       ('2015-10-30 13:08:54.193', 9, 'VENERA', 'MERCURY'),
       ('2015-03-30 13:08:54.193', 10, 'MERCURY', 'PLUTON');
