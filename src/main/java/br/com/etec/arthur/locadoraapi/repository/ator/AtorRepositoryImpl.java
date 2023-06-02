package br.com.etec.arthur.locadoraapi.repository.ator;

import br.com.etec.arthur.locadoraapi.model.Ator;
import br.com.etec.arthur.locadoraapi.repository.filter.AtorFilter;
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

public class AtorRepositoryImpl implements AtorRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Ator> filtrarAtor(AtorFilter atorFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Ator> criteria = builder.createQuery(Ator.class);
        Root<Ator> root = criteria.from(Ator.class);

        Predicate[] predicates = criarRestricoes(atorFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nomeator")));

        TypedQuery<Ator> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(atorFilter));
    }

    private Long total(AtorFilter atorFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Ator> root = criteria.from(Ator.class);

        Predicate[] predicates = criarRestricoes(atorFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nomeator")));

        criteria.select(builder.count(root));
        return manager.createQuery(criteria).getSingleResult();
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<Ator> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistrosPorPagina);
    }

    private Predicate[] criarRestricoes(AtorFilter atorFilter, CriteriaBuilder builder, Root<Ator> root) {
        List<Predicate> predicates = new ArrayList<>();
        if(!StringUtils.isEmpty(atorFilter.getNomeator())){
            predicates.add(builder.like(builder.lower(root.get("nomeator")),
                                        "%" + atorFilter.getNomeator().toLowerCase() + "%"));
        }
        return predicates.toArray((new Predicate[predicates.size()]));
    }
}
