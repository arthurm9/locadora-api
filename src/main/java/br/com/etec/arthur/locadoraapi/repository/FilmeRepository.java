package br.com.etec.arthur.locadoraapi.repository;

import br.com.etec.arthur.locadoraapi.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long>{
}
