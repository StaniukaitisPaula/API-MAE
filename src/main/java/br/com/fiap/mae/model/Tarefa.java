package br.com.fiap.mae.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "tarefas")
public class Tarefa{

    @Id
    private String id;

    private String descricao;
    private LocalDate prazo;
    private Double horasGastas;

    private String funcionarioId;
}
