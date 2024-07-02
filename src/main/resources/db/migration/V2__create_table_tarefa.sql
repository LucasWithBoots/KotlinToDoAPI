CREATE TABLE tarefa
(
    id            SERIAL PRIMARY KEY,
    titulo        VARCHAR(255) NOT NULL,
    descricao     TEXT         NOT NULL,
    dataDeCriacao DATE         NOT NULL,
    usuario_id    BIGINT       NOT NULL,
    status        VARCHAR(50)  NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuario (id)
);