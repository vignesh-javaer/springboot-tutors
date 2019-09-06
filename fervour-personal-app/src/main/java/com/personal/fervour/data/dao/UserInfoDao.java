/**
 * 
 */
package com.personal.fervour.data.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.personal.fervour.target.model.UserInfo;

/**
 * @author vignesh
 *
 */
@Repository
public interface UserInfoDao extends CrudRepository<UserInfo, String>, JpaRepository<UserInfo, String> {
	
	@Query("SELECT u FROM UserInfo u WHERE u.email=:email")
	public Optional<UserInfo> getUserByEmail(@Param("email") String email);
	
	@Query("SELECT u FROM UserInfo u WHERE u.mobile=:mobile")
	public Optional<UserInfo> getUserByMobile(@Param("mobile") String mobile);

}
