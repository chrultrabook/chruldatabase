CREATE TABLE IF NOT EXISTS brand
(
    id   INTEGER NOT NULL UNIQUE,
    name TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS device
(
    id                     INTEGER NOT NULL UNIQUE,
    com_name               TEXT,
    board_name             TEXT    NOT NULL,
    eol_date               DATE    NOT NULL,
    has_full_rom           BOOLEAN,
    wp_method              TEXT,
    stock_kernel_part_size INTEGER,
    generation_id          INTEGER,
    brand_id               INTEGER,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS device_notes
(
    id        INTEGER                                                   NOT NULL UNIQUE,
    os        TEXT CHECK ( os IN ('WINDOWS', 'LINUX', 'MACOS', 'ALL') ) NOT NULL DEFAULT 'ALL',
    device_id INTEGER,
    note      TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS generation
(
    id        INTEGER NOT NULL UNIQUE,
    short     TEXT(3),
    name      TEXT,
    baseboard TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS generation_notes
(
    id               INTEGER                                                   NOT NULL UNIQUE,
    os               TEXT CHECK ( os IN ('WINDOWS', 'LINUX', 'MACOS', 'ALL') ) NOT NULL DEFAULT 'ALL',
    generation_id    INTEGER,
    note             TEXT,
    show_on_dev_note BOOLEAN,
    PRIMARY KEY (id)
);

/*CREATE TABLE IF NOT EXISTS win_drivers
(
    id            INTEGER NOT NULL UNIQUE,
    device_id     INTEGER,
    generation_id INTEGER,
    name          TEXT,
    download_link TEXT,
    PRIMARY KEY (id)
); */