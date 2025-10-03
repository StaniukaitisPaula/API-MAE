package br.com.fiap.mae.repository;

import br.com.fiap.mae.model.BancoHoras;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BancoHorasRepository extends MongoRepository<BancoHoras, String> {

    List<BancoHoras> findByFuncionarioId(String funcionarioId);
}