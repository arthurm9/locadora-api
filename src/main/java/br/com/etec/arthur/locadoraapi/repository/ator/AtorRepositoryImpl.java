package br.com.etec.arthur.locadoraapi.repository.ator;

import br.com.etec.arthur.locadoraapi.model.Ator;
import br.com.etec.arthur.locadoraapi.repository.filter.AtorFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class AtorRepositoryImpl implements AtorRepositoryQuery{
    @Override
    public Page<Ator> filtrarAtor(AtorFilter atorFilter, Pageable pageable) {
        return null;
    }
}
