package br.com.fiap.mae.repository;


import br.com.fiap.mae.model.AvaliacaoClima;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoClimaRepository extends MongoRepository<AvaliacaoClima, String> {

    // busca por funcionarioId ordenado por dataResposta decrescente
    List<AvaliacaoClima> findByFuncionarioIdOrderByDataRespostaDesc(String funcionarioId);
}