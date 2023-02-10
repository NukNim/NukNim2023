package com.kh.hw.person.view;

import java.util.Scanner;

import com.kh.hw.person.controller.PersonController;
import com.kh.hw.person.model.vo.Employee;
import com.kh.hw.person.model.vo.Student;

public class PersonMenu {
	
	private Scanner sc = new Scanner(System.in);
	private PersonController pc = new PersonController();
	
	public void mainMenu() {

		while(true) {
			
			int[] pCount = pc.personCount();
			
			System.out.println("학생은 최대 3명 까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 학생은 " +pCount[0]+"명입니다.");
			System.out.println("직원은 최대 10명 까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 직원은 " +pCount[1]+"명입니다.");
			System.out.println();
			System.out.println("1. 학생 메뉴");
			System.out.println("2. 직원 메뉴");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int menuNum = sc.nextInt();
			
			if(menuNum == 1) {
				studentMenu();
			}else if (menuNum == 2) {
				employeeMenu();
			}else if (menuNum == 9) {
				System.out.println("종료합니다.");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			
			
			
		}
		
		
		
		
	}

	private void employeeMenu() {
		while(true) {
			
			int[] pCount = pc.personCount();
			int eCount = pCount[1];
			
			if(eCount<10) {
				System.out.println("1. 사원 추가");
			}else {
				System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가 메뉴는 더이상 활성화 되지 않습니다.");
			}
			System.out.println("2. 사원 보기");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int menuNum = sc.nextInt(); 		sc.nextLine();
			
			
			if(menuNum == 1 && eCount<10) {
				insertEmployee();
			}else if (menuNum == 2) {
				printEmployee();
			}else if (menuNum == 9) {
				System.out.println("메인으로 돌아갑니다.");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			
			
		}
		
	}

	private void studentMenu() {
		
		while(true) {
			
			int[] pCount = pc.personCount();
			int sCount = pCount[0];
			
			if(sCount<3) {
				System.out.println("1. 학생 추가");
			}else {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가 메뉴는 더이상 활성화 되지 않습니다.");
			}
			System.out.println("2. 학생 보기");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int menuNum = sc.nextInt(); 		sc.nextLine();
			
			
			if(menuNum == 1 && sCount<3) {
				insertStudent();
			}else if (menuNum == 2) {
				printStudent();
			}else if (menuNum == 9) {
				System.out.println("메인으로 돌아갑니다.");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			
			
		}
		
	}

	private void printEmployee() {
		Employee[] e = pc.printEmployees();
		
		System.out.println();
		for(Employee pe : e) {
			//System.out.println(pe.getName()+", "+pe.getAge()+", "+pe.getHeight()+", "+pe.getWeight()+", "+pe.getSalary()+", "+pe.getDept());
			//과제의 사원 결과에는 부서와 급여가 나와있지 않음
			System.out.println(pe.getName()+", "+pe.getAge()+", "+pe.getHeight()+", "+pe.getWeight());
		}
		System.out.println();
		
	}

	private void insertEmployee() {
		while(true) {
			
			int[] pCount = pc.personCount();
			
			if(pCount[1] >= 10){
				System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가를 종료하고 사원 메뉴로 돌아갑니다.");
				break;
			}
			
			System.out.println("사원 이름 : ");
			String name = sc.nextLine();
			System.out.println("사원 나이 : ");
			int age = sc.nextInt(); 		
			System.out.println("사원 키 : ");
			double height = sc.nextDouble();		
			System.out.println("사원 몸무게 : ");
			double weight = sc.nextDouble();		
			System.out.println("사원 급여 : ");
			int salary = sc.nextInt(); 		sc.nextLine();
			System.out.println("사원 부서 : ");
			String dept = sc.nextLine();
			
			System.out.println("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			String conFlag = sc.nextLine();
			
			pc.insertEmployee(name, age, height, weight, salary, dept);	
			
			if(conFlag.toUpperCase().equals("N")) {
				break;
			}
		}	
		
	}

	private void printStudent() {
		Student[] s = pc.printStudent();
		
		System.out.println();
		for(Student ps : s) {
			System.out.println(ps.getName()+", "+ps.getAge()+", "+ps.getHeight()+", "+ps.getWeight()+", "+ps.getGrade()+", "+ps.getMajor());
		}
		System.out.println();
	}

	private void insertStudent() {
		
		while(true) {
			
			int[] pCount = pc.personCount();
			
			if(pCount[0] >=3){
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고 학생 메뉴로 돌아갑니다.");
				break;
			}
			
			System.out.println("학생 이름 : ");
			String name = sc.nextLine();
			System.out.println("학생 나이 : ");
			int age = sc.nextInt(); 		
			System.out.println("학생 키 : ");
			double height = sc.nextDouble();		
			System.out.println("학생 몸무게 : ");
			double weight = sc.nextDouble();		
			System.out.println("학생 학년 : ");
			int grade = sc.nextInt(); 		sc.nextLine();
			System.out.println("학생 전공 : ");
			String major = sc.nextLine();
			
			System.out.println("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			String conFlag = sc.nextLine();	
			
			
			pc.insertStudent(name, age, height, weight, grade, major);
			
			if(conFlag.toUpperCase().equals("N")) {
				break;
			}
	
		}
		
	}

}
