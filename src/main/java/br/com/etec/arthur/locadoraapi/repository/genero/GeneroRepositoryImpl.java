package br.com.etec.arthur.locadoraapi.repository.genero;

import br.com.etec.arthur.locadoraapi.model.Genero;
import br.com.etec.arthur.locadoraapi.repository.filter.GeneroFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class GeneroRepositoryImpl implements GeneroRepositoryQuery{
    // preparação do criteria
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Genero> filtrarGenero(GeneroFilter generoFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Genero> criteria = builder.createQuery(Genero.class); // criar consulta de gêneros
        Root<Genero> root = criteria.from(Genero.class); // "select from" da classe
        Predicate[] predicates = criarRestricoes(generoFilter, builder, root); // instancia o método de restrição
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("descicao")));
        return null;
    }
}
