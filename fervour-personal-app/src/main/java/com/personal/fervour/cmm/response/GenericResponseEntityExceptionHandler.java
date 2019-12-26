/**
 * 
 */
package com.personal.fervour.cmm.response;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
 *         This class used to populate the generic response message to front
 *         controller.
 *
 */
@ControllerAdvice
@RestController
public class GenericResponseEntityExceptionHandler extends
		ResponseEntityExceptionHandler {

	/**
	 * 
	 * This method handle all the exception which are not manually handled
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex,
			WebRequest request) {
		@NotNull
		final CustomExceptionMessage message = CustomExceptionMessage.builder().timeStamp(
				new Date()).debugMsg("Unknown Exception occured").message(ex.getMessage())
				.path(request).build();
		return new ResponseEntity<Object>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * 
	 * This is the exception handler to handle the custom exception
	 * {@link UserAlreadyExistedException}
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(UserAlreadyExistedException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(final Exception ex,
			final WebRequest request) {
		@NotNull
		final CustomExceptionMessage message = CustomExceptionMessage.builder().timeStamp(
				new Date()).debugMsg(ex.toString()).message(ex.getLocalizedMessage())
				.path(request).build();
		return new ResponseEntity<Object>(message, HttpStatus.CONFLICT);
	}

	/**
	 * This is the exception handler to handle the custom exception
	 * {@link UserNotFoundException}
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserAlreadyExistException(
			final Exception ex, final WebRequest request) {
		@NotNull
		final CustomExceptionMessage message = CustomExceptionMessage.builder().timeStamp(
				new Date()).status(HttpStatus.NOT_FOUND.value()).debugMsg(ex.toString())
				.message(ex.getLocalizedMessage()).path(request).build();
		return new ResponseEntity<Object>(message, HttpStatus.NOT_FOUND);
	}

	/**
	 * this method is used to handle the exception when error occurred during
	 * Argument validation
	 * whenever request is received by the controller to the mapped method.
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			final MethodArgumentNotValidException ex, final HttpHeaders headers,
			final HttpStatus status, final WebRequest request) {
		@NotNull
		final CustomExceptionMessage message = CustomExceptionMessage.builder().timeStamp(
				new Date()).status(HttpStatus.BAD_REQUEST.value()).debugMsg(ex
						.getBindingResult().toString()).message(
								"request validation error").path(request).build();
		return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);

	}
}
