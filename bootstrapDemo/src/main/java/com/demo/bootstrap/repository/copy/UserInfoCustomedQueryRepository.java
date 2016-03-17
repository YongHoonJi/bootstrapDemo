package com.demo.bootstrap.repository.copy;

import org.springframework.stereotype.Repository;

import com.demo.bootstrap.domain.UserInfo;

@Repository
public interface UserInfoCustomedQueryRepository {
	public UserInfo joinResult(String id);
	public UserInfo athenticateUser(UserInfo userInfo) throws Exception;
}
