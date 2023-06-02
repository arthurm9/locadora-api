package br.com.etec.arthur.locadoraapi.repository.filme;

import br.com.etec.arthur.locadoraapi.model.Filme;
import br.com.etec.arthur.locadoraapi.repository.filter.FilmeFilter;
import br.com.etec.arthur.locadoraapi.repository.projections.FilmeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class FilmeRepositoryImpl implements FilmeRepositoryQuery{
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<FilmeDto> filtrarFilme(FilmeFilter filmeFilter, Pageable pageable) {
        return null;
    }
}
