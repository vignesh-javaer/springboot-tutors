/**
 * 
 */
package com.personal.fervour.target.resource;

import java.net.URI;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.personal.fervour.cmm.response.ResponseEntityMapper;
import com.personal.fervour.cmm.response.ResponseType;
import com.personal.fervour.data.service.impl.UserInfoServiceImpl;
import com.personal.fervour.target.model.UserInfo;
import com.personal.fervour.target.resource.exception.UserAlreadyExistedException;
import com.personal.fervour.target.resource.exception.UserNotFoundException;

import lombok.NonNull;

/**
 * @author vignesh
 *
 */
@RestController
@RequestMapping("/users")
public class UserInfoResource implements ResponseEntityMapper<UserInfo> {

	@Autowired
	public UserInfoServiceImpl userInfoSvc;

	@PostMapping("/profile")
	public ResponseEntity<UserInfo> addUser(
			@Valid @RequestBody @NonNull final UserInfo userInfo) {
		final boolean exist = userInfoSvc.userExist(userInfo.getUserId());
		if (exist) {
			throw new UserAlreadyExistedException("User already existed.");
		}
		final UserInfo addUser = userInfoSvc.addUser(userInfo);
		final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(addUser.getUserId()).toUri();
		return getResponse(ResponseType.ADD, addUser, uri, null);
	}

	@GetMapping("/profile/{id}")
	public ResponseEntity<UserInfo> getUser(@PathVariable("id") String userId) {
		final Optional<UserInfo> userInfo = userInfoSvc.getUserById(userId);
		if (!userInfo.isPresent()) {
			throw new UserNotFoundException("User not found for userId: " + userId);
		}
		// final URI uri =
		// ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return getResponse(ResponseType.GET, userInfo.get(), null, HttpStatus.OK);

	}

	@PutMapping("/profile")
	public ResponseEntity<UserInfo> updateUser(
			@Valid @RequestBody @NonNull final UserInfo userInfo) {
		final boolean exist = userInfoSvc.userExist(userInfo.getUserId());
		if (exist) {
			throw new UserNotFoundException("User not found");
		}
		userInfo.setLastUpdateDate(new Date());
		final UserInfo user = userInfoSvc.updateUser(userInfo);
		final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return getResponse(ResponseType.UPDATE, user, uri, HttpStatus.OK);
	}

	@GetMapping("/profile/{id}/deactivate")
	public ResponseEntity<UserInfo> deactivateUser(@PathVariable("id") String userId) {
		final Optional<UserInfo> userInfo = userInfoSvc.getUserById(userId);
		if (!userInfo.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		final UserInfo user = userInfo.get();
		user.setStatus("DISABLE");
		user.setLastUpdateDate(new Date());
		user.setLastLoginDate(new Date());

		final UserInfo updatedUser = userInfoSvc.updateUser(user);
		final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return getResponse(ResponseType.UPDATE, updatedUser, uri, HttpStatus.OK);
	}

	// create DELETE method in a cronJob.
	@DeleteMapping("/profile/{id}")
	public ResponseEntity<UserInfo> deleteUser(@PathVariable("id") String userId) {
		final boolean deleteUser = userInfoSvc.deleteUser(userId);
		if (deleteUser == false) {
			throw new UserNotFoundException("User not found");
		}
		return getResponse(ResponseType.DELETE, null, null, HttpStatus.OK);
	}

}
