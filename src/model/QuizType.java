package com.topQuiz.model;

/**
 * quiz type entity
 * @author jady
 *
 */
public class QuizType {
	private int id;
	private String quizTypeName;
	private String quizTypeDesc;

	public QuizType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuizType(String quizTypeName, String quizTypeDesc) {
		super();
		this.quizTypeName = quizTypeName;
		this.quizTypeDesc = quizTypeDesc;
	}

	public QuizType(int id, String quizTypeName, String quizTypeDesc) {
		super();
		this.id = id;
		this.quizTypeName = quizTypeName;
		this.quizTypeDesc = quizTypeDesc;
	}

	// to ensure the JCB correctly show type names on add form
	@Override
	public String toString() {
		return quizTypeName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuizTypeName() {
		return quizTypeName;
	}
	public void setQuizTypeName(String quizTypeName) {
		this.quizTypeName = quizTypeName;
	}
	public String getQuizTypeDesc() {
		return quizTypeDesc;
	}
	public void setQuizTypeDesc(String quizTypeDesc) {
		this.quizTypeDesc = quizTypeDesc;
	}
}
