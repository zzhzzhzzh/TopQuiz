package com.topQuiz.model;

/**
 * quiz entity
 * @author jady
 *
 */
public class Quiz {
	private int id;
	private String ques;
	private String ans;
	private Integer quizTypeId;
	private String quizTypeName;
	private String quizDesc;



	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quiz(String ques, String ans, Integer quizTypeId) {
		super();
		this.ques = ques;
		this.ans = ans;
		this.quizTypeId = quizTypeId;
	}

	public Quiz(String ques, String ans, Integer quizTypeId, String quizDesc) {
		super();
		this.ques = ques;
		this.ans = ans;
		this.quizTypeId = quizTypeId;
		this.quizDesc = quizDesc;
	}

	public Quiz(int id, String ques, String ans, Integer quizTypeId, String quizDesc) {
		super();
		this.id = id;
		this.ques = ques;
		this.ans = ans;
		this.quizTypeId = quizTypeId;
		this.quizDesc = quizDesc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQues() {
		return ques;
	}

	public void setQues(String ques) {
		this.ques = ques;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public Integer getQuizTypeId() {
		return quizTypeId;
	}

	public void setQuizTypeId(Integer quizTypeId) {
		this.quizTypeId = quizTypeId;
	}

	public String getQuizTypeName() {
		return quizTypeName;
	}

	public void setQuizTypeName(String quizTypeName) {
		this.quizTypeName = quizTypeName;
	}

	public String getQuizDesc() {
		return quizDesc;
	}

	public void setQuizDesc(String quizDesc) {
		this.quizDesc = quizDesc;
	}

}
