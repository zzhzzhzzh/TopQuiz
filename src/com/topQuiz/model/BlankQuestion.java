package com.topQuiz.model;

public class BlankQuestion {
	private int id;
	private String question;
	private String answer;
	
	
	public BlankQuestion() {
		super();
	}


	public BlankQuestion(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
