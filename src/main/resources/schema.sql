CREATE TABLE IF NOT EXISTS products (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    category VARCHAR(10) NOT NULL,
    name VARCHAR(100) NOT NULL,
    country VARCHAR(50) NOT NULL,
    producer VARCHAR(50) NOT NULL,
    online_ordering BOOLEAN DEFAULT FALSE,
    installment BOOLEAN DEFAULT FALSE,
    UNIQUE(name, country, producer)
);

CREATE TABLE IF NOT EXISTS models (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    product_id BIGINT REFERENCES products(id),
    name VARCHAR(100) NOT NULL,
    ser_num VARCHAR(10),
    colour VARCHAR(15),
    length INTEGER DEFAULT 0,
    width INTEGER DEFAULT 0,
    height INTEGER DEFAULT 0,
    price NUMERIC(10,2),
    available BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS tvs (
    id BIGINT PRIMARY KEY,
    category VARCHAR(50),
    technology VARCHAR(20),
    FOREIGN KEY (id) REFERENCES models(id)
);

CREATE TABLE IF NOT EXISTS cleaners (
    id BIGINT PRIMARY KEY,
    container_volume INTEGER,
    num_modes INTEGER,
    FOREIGN KEY (id) REFERENCES models(id)
);

CREATE TABLE IF NOT EXISTS computers (
    id BIGINT PRIMARY KEY,
    category VARCHAR(30),
    processor_type VARCHAR(30),
    FOREIGN KEY (id) REFERENCES models(id)
);

CREATE TABLE IF NOT EXISTS fridges (
    id BIGINT PRIMARY KEY,
    num_doors INTEGER,
    compressor_type VARCHAR(30),
    FOREIGN KEY (id) REFERENCES models(id)
);

CREATE TABLE IF NOT EXISTS phones (
    id BIGINT PRIMARY KEY,
    memory INTEGER,
    num_cameras INTEGER,
    FOREIGN KEY (id) REFERENCES models(id)
);