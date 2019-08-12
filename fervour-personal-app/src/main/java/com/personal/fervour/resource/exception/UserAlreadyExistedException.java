package com.personal.fervour.resource.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class UserAlreadyExistedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1109587357392123647L;

	public UserAlreadyExistedException(String message) {
		super(message);
	}

}
