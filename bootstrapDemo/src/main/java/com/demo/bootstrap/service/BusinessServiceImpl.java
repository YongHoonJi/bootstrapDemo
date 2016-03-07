package com.demo.bootstrap.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.demo.bootstrap.domain.ActiveType;
import com.demo.bootstrap.domain.Biblio;
import com.demo.bootstrap.domain.Team;
import com.demo.bootstrap.domain.TeamType;
import com.demo.bootstrap.domain.UserInfo;
import com.demo.bootstrap.domain.UserRole;
import com.demo.bootstrap.repository.BiblioRepository;
import com.demo.bootstrap.repository.TeamRepository;
import com.demo.bootstrap.repository.UserInfoCustomedQueryRepository;
import com.demo.bootstrap.repository.UserInfoRepository;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;


/**
 * add business logic here
 */
@Service
public class BusinessServiceImpl implements BusinessService{
	private static final Logger log = LoggerFactory.getLogger(BusinessServiceImpl.class);
	
	@Autowired
	private UserInfoRepository userRepository;
	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private UserInfoCustomedQueryRepository searchRepository;
	@Autowired
	private BiblioRepository biblioRepository;
	
	@Override
	@Transactional
	public void saveUser(UserInfo user){
		Team team = teamRepository.findOne(new Long(1));
		// if the row is existed, update the row given by the entity.
		userRepository.save(this.createMockUser(user.getId(), user.getName(), team));
	}
	
	@Override
	@Transactional
	public UserInfo findOneUserByQueryDsl(String email) throws Exception {
		return searchRepository.joinResult(email);
	}

	@Override
	@Transactional
	public List<UserInfo> findListWithPagination(UserInfo user, Pageable pageable) {
		return userRepository.findAllByName(user.getName(), pageable);
	}
	
	private UserInfo createMockUser(String id, String name, Team team){
		UserInfo user = new UserInfo();
		user.setId(id);
		user.setName(name);
		user.setPassWord("111");
		user.setCreatedDate(new Date());
		user.setActiveType(ActiveType.Y);
		user.setUserRole(UserRole.SUPERVISIOR);
		user.setTeam(team);
    	return user;
	}
	
	@Override
	@Transactional
	public UserInfo athenticateUser(UserInfo user) throws Exception {
		UserInfo resutOfUserInfo = null;
		if(!user.getId().equals("") && !user.getPassWord().equals("")){
			try {
				resutOfUserInfo = userRepository.findByIdAndPassWord(user.getId(), user.getPassWord());
				Preconditions.checkNotNull(searchRepository);
				log.info(resutOfUserInfo.toString());
			} catch (NullPointerException e) {
				log.info("no user found");
			}
		}
		return resutOfUserInfo;
	}
	
	@Override
	@Transactional
	public void saveTestData(){
		
		List<Team> teamList = teamRepository.findAll();
		if(teamList.size() == 0){
			Team team = new Team();
			team.setTeamNameType(TeamType.DEV);
			teamRepository.save(team);
		}
		
		List<UserInfo> userList = userRepository.findAll();
		
		if(userList.size() == 0){
			UserInfo user = new UserInfo();
			user.setActiveType(ActiveType.Y);
			user.setCreatedDate(new Date());
			user.setId("test@a.kr");
			user.setName("jyh");
			user.setPassWord("111");
			userRepository.save(user);
		};
	}

	@Override
	public List<Biblio> findAllBiblio() {
		return biblioRepository.findAll();
	}
	
}

