/**
 * 
 */
package com.personal.fervour.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.fervour.dao.UserInfoDao;
import com.personal.fervour.model.UserInfo;
import com.personal.fervour.service.UserInfoService;

/**
 * @author vignesh
 *
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{
	
	
	@Autowired private UserInfoDao userInfoRepo;

	@Override
	public UserInfo addUser(UserInfo user) {
		return userInfoRepo.save(user);
	}

	@Override
	public boolean deleteUser(String userId) {
		Optional<UserInfo> userInfo = userInfoRepo.findById(userId);
		if(!userInfo.isPresent()) {
			return false;
		}
		userInfoRepo.delete(userInfo.get());
		return true;
	}

	@Override
	public UserInfo updateUser(UserInfo user) {
		return userInfoRepo.saveAndFlush(user);
	}

	@Override
	public UserInfo getUserById(String userId) {
		return userInfoRepo.getOne(userId);
	}

	@Override
	public Optional<UserInfo> getUserByEmail(String email) {
		return userInfoRepo.getUserByEmail(email);
	}

	@Override
	public Optional<UserInfo> getUserByMobile(String mobile) {
		return userInfoRepo.getUserByMobile(mobile);
	}

	@Override
	public List<UserInfo> retrieveAllUser() {
		return userInfoRepo.findAll();
	}

	@Override
	public boolean userExist(String userId) {
		return userInfoRepo.existsById(userId);
	}

	
}
