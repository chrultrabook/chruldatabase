-- create and use own database!

CREATE SCHEMA IF NOT EXISTS cbdb;

DROP TYPE IF EXISTS cbdb.os;
CREATE TYPE cbdb.os AS ENUM ('windows', 'linux', 'macos');

CREATE TABLE IF NOT EXISTS cbdb.arch (
    id int NOT NULL UNIQUE,
    short varchar(3),
    name varchar,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS cbdb.brand (
    id int NOT NULL UNIQUE,
    name varchar,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS cbdb.device (
    id int NOT NULL UNIQUE,
    name varchar NOT NULL,
    arch_id int,
    brand_id int,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS cbdb.arch_notes (
    id int NOT NULL UNIQUE,
    os cbdb.os NOT NULL,
    arch_id int,
    note varchar,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS cbdb.device_notes (
    id int NOT NULL UNIQUE,
    os cbdb.os NOT NULL,
    device_id int,
    note varchar,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS cbdb.win_drivers (
    id int NOT NULL UNIQUE,
    device_id int,
    arch_id int,
    name varchar,
    download_link varchar,
    primary key (id)
);