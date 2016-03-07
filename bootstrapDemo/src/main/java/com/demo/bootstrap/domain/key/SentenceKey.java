package com.demo.bootstrap.domain.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class SentenceKey implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SENTENCE_ID")
	private Long sentenceId;
	
	@Column(nullable=false, length=13)
	private String applNo;
	
	@Column(nullable=false, length=13)
	private String kindCode;

	public Long getSentenceId() {
		return sentenceId;
	}

	public void setSentenceId(Long sentenceId) {
		this.sentenceId = sentenceId;
	}

	public String getApplNo() {
		return applNo;
	}

	public void setApplNo(String applNo) {
		this.applNo = applNo;
	}

	public String getKindCode() {
		return kindCode;
	}

	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
}
