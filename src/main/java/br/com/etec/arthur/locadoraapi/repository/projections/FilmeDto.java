package br.com.etec.arthur.locadoraapi.repository.projections;

public class FilmeDto {
    private Long id;
    private String nomefilme;

    private String descricao; // genero

    private String nomeator; // ator

    // constructor
    public FilmeDto(Long id, String nomefilme, String descricao, String nomeator) {
        this.id = id;
        this.nomefilme = nomefilme;
        this.descricao = descricao;
        this.nomeator = nomeator;
    }
}
