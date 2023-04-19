package br.com.etec.arthur.locadoraapi.resource;

import br.com.etec.arthur.locadoraapi.model.Genero;
import br.com.etec.arthur.locadoraapi.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    // teste http: localhost:8080/generos/todos
}
