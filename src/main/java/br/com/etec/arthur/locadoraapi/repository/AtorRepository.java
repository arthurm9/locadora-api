package br.com.etec.arthur.locadoraapi.repository;

import br.com.etec.arthur.locadoraapi.model.Ator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Long>{
}
