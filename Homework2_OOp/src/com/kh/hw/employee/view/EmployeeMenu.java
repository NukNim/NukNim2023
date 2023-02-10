package com.kh.hw.employee.view;

import java.util.Scanner;

import com.kh.hw.employee.controller.EmployeeController;

public class EmployeeMenu {
	private Scanner sc = new Scanner(System.in);
	private EmployeeController ec = new EmployeeController();
	
	public EmployeeMenu() {
		
		while(true) {
			System.out.println("1. 사원추가");
			System.out.println("2. 사원 수정");
			System.out.println("3. 사원 삭제");
			System.out.println("4. 사원 출력");
			System.out.println("9. 프로그램 종료");
			System.out.println("메뉴 번호를 누르세요 : ");
			int menuNum = sc.nextInt();
			
			if(menuNum == 1) {
				insertEmp();
			}else if(menuNum == 2) {
				updateEmp();
			}else if(menuNum == 3) {
				deleteEmp();
			}else if(menuNum == 4) {
				printEmp();
			}else if(menuNum == 9) {
				System.out.println("프로그램을 종료 합니다.");
				break;
			}else {
				System.out.println("잘못된 번호 입니다. 다시 입력해주세요.");
			}
			
		}
	}
	
	public void insertEmp() {
		
		int empNo;
		char gender;
		String name;
		String phone;
		String dept;
		int salary;
		double bonus;
		String addInfo;
		
		sc.nextLine();
		System.out.print("사원 번호 : ");
		empNo = sc.nextInt(); sc.nextLine();
		System.out.print("사원 이름 : ");
		name = sc.nextLine();
		System.out.print("사원 성별 : ");
		gender = sc.next().charAt(0); sc.nextLine();
		System.out.print("전화 번호 : ");
		phone = sc.nextLine();
		
		System.out.print("추가 정보를 더 입력하시겠습니까?(y/n)");
		addInfo = sc.nextLine();
		
		if(addInfo.toUpperCase().equals("Y")) {
			System.out.println("====추가입력 정보 ====");
			System.out.println("사원 부서 : ");
			dept = sc.nextLine();
			System.out.println("사원 연봉 : ");
			salary = sc.nextInt(); sc.nextLine();
			System.out.println("보너스 율 : ");
			bonus = sc.nextDouble();
			
			ec.add(empNo, name, gender, phone, dept, salary, bonus);
			
		}else if(addInfo.toUpperCase().equals("N")){
			ec.add(empNo, name, gender, phone);
			
		}	
			
		
	}
	
	public void updateEmp() {
		String phone;
		int salary;
		double bonus;
		int menuNum;
		
		System.out.println("가장 최신의 사원 정보를 수정하게 됩니다.");
		System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
		System.out.println("1. 전화번호");
		System.out.println("2. 사원 연봉");
		System.out.println("3. 보너스 율");
		System.out.println("9. 돌아가기");
		System.out.print("메뉴번호를 누르세요 : ");
		menuNum = sc.nextInt(); sc.nextLine();
		
		if(menuNum == 1 ) {
			System.out.println("수정할 전화번호 : ");
			phone = sc.nextLine();
			ec.modify(phone);
		}else if(menuNum ==2) {
			System.out.println("수정할 사원연봉 : ");
			salary = sc.nextInt(); sc.nextLine();
			ec.modify(salary);
		}else if (menuNum ==3) {
			System.out.println("수정할 보너스 율 : ");
			bonus = sc.nextDouble(); sc.nextLine();
			ec.modify(bonus);
		}else if (menuNum == 9) {
			System.out.println("메인 메뉴로 돌아갑니다.");
		}else {
			System.out.println("잘못누르셨습니다.");
		}
		
	}
	
	public void deleteEmp() {
		sc.nextLine();
		String removeflag;
		System.out.println("정말로 삭제할 것입니까?(y/n)");
		removeflag = sc.nextLine();
		if(removeflag.toUpperCase().equals("Y")) {
			ec.remove();
		}
	}
	
	public void printEmp() {
		System.out.println(ec.inform());
	}
	

}
