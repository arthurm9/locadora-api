package br.com.etec.arthur.locadoraapi.resource;

import br.com.etec.arthur.locadoraapi.model.Genero;
import br.com.etec.arthur.locadoraapi.repository.GeneroRepository;
import br.com.etec.arthur.locadoraapi.repository.filter.GeneroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("generos")
public class GeneroResource {
    @Autowired
    private GeneroRepository generoRepository;

    @GetMapping("/todos")
    public List<Genero> listarTodosGeneros() {
        return generoRepository.findAll(Sort.by("descricao").ascending());
    }

    @GetMapping()
    public Page<Genero> pesquisar(GeneroFilter generoFilter, Pageable pageable){
        return generoRepository.filtrarGenero(generoFilter, pageable);
    }
}
