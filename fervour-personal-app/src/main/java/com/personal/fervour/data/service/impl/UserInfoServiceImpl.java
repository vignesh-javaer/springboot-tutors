/**
 * 
 */
package com.personal.fervour.data.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.personal.fervour.data.dao.UserInfoDao;
import com.personal.fervour.data.service.UserInfoService;
import com.personal.fervour.target.model.UserInfo;

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
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public UserInfo updateUser(UserInfo user) {
		return userInfoRepo.save(user);
	}

	@Override
	public Optional<UserInfo> getUserById(String userId) {
		return userInfoRepo.findById(userId);
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
