package br.com.etec.arthur.locadoraapi.model;

import java.util.Objects;

public class Enredo {
    private Integer id;

    private String descricao;

    // getter and setter
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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
        Enredo enredo = (Enredo) o;
        return id.equals(enredo.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
