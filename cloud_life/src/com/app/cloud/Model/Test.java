package com.app.cloud.Model;

/**
 * ���ʲ��� ģ��
 *
 */
public class Test {

	// ����
	private String question;
	// �÷�
	private int score = 0;

	public Test(String text) {
		this.question = text;
	}

	public void setQuestion(String test) {
		this.question = test;
	}

	public String getQuestion() {
		return question;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

}
