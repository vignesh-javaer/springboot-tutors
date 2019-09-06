package com.personal.fervour.target.resource.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class TaskDoesNotExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1109587357392123647L;

	public TaskDoesNotExistsException(String message) {
		super(message);
	}

}
