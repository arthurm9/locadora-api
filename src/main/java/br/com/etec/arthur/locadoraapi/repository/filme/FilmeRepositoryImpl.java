package br.com.etec.arthur.locadoraapi.repository.filme;

import br.com.etec.arthur.locadoraapi.model.Filme;
import br.com.etec.arthur.locadoraapi.repository.filter.FilmeFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class FilmeRepositoryImpl implements FilmeRepositoryQuery{
    @Override
    public Page<Filme> filtrarFilme(FilmeFilter filmeFilter, Pageable pageable) {
        return null;
    }
}
