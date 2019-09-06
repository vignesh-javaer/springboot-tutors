package com.personal.fervour.cmm.response;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

public interface ResponseEntityMapper<T> {

	default ResponseEntity<T> getResponse(@Nullable ResponseType responseType, 
										  @Nullable T body, 
										  @Nullable URI uri, 
										  @Nullable HttpStatus status) {
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
