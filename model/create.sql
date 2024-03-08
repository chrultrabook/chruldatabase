-- create and use own database!

CREATE SCHEMA IF NOT EXISTS cbdb;

DROP TYPE IF EXISTS cbdb.os;
CREATE TYPE cbdb.os AS ENUM ('WINDOWS', 'LINUX', 'MACOS');

CREATE TABLE IF NOT EXISTS cbdb.brand
(
    id SERIAL,
    name VARCHAR,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS cbdb.device
(
    id SERIAL,
    name VARCHAR NOT NULL,
    eol_date DATE NOT NULL,
    has_fullrom BOOL,
    generation_id INT,
    brand_id INT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS cbdb.device_notes
(
    id SERIAL,
    os cbdb.os NOT NULL,
    device_id INT,
    note VARCHAR,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS cbdb.generation
(
    id SERIAL,
    short VARCHAR(3),
    name VARCHAR,
    baseboard VARCHAR,
    stock_kernel_partsize INT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS cbdb.generation_notes
(
    id SERIAL,
    os cbdb.os NOT NULL,
    generation_id INT,
    note VARCHAR,
    show_on_dev_note BOOL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS cbdb.win_drivers
(
    id SERIAL,
    device_id INT,
    generation_id INT,
    name VARCHAR,
    download_link VARCHAR,
    PRIMARY KEY (id)
);