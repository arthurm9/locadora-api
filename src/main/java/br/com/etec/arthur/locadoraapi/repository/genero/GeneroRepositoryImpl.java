package br.com.etec.arthur.locadoraapi.repository.genero;

import br.com.etec.arthur.locadoraapi.model.Genero;
import br.com.etec.arthur.locadoraapi.repository.filter.GeneroFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

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
        criteria.orderBy(builder.asc(root.get("descricao")));

        TypedQuery<Genero> query = manager.createQuery(criteria); // depois de tipado se torna sql
        adicionarRestricoesDePaginacao(query, pageable);
        return new PageImpl<>(query.getResultList(), pageable, total(generoFilter));
    }

    private Long total(GeneroFilter generoFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class); // criar consulta de gêneros
        Root<Genero> root = criteria.from(Genero.class); // "select from" da classe

        Predicate[] predicates = criarRestricoes(generoFilter, builder, root); // instancia o método de restrição
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("descricao")));

        criteria.select(builder.count(root));
        return manager.createQuery(criteria).getSingleResult(); // retorna uma quantidade específica de resultados
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistrosPorPagina);
    }

    private Predicate[] criarRestricoes(GeneroFilter generoFilter, CriteriaBuilder builder, Root<Genero> root) {
        List<Predicate> predicates = new ArrayList<>();
        if(!StringUtils.isEmpty(generoFilter.getDescricao())){ // importar do apache lang3
            predicates.add(builder.like(builder.lower(root.get("descricao")),
                                        "%" + generoFilter.getDescricao().toLowerCase() + "%"));
        }
        return predicates.toArray((new Predicate[predicates.size()]));
    }
}
