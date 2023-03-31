package br.com.alura.libguagendsapi.infra;

import br.com.alura.libguagendsapi.domain.exceptions.CadastroInvalidoException;
import br.com.alura.libguagendsapi.domain.exceptions.LinguagemNaoEncontradaException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorsHandler {
    @ExceptionHandler(LinguagemNaoEncontradaException.class)
    public ResponseEntity notFound(LinguagemNaoEncontradaException ex) {
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(CadastroInvalidoException.class)
    public ResponseEntity badRequest(CadastroInvalidoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
