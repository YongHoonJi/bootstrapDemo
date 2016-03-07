package com.demo.bootstrap.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.demo.bootstrap.domain.Biblio;
import com.demo.bootstrap.domain.UserInfo;

public interface BusinessService {
	public void saveUser(UserInfo user);
	
	public UserInfo findOneUserByQueryDsl(String email) throws Exception;

	public List<UserInfo> findListWithPagination(UserInfo user, Pageable pageable);
	
	public UserInfo athenticateUser(UserInfo user) throws Exception;
	
	public void saveTestData();
	
	public List<Biblio> findAllBiblio();
}
