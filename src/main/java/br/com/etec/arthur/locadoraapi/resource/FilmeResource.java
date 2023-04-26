package br.com.etec.arthur.locadoraapi.resource;

import br.com.etec.arthur.locadoraapi.model.Filme;
import br.com.etec.arthur.locadoraapi.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return filmeRepository.findAll(Sort.by("genero").ascending());
    }
}
