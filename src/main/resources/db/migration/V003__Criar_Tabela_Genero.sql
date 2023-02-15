CREATE TABLE genero (
    id BIGINT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(255),
    PRIMARY KEY(id)
);

INSERT INTO genero(descricao)
VALUES ('Ação');