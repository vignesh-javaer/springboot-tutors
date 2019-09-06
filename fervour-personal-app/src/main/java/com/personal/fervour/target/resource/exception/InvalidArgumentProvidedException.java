/**
 * 
 */
package com.personal.fervour.target.resource.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author vignesh
 *
 */
@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class InvalidArgumentProvidedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2667813920764676754L;
	
	
	public InvalidArgumentProvidedException(String message) {
		super(message);
	}
	

}
