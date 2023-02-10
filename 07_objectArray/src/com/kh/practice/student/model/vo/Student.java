package com.kh.practice.student.model.vo;

public class Student {
	
	private String name;
	private String subject;
	private int score;
	
	//기본 생성자
	public Student() {
	
	}
	
	//매개변수를 가진 생성자
	public Student(String name, String subject, int score) {
		
	}

	//Getter, Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	//모든 필드 값 스트링으로 반환
	public String inform() {
		return "Student [name=" + name + ", subject=" + subject + ", score=" + score + "]";
	}
	
	
	
	

}
