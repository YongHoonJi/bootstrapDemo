package com.demo.bootstrap.domain;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseDocument {

	@Enumerated(EnumType.STRING)
	private LocaleType localeType;
	
	@Column(length=8)
	private String applDate;
	
	@Column(length=13)
	private String pubNum;
	
	@Column(length=8)
	private String pubDate;
	
	@Column(length=13)
	private String openNum;
	
	@Column(length=8)
	private String openDate;
	
	@Column(length=13)
	private String regNum;
	
	@Column(length=8)
	private String regDate;
	
	@Column(length=255)
	private String filePath;
	
	@Column(length=255)
	private String ipc;
	
	@Column(length=255)
	private String cpc;
	
	@Column(length=255)
	private String agent;
	
	@Column(length=255)
	private String inventor;
	
	@Column(length=255)
	private String examiner;
	
	@Column(length=255)
	private String applicant;
	
	@Column(length=255)
	private String rightHolder;
	
	@Enumerated(EnumType.STRING)
	private LocaleType locale;

	public LocaleType getLocaleType() {
		return localeType;
	}

	public void setLocaleType(LocaleType localeType) {
		this.localeType = localeType;
	}

	public String getApplDate() {
		return applDate;
	}

	public void setApplDate(String applDate) {
		this.applDate = applDate;
	}

	public String getPubNum() {
		return pubNum;
	}

	public void setPubNum(String pubNum) {
		this.pubNum = pubNum;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getOpenNum() {
		return openNum;
	}

	public void setOpenNum(String openNum) {
		this.openNum = openNum;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getIpc() {
		return ipc;
	}

	public void setIpc(String ipc) {
		this.ipc = ipc;
	}

	public String getCpc() {
		return cpc;
	}

	public void setCpc(String cpc) {
		this.cpc = cpc;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getInventor() {
		return inventor;
	}

	public void setInventor(String inventor) {
		this.inventor = inventor;
	}

	public String getExaminer() {
		return examiner;
	}

	public void setExaminer(String examiner) {
		this.examiner = examiner;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getRightHolder() {
		return rightHolder;
	}

	public void setRightHolder(String rightHolder) {
		this.rightHolder = rightHolder;
	}

	public LocaleType getLocale() {
		return locale;
	}

	public void setLocale(LocaleType locale) {
		this.locale = locale;
	}
}
