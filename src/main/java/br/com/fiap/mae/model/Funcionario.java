package br.com.fiap.mae.model;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "funcionarios")
public class Funcionario {

    @Id
    private String id;

    private String email;
    private String senha;
}