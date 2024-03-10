CREATE TABLE IF NOT EXISTS brand
(
    id   SERIAL,
    name VARCHAR,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS device
(
    id            SERIAL,
    com_name      VARCHAR,
    board_name    VARCHAR NOT NULL,
    eol_date      DATE    NOT NULL,
    has_full_rom  BOOL,
    generation_id INT,
    brand_id      INT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS device_notes
(
    id        SERIAL,
    os        TEXT CHECK ( os IN ('WINDOWS', 'LINUX', 'MACOS', 'ALL') ) NOT NULL DEFAULT 'ALL',
    device_id INT,
    note      VARCHAR,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS generation
(
    id                    SERIAL,
    short                 VARCHAR(3),
    name                  VARCHAR,
    baseboard             VARCHAR,
    stock_kernel_partsize INT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS generation_notes
(
    id               SERIAL,
    os               TEXT CHECK ( os IN ('WINDOWS', 'LINUX', 'MACOS', 'ALL') ) NOT NULL DEFAULT 'ALL',
    generation_id    INT,
    note             VARCHAR,
    show_on_dev_note BOOL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS win_drivers
(
    id            SERIAL,
    device_id     INT,
    generation_id INT,
    name          VARCHAR,
    download_link VARCHAR,
    PRIMARY KEY (id)
);