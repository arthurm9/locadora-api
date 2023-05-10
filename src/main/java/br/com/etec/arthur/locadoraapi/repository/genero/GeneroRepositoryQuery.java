package br.com.etec.arthur.locadoraapi.repository.genero;

import br.com.etec.arthur.locadoraapi.model.Genero;
import br.com.etec.arthur.locadoraapi.repository.filter.GeneroFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GeneroRepositoryQuery {
    public Page<Genero> filtrarGenero(GeneroFilter generoFilter, Pageable pageable);
}
