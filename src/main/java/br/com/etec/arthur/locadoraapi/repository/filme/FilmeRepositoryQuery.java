package br.com.etec.arthur.locadoraapi.repository.filme;

import br.com.etec.arthur.locadoraapi.model.Filme;
import br.com.etec.arthur.locadoraapi.repository.filter.FilmeFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FilmeRepositoryQuery {
    public Page<Filme> filtrarFilme(FilmeFilter filmeFilter, Pageable pageable);
}
