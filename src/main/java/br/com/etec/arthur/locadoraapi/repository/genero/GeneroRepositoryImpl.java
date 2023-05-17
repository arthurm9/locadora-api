package br.com.etec.arthur.locadoraapi.repository.genero;

import br.com.etec.arthur.locadoraapi.model.Genero;
import br.com.etec.arthur.locadoraapi.repository.filter.GeneroFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GeneroRepositoryImpl implements GeneroRepositoryQuery{
    // preparação do criteria
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Genero> filtrarGenero(GeneroFilter generoFilter, Pageable pageable) {
        return null;
    }
}
