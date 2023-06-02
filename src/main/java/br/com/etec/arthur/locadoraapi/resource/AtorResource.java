package br.com.etec.arthur.locadoraapi.resource;

import br.com.etec.arthur.locadoraapi.model.Ator;
import br.com.etec.arthur.locadoraapi.repository.AtorRepository;
import br.com.etec.arthur.locadoraapi.repository.filter.AtorFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("atores")
public class AtorResource {

    @Autowired
    private AtorRepository atorRepository;

    @GetMapping("/todos")
    public List<Ator> listarTodosAtores() {
        return atorRepository.findAll(Sort.by("nomeator").ascending());
    }

    @GetMapping()
    public Page<Ator> pesquisar(AtorFilter atorFilter, Pageable pageable){
        return atorRepository.filtrarAtor(atorFilter, pageable);
    }
}
