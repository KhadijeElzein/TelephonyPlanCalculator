package br.com.khadije.telephonyplancalculator.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(NoContentException.class)
	public ResponseEntity<Object>  NoContentExpcetionHandler(NoContentException ex) {
		 ApiError apiException = new ApiError(HttpStatus.NO_CONTENT,"None Value returned.");
		 return new ResponseEntity<>(apiException, apiException.getStatus());
	}
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object>  illegalArgumentExpcetionHandler(IllegalArgumentException ex) {
		 ApiError apiException = new ApiError(HttpStatus.PRECONDITION_FAILED,"Fields are null or minutes are negatives");
		 return new ResponseEntity<>(apiException, apiException.getStatus());
	}
}