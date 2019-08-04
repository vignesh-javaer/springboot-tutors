/**
 * 
 */
package com.personal.fervour.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.fervour.model.UserInfo;

/**
 * @author vignesh
 *
 */
public interface UserInfoDao 
						extends JpaRepository<UserInfo, Long> {

}
