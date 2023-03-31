package br.com.alura.libguagendsapi.domain.repository;

import br.com.alura.libguagendsapi.domain.entity.Linguagem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinguagemRepository extends MongoRepository<Linguagem, String> {
    boolean existsByTitle(String title);

    boolean existsByImage(String image);

    boolean existsByRanking(Integer ranking);
}
