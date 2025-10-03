package br.com.fiap.mae.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Data
@Document(collection = "avaliacoes_clima")
public class AvaliacaoClima {

    @Id
    private String id;

    private LocalDate dataResposta;
    private Double percentualRisco;
    private Double percentualCargaTrabalho;
    private Double percentualSinaisAlerta;
    private String diagnosticoClima;

    private String funcionarioId;
}