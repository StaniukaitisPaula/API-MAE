package br.com.fiap.mae.dto;

import br.com.fiap.mae.model.BancoHoras;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BancoHorasDTO {

    private String idBancoHoras;
    private LocalDate data;
    private Double horasExtras;
    private Double horasPagas;
    private String idFuncionario;

    public BancoHorasDTO(BancoHoras bancoHoras) {
        if (bancoHoras == null) return;
        this.idBancoHoras = bancoHoras.getId();
        this.data = bancoHoras.getData();
        this.horasExtras = bancoHoras.getHorasExtras();
        this.horasPagas = bancoHoras.getHorasPagas();
        this.idFuncionario = bancoHoras.getFuncionarioId();
    }
}