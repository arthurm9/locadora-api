CREATE TABLE filme (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nomefilme VARCHAR(150),
    PRIMARY KEY(id)
);

ALTER TABLE filme
ADD CONSTRAINT FK_Filme_Ator
FOREIGN KEY(atorid)
REFERENCES ator(id);

ALTER TABLE filme
ADD CONSTRAINT FK_Filme_Genero
FOREIGN KEY(generoid)
REFERENCES genero(id);

INSERT INTO filme(nomefilme, atorid, generoid)
VALUES ('De volta ao Jogo', 1, 1);