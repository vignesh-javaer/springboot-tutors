/**
 * 
 */
package com.personal.fervour.cmm.response;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.personal.fervour.target.model.CustomExceptionMessage;
import com.personal.fervour.target.resource.exception.UserAlreadyExistedException;
import com.personal.fervour.target.resource.exception.UserNotFoundException;

/**
 * @author vignesh
 *
 */
@ControllerAdvice
@RestController
public class GenericResponseEntityExceptionHandler 
				extends ResponseEntityExceptionHandler  {
	
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		@NotNull final CustomExceptionMessage message = CustomExceptionMessage
					.builder()
					.timeStamp(new Date())
					.debugMsg("Unknown Exception occured")
					.message(ex.getMessage())
					.path(request.getDescription(false)).build();
		return new ResponseEntity<Object>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(UserAlreadyExistedException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {
		@NotNull final CustomExceptionMessage message = CustomExceptionMessage
					.builder()
					.timeStamp(new Date())
					.debugMsg(ex.toString())
					.message(ex.getLocalizedMessage())
					.path(request.getDescription(false)).build();
		return new ResponseEntity<Object>(message, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserAlreadyExistException(Exception ex, WebRequest request) {
		@NotNull final CustomExceptionMessage message = CustomExceptionMessage
					.builder()
					.timeStamp(new Date())
					.debugMsg(ex.toString())
					.message(ex.getLocalizedMessage())
					.path(request.getDescription(false)).build();
		return new ResponseEntity<Object>(message, HttpStatus.NOT_FOUND);
	}

}
