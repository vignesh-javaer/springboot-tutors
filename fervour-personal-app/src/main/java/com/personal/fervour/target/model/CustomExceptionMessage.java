/**
 * 
 */
package com.personal.fervour.target.model;

import java.util.Date;

import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import lombok.Builder;
import lombok.Data;

/**
 * @author vignesh
 *
 */
@Data
public class CustomExceptionMessage {
	
	private Date timeStamp;
	private Integer status;
	private String message;
	private String debugMsg;
	private String path;
	
	@Builder
	public CustomExceptionMessage(Date timeStamp, Integer status, String message, String debugMsg, WebRequest path) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.message = message;
		this.debugMsg = debugMsg;
		this.path = ((ServletWebRequest) path).getRequest().getRequestURI().toString();
	}
	
	
}
