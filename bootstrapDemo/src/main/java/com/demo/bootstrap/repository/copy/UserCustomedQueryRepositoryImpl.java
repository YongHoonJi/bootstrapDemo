package com.demo.bootstrap.repository.copy;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.demo.bootstrap.domain.QTeam;
import com.demo.bootstrap.domain.QUserInfo;
import com.demo.bootstrap.domain.UserInfo;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.Predicate;

@Repository
public class UserCustomedQueryRepositoryImpl extends QueryDslRepositorySupport implements UserInfoCustomedQueryRepository{

	public UserCustomedQueryRepositoryImpl() {
		super(UserInfo.class);
	}

	/* get results by using query DSL
	 * @see com.systrangroup.web.template.example.repository.ElaboratedCustomedQueryRepository#joinResult(java.lang.Long)
	 */
	@Override
	public UserInfo joinResult(String email) {
		QUserInfo user = QUserInfo.userInfo;
		QTeam team = QTeam.team;
		Predicate p = QUserInfo.userInfo.id.toLowerCase().eq(email);
		JPQLQuery query = from(user).innerJoin(user.team, team).where(p);
		return query.singleResult(user);
	}

	@Override
	public UserInfo athenticateUser(UserInfo userInfo) throws Exception {
		Predicate right = QUserInfo.userInfo.passWord.eq(userInfo.getPassWord());
		Predicate left = QUserInfo.userInfo.id.toLowerCase().eq(userInfo.getId()).and(right);
		QUserInfo user = QUserInfo.userInfo;
		JPQLQuery query = from(user).where(left);
		return query.singleResult(user);
	}

}
