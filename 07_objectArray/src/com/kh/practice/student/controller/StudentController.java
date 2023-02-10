package com.kh.practice.student.controller;

import com.kh.practice.student.model.vo.Student;

public class StudentController {
	
	private Student[] sArr = new Student[5];
	//문서에 밑줄 있으면 static readonly는 final
	public static int CUT_LINE = 60;
	
	//기본 생성자
	public StudentController() {
		
		//샘플 데이터 입력을 위해 student 객체 생성 
		for(int i =0 ; i<sArr.length;i++) {
			sArr[i] = new Student();
		}
		
		//김길동 자바 100
		sArr[0].setName("김길동");
		sArr[0].setSubject("자바");
		sArr[0].setScore(100);
		//박길동 디비 50
		sArr[1].setName("박길동");
		sArr[1].setSubject("디비");
		sArr[1].setScore(50);
		//이길동 화면 85
		sArr[2].setName("이길동");
		sArr[2].setSubject("화면");
		sArr[2].setScore(85);
		//정길동 서버 60
		sArr[3].setName("정길동");
		sArr[3].setSubject("서버");
		sArr[3].setScore(60);
		//홍길동 자바 100
		sArr[4].setName("홍길동");
		sArr[4].setSubject("자바");
		sArr[4].setScore(20);
		
	}
	
	//객체 배열 반환
	public Student[] printStudent() {
		
		return sArr;
	}
	
	//객체 배열 점수 합 반환
	public int sumScore() {
		int sum = 0;
		for(Student s : sArr) {
			sum += s.getScore();
		}
		
		return sum;
	}
	
	public double[] avgScore() {
		int sum = sumScore();
		double[] avg = {sum, sum/sArr.length};
		
		return avg;
	}
	
	
	
}
