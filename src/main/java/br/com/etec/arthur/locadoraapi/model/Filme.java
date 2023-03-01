package br.com.etec.arthur.locadoraapi.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="filme")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomefilme;

    @ManyToOne
    @JoinColumn(name="generoid")
    private Genero genero;

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @ManyToOne
    @JoinColumn(name="atorid")
    private Ator ator;

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNomefilme() {
        return nomefilme;
    }
    public void setNomefilme(String nomefilme) {
        this.nomefilme = nomefilme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return id.equals(filme.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
