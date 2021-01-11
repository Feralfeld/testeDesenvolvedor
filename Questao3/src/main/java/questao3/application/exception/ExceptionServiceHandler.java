package questao3.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import questao3.application.dto.ErroExecucaoResponse;


@RestControllerAdvice
public class ExceptionServiceHandler {

	@ExceptionHandler(value = { ProcessoException.class })
	public ResponseEntity<Object> processoExceptionHandler(ProcessoException ex) {
		return new ResponseEntity<>(new ErroExecucaoResponse(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

