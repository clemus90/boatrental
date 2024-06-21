CREATE TABLE IF NOT EXISTS pet
(

    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    weight REAL,
    breed VARCHAR(100),
    vaccinated BOOLEAN,
    training_level INT
);
