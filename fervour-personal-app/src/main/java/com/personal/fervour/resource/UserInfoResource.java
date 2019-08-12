/**
 * 
 */
package com.personal.fervour.resource;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.personal.fervour.model.UserInfo;
import com.personal.fervour.response.ResponseEntityMapper;
import com.personal.fervour.response.ResponseType;
import com.personal.fervour.service.impl.UserInfoServiceImpl;

import lombok.NonNull;

/**
 * @author vignesh
 *
 */
@RestController
@RequestMapping("/users")
public class UserInfoResource implements ResponseEntityMapper<UserInfo>{

	@Autowired
	public UserInfoServiceImpl userInfoSvc;

	@PostMapping("/profile")
	public ResponseEntity<UserInfo> addUser(@Valid @RequestBody @NonNull final UserInfo userInfo) {
		boolean exist = userInfoSvc.userExist(userInfo.getUserId());
		if(exist) {
			return getResponse(ResponseType.ERROR, null, null, HttpStatus.CONFLICT);
		}
		final UserInfo addUser = userInfoSvc.addUser(userInfo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return getResponse(ResponseType.ERROR, addUser, uri, HttpStatus.CONFLICT);
	}

	@PostMapping("/profile/{id}")
	public void getUser() {

	}

	@PutMapping("/profile")
	public void updateUser() {

	}

	@PutMapping("/profile/{id}")
	public void deactivateUser() {

	}

	// create DELETE method in a cronJob.

}
