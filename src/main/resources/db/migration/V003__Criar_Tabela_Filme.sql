CREATE TABLE IF NOT EXISTS filme (
    id INT NOT NULL AUTO_INCREMENT,
    nomefilme VARCHAR(255),
    atorid INT NOT NULL,
    generoid INT NOT NULL,
    PRIMARY KEY(id)
);

ALTER TABLE filme ADD CONSTRAINT FK_Filme_Ator FOREIGN KEY (atorid) REFERENCES ator(id);
ALTER TABLE filme ADD CONSTRAINT FK_Filme_Genero FOREIGN KEY (generoid) REFERENCES genero(id);

INSERT INTO filme(nomefilme, atorid, generoid) VALUES ('De volta ao Jogo', 1, 1);