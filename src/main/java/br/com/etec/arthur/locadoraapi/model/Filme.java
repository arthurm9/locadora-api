package br.com.etec.arthur.locadoraapi.model;

import java.util.Objects;

public class Filme {
    private Integer id;

    private String nomeFilme;

    // getter and setter
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNomeFilme() {
        return nomeFilme;
    }
    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    // equals and hash code
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

    /*

    foreign keys

    private Integer idGenero;
    private Integer idAtop

     */
}
