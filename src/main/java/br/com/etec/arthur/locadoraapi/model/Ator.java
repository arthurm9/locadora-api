package br.com.etec.arthur.locadoraapi.model;

import java.util.Objects;

public class Ator {
    private Integer id;

    private String nomeAtor;

    // getter and setter
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNomeAtor() {
        return nomeAtor;
    }
    public void setNomeAtor(String nomeAtor) {
        this.nomeAtor = nomeAtor;
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
}

