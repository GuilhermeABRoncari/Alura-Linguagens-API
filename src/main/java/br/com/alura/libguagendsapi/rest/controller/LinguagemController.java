package br.com.alura.libguagendsapi.rest.controller;

import br.com.alura.libguagendsapi.domain.dto.LinguagemDTO;
import br.com.alura.libguagendsapi.domain.entity.Linguagem;
import br.com.alura.libguagendsapi.rest.service.LinguagemService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("linguagens")
@AllArgsConstructor
public class LinguagemController {

    private LinguagemService linguagemService;

    @GetMapping
    public List<Linguagem> listar() {
        return linguagemService.listar();
    }

    @GetMapping("{id}")
    public Linguagem encontrar(@PathVariable String id) {
        return linguagemService.encontrar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Linguagem cadastrar(@RequestBody @Valid LinguagemDTO linguagemDTO) {
        return linguagemService.cadastrar(linguagemDTO);
    }

    //no RequestBody não coloquei a @Valid para que os atributos possam vir nulos nessa requisição
    // e fazer o metodo atualizar funcionar corretamente.
    @PutMapping("{id}")
    public Linguagem atualizar(@PathVariable String id, @RequestBody LinguagemDTO linguagemDTO) {
        return linguagemService.atualizar(id, linguagemDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable String id) {
        linguagemService.deletar(id);
    }

}
