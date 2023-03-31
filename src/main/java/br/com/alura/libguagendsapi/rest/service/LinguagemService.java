package br.com.alura.libguagendsapi.rest.service;

import br.com.alura.libguagendsapi.domain.dto.LinguagemDTO;
import br.com.alura.libguagendsapi.domain.entity.Linguagem;
import br.com.alura.libguagendsapi.domain.exceptions.CadastroInvalidoException;
import br.com.alura.libguagendsapi.domain.exceptions.LinguagemNaoEncontradaException;
import br.com.alura.libguagendsapi.domain.repository.LinguagemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class LinguagemService {
    private LinguagemRepository linguagemRepository;

    @Transactional
    public Linguagem cadastrar(LinguagemDTO linguagemDTO) {
        if (
                !linguagemRepository.existsByTitle(linguagemDTO.title()) ||
                !linguagemRepository.existsByImage(linguagemDTO.image()) ||
                !linguagemRepository.existsByRanking(linguagemDTO.ranking())) {
            return linguagemRepository.save(new Linguagem(linguagemDTO.title(), linguagemDTO.image(), linguagemDTO.ranking()));

        } throw new CadastroInvalidoException("Cadastro invalido");
    }
    public List<Linguagem> listar() {
        return linguagemRepository.findAll();
    }

    public Linguagem encontrar(String id) {
        return linguagemRepository.findById(id).orElseThrow(() -> new LinguagemNaoEncontradaException());
    }

    @Transactional
    public Linguagem atualizar(String id, LinguagemDTO linguagemDTO) {
        Linguagem linguagem = linguagemRepository.findById(id).orElseThrow(() -> new LinguagemNaoEncontradaException());
        linguagem.update(linguagemDTO);
        linguagemRepository.save(linguagem);
        return linguagem;
    }

    @Transactional
    public void deletar(String id) {
        linguagemRepository.deleteById(id);
    }
}
