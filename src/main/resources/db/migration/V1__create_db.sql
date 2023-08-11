CREATE TABLE Client
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL CHECK (LENGTH(name) >= 3 AND LENGTH(name) <= 200)
);

CREATE TABLE Planet
(
    id   VARCHAR(50) PRIMARY KEY CHECK (id = UPPER(id)),
    name VARCHAR(500) NOT NULL CHECK (LENGTH(name) >= 1 AND LENGTH(name) <= 500)
);

CREATE TABLE Ticket
(
    id             SERIAL PRIMARY KEY,
    created_at     TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    client_id      INT REFERENCES Client (id) on delete cascade on update cascade,
    from_planet_id VARCHAR(50) REFERENCES Planet (id) on delete cascade on update cascade,
    to_planet_id   VARCHAR(50) REFERENCES Planet (id) on delete cascade on update cascade
);
