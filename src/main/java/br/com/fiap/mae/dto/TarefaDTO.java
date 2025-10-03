package br.com.fiap.mae.dto;
import br.com.fiap.mae.model.Tarefa;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class TarefaDTO {

    private String idTarefa;
    private String descricao;
    private LocalDate prazo;
    private Double horasGastas;
    private String idFuncionario;

    public TarefaDTO(Tarefa tarefa) {
        if (tarefa == null) return;
        this.idTarefa = tarefa.getId();
        this.descricao = tarefa.getDescricao();
        this.prazo = tarefa.getPrazo();
        this.horasGastas = tarefa.getHorasGastas();
        this.idFuncionario = tarefa.getFuncionarioId();
    }
}