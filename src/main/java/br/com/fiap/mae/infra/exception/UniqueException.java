package br.com.fiap.mae.infra.exception;

public class UniqueException extends RuntimeException {
    public UniqueException(String mensagem) {
        super(mensagem);
    }
}
