package br.com.fiap.mae.repository;

import br.com.fiap.mae.model.Sono;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SonoRepository extends MongoRepository<Sono, String> {

    List<Sono> findByFuncionarioId(String funcionarioId);

    List<Sono> findByFuncionarioIdAndDataBetween(String funcionarioId, LocalDate inicio, LocalDate fim);
}
