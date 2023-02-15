package br.com.etec.arthur.locadoraapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    // getter and setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // equals and hash code
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genero genero = (Genero) o;
        return id.equals(genero.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "genero")
    private List<Filme> filmes = new ArrayList<>();

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> alunos) {
        this.filmes = filmes;
    }
}
