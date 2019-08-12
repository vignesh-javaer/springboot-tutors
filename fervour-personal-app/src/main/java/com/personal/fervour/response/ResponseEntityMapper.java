package com.personal.fervour.response;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface ResponseEntityMapper<T> {

	default ResponseEntity<T> getResponse(ResponseType responseType, T body, URI uri, HttpStatus status) {

		ResponseEntity<T> responseEntity = null;

		switch (responseType) {
		
		case ADD:
			if(body == null) {
				responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
			}
			responseEntity = ResponseEntity.created(uri).body(body);
			break;

		case UPDATE:
		case GET:
		case DELETE:
		case DEACTIVATE:
		case ERROR:
			responseEntity = ResponseEntity.status(status).body(body);
			break;
			
			
		default:
			break;

		}
		return responseEntity;
	}

}
