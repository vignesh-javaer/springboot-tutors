/**
 * 
 */
package com.personal.fervour.service;

import java.util.List;
import java.util.Optional;

import com.personal.fervour.model.UserInfo;

/**
 * @author vignesh
 *
 */
public interface UserInfoService {
	
	UserInfo addUser(UserInfo user);
	
	boolean deleteUser(String userId);
	
	UserInfo updateUser(UserInfo user);
	
	UserInfo getUserById(String userId);
	
	Optional<UserInfo> getUserByEmail(String email);
	
	Optional<UserInfo> getUserByMobile(String mobile);
	
	boolean userExist(String userId);
	
	List<UserInfo> retrieveAllUser(); // only for administrative purpose.
	
}
