package br.com.etec.arthur.locadoraapi.repository.filter;

public class FilmeFilter {
    private String nomefilme;

    private String nomegenero;

    private String nomeator;

    public String getNomefilme() {
        return nomefilme;
    }

    public void setNomefilme(String nomefilme) {
        this.nomefilme = nomefilme;
    }

    public String getNomegenero() {
        return nomegenero;
    }

    public void setNomegenero(String nomegenero) {
        this.nomegenero = nomegenero;
    }

    public String getNomeator() {
        return nomeator;
    }

    public void setNomeator(String nomeator) {
        this.nomeator = nomeator;
    }
}
