package com.demo.bootstrap.domain.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DocumentKey implements Serializable{
	@Column(nullable=false, length=13)
	private String applNum;
	@Column(nullable=false, length=13)
	private String kindCode;
	
	public String getApplNum() {
		return applNum;
	}
	public void setApplNum(String applNum) {
		this.applNum = applNum;
	}
	public String getKindCode() {
		return kindCode;
	}
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
}
