package br.com.etec.arthur.locadoraapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="ator")
public class Ator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeator;

    @JsonIgnore
    @OneToMany(mappedBy = "ator")
    private List<Filme> filmesator = new ArrayList<>();

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNomeator() {
        return nomeator;
    }
    public void setNomeator(String nomeator) {
        this.nomeator = nomeator;
    }
    public List<Filme> getFilmesator() {
        return filmesator;
    }
    public void setFilmesator(List<Filme> filmesator) {
        this.filmesator = filmesator;
    }

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
}