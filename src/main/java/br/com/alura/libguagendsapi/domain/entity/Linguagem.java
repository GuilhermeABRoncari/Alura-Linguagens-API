package br.com.alura.libguagendsapi.domain.entity;

import br.com.alura.libguagendsapi.domain.dto.LinguagemDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "principaisLinguagens")
@Getter
@NoArgsConstructor
public class Linguagem {
    @Id
    private String id;
    private String title;
    private String image;
    private Integer ranking;

    public Linguagem(String title, String image, Integer ranking) {
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }

    public void update(LinguagemDTO linguagemDTO) {
        if (linguagemDTO.title() != null) this.title = linguagemDTO.title();
        if (linguagemDTO.image() != null) this.image = linguagemDTO.image();
        if (linguagemDTO.ranking() != null) this.ranking = linguagemDTO.ranking();
    }

}
