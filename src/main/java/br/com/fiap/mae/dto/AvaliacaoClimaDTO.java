package br.com.fiap.mae.dto;

import lombok.Data;

import java.time.LocalDate;

import br.com.fiap.mae.model.AvaliacaoClima;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AvaliacaoClimaDTO {

    private String idAvaliacao;
    private LocalDate dataResposta;
    private Double percentualRisco;
    private Double percentualCargaTrabalho;
    private Double percentualSinaisAlerta;
    private String diagnosticoClima;
    private String idFuncionario;

    public AvaliacaoClimaDTO(AvaliacaoClima avaliacao) {
        if (avaliacao == null) return;
        this.idAvaliacao = avaliacao.getId();
        this.dataResposta = avaliacao.getDataResposta();
        this.percentualRisco = avaliacao.getPercentualRisco();
        this.percentualCargaTrabalho = avaliacao.getPercentualCargaTrabalho();
        this.percentualSinaisAlerta = avaliacao.getPercentualSinaisAlerta();
        this.diagnosticoClima = avaliacao.getDiagnosticoClima();
        this.idFuncionario = avaliacao.getFuncionarioId();
    }
}