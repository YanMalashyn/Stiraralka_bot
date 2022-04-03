DROP TABLE IF EXISTS paha_phrase;
DROP TABLE IF EXISTS top250_film;
CREATE SEQUENCE global_seq START WITH 1;

CREATE TABLE paha_phrase
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name       VARCHAR                       NOT NULL
);

CREATE TABLE top250_film
(
    id             INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name       VARCHAR NOT NULL
);