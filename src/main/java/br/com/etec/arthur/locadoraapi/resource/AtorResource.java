package br.com.etec.arthur.locadoraapi.resource;

import br.com.etec.arthur.locadoraapi.model.Ator;
import br.com.etec.arthur.locadoraapi.repository.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("atores")
public class AtorResource {

    @Autowired
    private AtorRepository atorRepository;

    @GetMapping("/todos")
    public List<Ator> listarTodosAtores() {
        return atorRepository.findAll();
    }

    // teste http: localhost:8080/atores/todos
}
