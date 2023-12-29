SELECT 'CREATE DATABASE chruldatabase'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'chruldatabase');

DROP TYPE IF EXISTS os;
CREATE TYPE os AS ENUM ('windows', 'linux', 'macos');

CREATE TABLE IF NOT EXISTS arch (
    id int NOT NULL UNIQUE,
    short varchar(3),
    name varchar,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS brand (
    id int NOT NULL UNIQUE,
    name varchar,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS device (
    id int NOT NULL UNIQUE,
    name varchar NOT NULL,
    arch_id int,
    brand_id int,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS arch_notes (
    id int NOT NULL UNIQUE,
    os os NOT NULL,
    arch_id int,
    note varchar,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS device_notes (
    id int NOT NULL UNIQUE,
    os os NOT NULL,
    device_id int,
    note varchar,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS win_drivers (
    id int NOT NULL UNIQUE,
    device_id int,
    arch_id int,
    name varchar,
    download_link varchar,
    primary key (id)
);