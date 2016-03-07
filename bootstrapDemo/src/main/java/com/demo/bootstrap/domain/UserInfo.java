package com.demo.bootstrap.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Scope;

import com.google.common.base.MoreObjects;
@Scope("session")
@Entity
@Table(name="TB_USER_INFO")
public class UserInfo extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	public UserInfo(){
	}
	
	public UserInfo(String id, String password){
		this.id = id;
		this.passWord = password;
	}
	@NotNull
	@Size(max = 100)
	@Id
	private String id;
	
	@Column(length=20)
	private String name;
	
	//@Min(1)
    //@Max(130)
	@NotNull
	@Size(max = 10)
	@Column(length=10)
	private String passWord;
	
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastAccessTime;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="TEAM_ID")
	private Team team;
	
	@Enumerated(EnumType.STRING)
	private ActiveType activeType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public Date getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public ActiveType getActiveType() {
		return activeType;
	}

	public void setActiveType(ActiveType activeType) {
		this.activeType = activeType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString(){
		return MoreObjects.toStringHelper(this)
				.add("id", this.id)
				.add("password", this.passWord)
				.add("name", this.name)
				.add("active", this.activeType.toString())
				.toString();
	}
}
