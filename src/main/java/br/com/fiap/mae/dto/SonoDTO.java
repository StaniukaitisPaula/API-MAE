package br.com.fiap.mae.dto;

import br.com.fiap.mae.model.Sono;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class SonoDTO {

    private String id;
    private String funcionarioId;
    private LocalDate data;
    private Double horasDormidas;

    public SonoDTO(Sono entity) {
        this.id = entity.getId();
        this.funcionarioId = entity.getFuncionarioId();
        this.data = entity.getData();
        this.horasDormidas = entity.getHorasDormidas();
    }
}
