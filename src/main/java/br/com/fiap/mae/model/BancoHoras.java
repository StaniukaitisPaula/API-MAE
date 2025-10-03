package br.com.fiap.mae.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "banco_horas")
public class BancoHoras {
    @Id
    private String id;
    private LocalDate data;
    private Double horasExtras;
    private Double horasPagas;
    private String funcionarioId;
}
