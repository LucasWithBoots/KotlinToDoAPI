CREATE TABLE usuario
(
    id            SERIAL PRIMARY KEY,
    nome          VARCHAR(255) NOT NULL,
    email         VARCHAR(255) NOT NULL,
    dataDeCriacao TIMESTAMP    NOT NULL
);