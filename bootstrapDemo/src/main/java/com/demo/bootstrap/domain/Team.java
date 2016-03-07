package com.demo.bootstrap.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="TB_TEAM")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="TEAM_ID")
	private Long teamId;
	
	@Enumerated(EnumType.STRING)
	private TeamType teamType;
	
	@NotNull
	@Size(max = 50)
	@Column(length=50)
	private String name;
	
	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public TeamType getTeamNameType() {
		return teamType;
	}

	public void setTeamNameType(TeamType teamType) {
		this.teamType = teamType;
	}

	public TeamType getTeamType() {
		return teamType;
	}

	public void setTeamType(TeamType teamType) {
		this.teamType = teamType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
