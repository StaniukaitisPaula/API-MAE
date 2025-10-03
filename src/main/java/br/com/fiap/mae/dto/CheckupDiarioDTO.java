package br.com.fiap.mae.dto;

import br.com.fiap.mae.model.CheckupDiario;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CheckupDiarioDTO {

    private String id;
    private String funcionarioId;
    private LocalDate data;
    private Integer motivacao;
    private Integer cansaco;
    private Integer preocupacao;
    private Integer estresse;
    private Integer animacao;
    private Integer satisfacao;

    public CheckupDiarioDTO(CheckupDiario entity) {
        if (entity == null) return;
        this.id = entity.getId();
        this.funcionarioId = entity.getFuncionarioId();
        this.data = entity.getData();
        this.motivacao = entity.getMotivacao();
        this.cansaco = entity.getCansaco();
        this.preocupacao = entity.getPreocupacao();
        this.estresse = entity.getEstresse();
        this.animacao = entity.getAnimacao();
        this.satisfacao = entity.getSatisfacao();
    }
}
