package com.demo.bootstrap.domain;

import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.demo.bootstrap.domain.key.DocumentKey;


@Entity
@Table(name="TB_BIBLIO")
public class Biblio extends BaseDocument{
	 @EmbeddedId
	 private DocumentKey documentKey;
	 
	 private String onlyKorean;
	 
	 @OneToMany(mappedBy="biblio")
	 private List<Sentence> sentences;

	public DocumentKey getDocumentKey() {
		return documentKey;
	}

	public void setDocumentKey(DocumentKey documentKey) {
		this.documentKey = documentKey;
	}

	public String getOnlyKorean() {
		return onlyKorean;
	}

	public void setOnlyKorean(String onlyKorean) {
		this.onlyKorean = onlyKorean;
	}

	public List<Sentence> getSentences() {
		return sentences;
	}

	public void setSentences(List<Sentence> sentences) {
		this.sentences = sentences;
	}
}
