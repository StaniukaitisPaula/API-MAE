package br.com.fiap.mae.service;

import br.com.fiap.mae.model.AvaliacaoClima;
import br.com.fiap.mae.repository.AvaliacaoClimaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RelatorioService {

    @Autowired
    private BancoHorasService bancoHorasService;

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private AvaliacaoClimaRepository avaliacaoClimaRepository;

    public Map<String, Object> gerarRelatorioFuncionario(String funcionarioId) {
        Map<String, Object> relatorio = new HashMap<>();

        // Banco de Horas
        Double saldoHoras = bancoHorasService.calcularSaldoHoras(funcionarioId);
        relatorio.put("saldoBancoHoras", saldoHoras);

        // Tarefas
        Double totalHorasTarefas = tarefaService.calcularTotalHorasGastas(funcionarioId);
        relatorio.put("totalHorasTarefas", totalHorasTarefas);

        // Notificação de Horas
        boolean ultrapassouLimite = tarefaService.ultrapassouLimite(funcionarioId);
        relatorio.put("notificacaoHoras", ultrapassouLimite ? "Atenção: Excedeu 8 horas!" : "Dentro do limite");

        // Últimas Avaliações de Clima
        List<AvaliacaoClima> avaliacoes = avaliacaoClimaRepository.findByFuncionarioIdOrderByDataRespostaDesc(funcionarioId);
        relatorio.put("avaliacoesClima", avaliacoes);

        return relatorio;
    }
}
