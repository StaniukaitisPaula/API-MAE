package br.com.fiap.mae.repository;

import br.com.fiap.mae.model.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {

    Optional<Funcionario> findByEmailAndSenha(String email, String senha);
    Optional<Funcionario> findByEmail(String email);
}