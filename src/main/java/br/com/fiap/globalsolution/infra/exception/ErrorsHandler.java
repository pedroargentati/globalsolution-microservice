package br.com.fiap.globalsolution.infra.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ErrorsHandler {

	/**
	 * @description Se em qualquer controller do projeto for lançada uma Exception
	 *              'EntityNotFoundException', o método 'handleError404' será
	 *              chamado.
	 * 
	 * @return Not Found exception (404).
	 **/
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleError404() {
		return ResponseEntity.notFound().build();
	}

	/**
	 * @description Se em qualquer controller do projeto for lançada uma Exception
	 *              'MethodArgumentNotValidException', o método 'handleError400'
	 *              será chamado.
	 * 
	 * @return Not Found exception (400).
	 **/
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleError400(MethodArgumentNotValidException exception) {
		var errors = exception.getFieldErrors();

		return ResponseEntity.badRequest().body(errors.stream().map(ValidationErrorData::new).toList());
	}

	/**
	 * @description Se em qualquer controller do projeto for lançada uma Exception
	 *              'SecurityException', o método 'handleSecurityException' será
	 *              chamado.
	 * 
	 * @return UNAUTHORIZED (401).
	 **/
	@ExceptionHandler(SecurityException.class)
	public ResponseEntity<String> handleSecurityException(SecurityException exception) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exception.getMessage());
	}

	/**
	 * @description Método genérico para lidar com exceções não mapeadas
	 *
	 * @return INTERNAL SERVER ERROR (500)
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno do servidor");
	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Map<String, Object>> handleBusinessException(BusinessException exception) {
		Map<String, Object> error = new HashMap<>();
		error.put("message", exception.getMessage());
		error.put("localizedMessage", exception.getLocalizedMessage());
		error.put("status", HttpStatus.BAD_REQUEST.value());

		// Obter o URI da solicitação atual
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		String uri = request.getRequestURI();
		error.put("uri", uri);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	private record ValidationErrorData(String code, String message) {
		public ValidationErrorData(FieldError error) {
			this(error.getField(), error.getDefaultMessage());
		}
	}

}
