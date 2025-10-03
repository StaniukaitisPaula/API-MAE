package br.com.fiap.mae.dto;

import br.com.fiap.mae.model.Funcionario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FuncionarioDTO {
    private String idFuncionario;
    private String email;
    private String senha;

    public FuncionarioDTO(Funcionario funcionario) {
        if (funcionario == null) return;
        this.idFuncionario = funcionario.getId();
        this.email = funcionario.getEmail();
        this.senha = funcionario.getSenha();
    }
}