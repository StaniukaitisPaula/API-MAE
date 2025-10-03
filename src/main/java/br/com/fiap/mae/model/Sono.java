package br.com.fiap.mae.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "sonos")
public class Sono {

    @Id
    private String id;

    private String funcionarioId;
    private LocalDate data;
    private Double horasDormidas;
}
