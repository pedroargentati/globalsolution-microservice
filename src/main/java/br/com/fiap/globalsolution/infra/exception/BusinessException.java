package br.com.fiap.globalsolution.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) 
public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	public BusinessException(String errorMessage) {
		super("Erro! ".concat(errorMessage));
	}
	
	public BusinessException() {
		super("Erro de regra de negócio! ");
	}
}
