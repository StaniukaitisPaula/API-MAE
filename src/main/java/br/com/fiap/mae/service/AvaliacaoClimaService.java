package br.com.fiap.mae.service;

import org.springframework.stereotype.Service;

@Service
public class AvaliacaoClimaService {

    public String classificarRisco(Double percentual) {
        if (percentual == null) return "Indefinido";
        if (percentual <= 25) return "Neutro";
        else if (percentual <= 50) return "Leve";
        else if (percentual <= 75) return "Moderado";
        else return "Agudo";
    }

    public String classificarCargaTrabalho(Double percentual) {
        if (percentual == null) return "Indefinido";
        if (percentual <= 20) return "Muito Leve";
        else if (percentual <= 40) return "Leve";
        else if (percentual <= 60) return "Média";
        else if (percentual <= 80) return "Alta";
        else return "Muito Alta";
    }

    public String classificarSinaisAlerta(Double percentual) {
        return classificarCargaTrabalho(percentual);
    }

    public String classificarDiagnostico(Double nota) {
        if (nota == null) return "Indefinido";
        if (nota >= 1 && nota <= 2.4) return "Atenção";
        else if (nota >= 2.5 && nota <= 3.4) return "Zona de Alerta";
        else return "Ambiente Saudável";
    }
}