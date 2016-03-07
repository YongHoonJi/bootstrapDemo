package com.demo.bootstrap.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.bootstrap.domain.UserInfo;

// JpaRepository extends PagingAndSortingRepository , which in turn extends CrudRepository.
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
	List<UserInfo> findAllByName(String email, Pageable pageable);
	UserInfo findByIdAndPassWord(String email, String password);
}
