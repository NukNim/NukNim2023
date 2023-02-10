package com.kh.practice.student.view;

import com.kh.practice.student.controller.StudentController;
import com.kh.practice.student.model.vo.Student;

public class StudentMenu {
	
	private StudentController ssm = new StudentController();
	
	public StudentMenu() {
			Student[] sArr = ssm.printStudent();
			double[] avg= ssm.avgScore();
			
			System.out.println("========= 학생 정보 출력 =========");

			for(Student s : sArr){
				System.out.println("이름 : " + s.getName()+" / 과목 : "+s.getSubject()+" / 점수 : "+s.getScore());
			}
				
			System.out.println("========= 학생 성적 출력 =========");
			
			System.out.println("학생 점수 합계 : "+ ((int)avg[0]));
			System.out.println("학생 점수 평균 : "+avg[1]);
			
			System.out.println("========= 성적 정보 출력 =========");
			
			for(Student s : sArr){
				if(s.getScore() >= ssm.CUT_LINE) {
					System.out.println(s.getName()+"학생은 통과입니다.");
				}else {
					System.out.println(s.getName()+"학생은 재시험 대상입니다.");
				}
			}
			
	}

}
