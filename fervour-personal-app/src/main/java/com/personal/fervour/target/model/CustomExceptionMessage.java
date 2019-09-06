/**
 * 
 */
package com.personal.fervour.target.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author vignesh
 *
 */
@Data
@Builder
@AllArgsConstructor
public class CustomExceptionMessage {
	private Date timeStamp;	
	private String message;
	private String debugMsg;
	private String path;
}
