package br.com.fiap.mae.infra.exception;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<StandardError> tratarExcecaoRegraNegocio(NegocioException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(buildError(status, "Erro de regra de negócio", e, request));
    }

    @ExceptionHandler(UniqueException.class)
    public ResponseEntity<StandardError> tratarErroUnique(UniqueException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(buildError(status, "Recurso já existente", e, request));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> tratarErroUnicidade(DataIntegrityViolationException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(buildError(status, "Violação de integridade de dados", e, request));
    }

    @ExceptionHandler(DuplicateKeyException.class) // específico do MongoDB para índice único
    public ResponseEntity<StandardError> tratarErroChaveDuplicada(DuplicateKeyException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(buildError(status, "Registro duplicado (índice único no Mongo)", e, request));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroValidacao>> tratarErroValidacao(MethodArgumentNotValidException e) {
        List<FieldError> erros = e.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(ErroValidacao::new).collect(Collectors.toList()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> tratarErroGeral(Exception e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(status).body(buildError(status, "Erro inesperado", e, request));
    }

    private StandardError buildError(HttpStatus status, String errorMsg, Exception e, HttpServletRequest request) {
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError(errorMsg);
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return error;
    }
}
