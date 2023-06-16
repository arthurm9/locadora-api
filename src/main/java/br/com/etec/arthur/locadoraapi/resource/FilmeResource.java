package br.com.etec.arthur.locadoraapi.resource;

import br.com.etec.arthur.locadoraapi.model.Ator;
import br.com.etec.arthur.locadoraapi.model.Filme;
import br.com.etec.arthur.locadoraapi.repository.FilmeRepository;
import br.com.etec.arthur.locadoraapi.repository.filter.AtorFilter;
import br.com.etec.arthur.locadoraapi.repository.filter.FilmeFilter;
import br.com.etec.arthur.locadoraapi.repository.projections.FilmeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("filmes")
public class FilmeResource {
    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping("/todos")
    public List<Filme> listarTodosFilmes() {
        return filmeRepository.findAll(Sort.by("nomefilme").ascending());
    }

    @GetMapping()
    public Page<FilmeDto> pesquisar(FilmeFilter filmeFilter, Pageable pageable){
        return filmeRepository.filtrarFilme(filmeFilter, pageable);
    }
}
