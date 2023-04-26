CREATE TABLE IF NOT EXISTS genero (
    id INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(255),
    PRIMARY KEY(id)
);

INSERT INTO genero(descricao) VALUES ('Ação');