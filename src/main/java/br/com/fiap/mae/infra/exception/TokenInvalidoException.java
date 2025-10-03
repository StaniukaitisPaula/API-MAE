package br.com.fiap.mae.infra.exception;

public class TokenInvalidoException extends RuntimeException {

    // Construtores para a exceção
    public TokenInvalidoException(String message) {
        super(message);
    }

    public TokenInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenInvalidoException(Throwable cause) {
        super(cause);
    }
}