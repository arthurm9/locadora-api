package br.com.etec.arthur.locadoraapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="ator")
public class Ator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeator;

    // getter and setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNomeAtor() {
        return nomeator;
    }
    public void setNomeAtor(String nomeAtor) {
        this.nomeator = nomeAtor;
    }

    // equals and hash code
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ator ator = (Ator) o;
        return id.equals(ator.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "ator")
    private List<Filme> filmes = new ArrayList<>();

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> alunos) {
        this.filmes = filmes;
    }

}

