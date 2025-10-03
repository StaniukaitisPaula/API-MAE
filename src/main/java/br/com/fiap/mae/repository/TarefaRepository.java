package br.com.fiap.mae.repository;

import br.com.fiap.mae.model.Tarefa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends MongoRepository<Tarefa, String> {

    List<Tarefa> findByFuncionarioId(String funcionarioId);
}