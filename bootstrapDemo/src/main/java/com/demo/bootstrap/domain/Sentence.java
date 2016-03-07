package com.demo.bootstrap.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_SENTENCE")
public class Sentence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SENTENCE_ID")
	private Long sentenceId;
	
	@Column(length=500)
	private String sentence;
	
	private int length;
	
	private String addition;

	 @ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumns({
	        @JoinColumn(name="applNum", referencedColumnName="applNum"),
	        @JoinColumn(name="kindCode", referencedColumnName="kindCode")
	  })	 
	private Biblio biblio;
	
	public Biblio getBiblio() {
		return biblio;
	}

	public void setBiblio(Biblio biblio) {
		this.biblio = biblio;
	}


	public Long getSentenceId() {
		return sentenceId;
	}

	public void setSentenceId(Long sentenceId) {
		this.sentenceId = sentenceId;
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getAddition() {
		return addition;
	}

	public void setAddition(String addition) {
		this.addition = addition;
	}
}
