package br.com.fiap.mae.repository;

import br.com.fiap.mae.model.CheckupDiario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CheckupDiarioRepository extends MongoRepository<CheckupDiario, String> {

    // buscar todos os checkups de um funcionário
    List<CheckupDiario> findByFuncionarioId(String funcionarioId);

    // buscar checkup de um funcionário em uma data específica
    List<CheckupDiario> findByFuncionarioIdAndData(String funcionarioId, LocalDate data);
}
