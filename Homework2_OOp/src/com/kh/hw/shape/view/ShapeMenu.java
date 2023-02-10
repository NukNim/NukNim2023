package com.kh.hw.shape.view;

import java.util.Scanner;

import com.kh.hw.shape.controller.SquareController;
import com.kh.hw.shape.controller.TriangleController;

public class ShapeMenu {

	private Scanner sc = new Scanner(System.in);
	private SquareController scr = new SquareController();
	private TriangleController tc = new TriangleController();

	//시작메뉴
	public void inputMenu() {
		
		while (true) {
			System.out.println("==== 도형 프로그램 ====");
			System.out.println("3. 삼각형");
			System.out.println("4. 사각형");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
			
			int type = sc.nextInt();
			
			if(type == 3) {
				triangleMenu();
				break;
			}else if(type ==4) {
				squareMenu();
				break;
			}else if(type == 9) {
				System.out.println("프로그램 종료");
				break;
			}else {
				System.out.println("잘못된 번호 입니다. 다시 입력해주세요.");
			}
			
			
		}
		
	}
	
	//삼각형 메뉴
	public void triangleMenu() {
		
		while (true) {
			System.out.println("==== 삼각형 ====");
			System.out.println("1. 삼각형 면적");
			System.out.println("2. 삼각형 색칠");
			System.out.println("3. 삼각형 정보");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			
			int menuNum = sc.nextInt();
			int type = 3;
			
			if(menuNum == 1) {
				inputSize(type, menuNum);
				break;
			}else if(menuNum == 2) {
				inputSize(type, menuNum);
				break;
			}else if(menuNum == 3) {
				printInformation(type);
				break;
			}else if(menuNum == 9) {
				System.out.println("메인으로 돌아갑니다.");
				inputMenu();
				break;
			}else {
				System.out.println("잘못된 번호 입니다. 다시 입력해주세요.");
			}
			
			
		}
		
	}
	
	//사각형 메뉴
	public void squareMenu() {
		
		while (true) {
			System.out.println("==== 삼각형 ====");
			System.out.println("1. 사각형 둘레");
			System.out.println("2. 사각형 넓이");
			System.out.println("3. 사각형 색칠");
			System.out.println("4. 사각형 정보");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			
			int menuNum = sc.nextInt();
			int type = 4;
			
			if(menuNum == 1) {
				inputSize(type, menuNum);
				break;
			}else if(menuNum == 2) {
				inputSize(type, menuNum);
				break;
			}else if(menuNum == 3) {
				inputSize(type, menuNum);
				break;
			}else if(menuNum == 4) {
				printInformation(type);
				break;
			}else if(menuNum == 9) {
				System.out.println("메인으로 돌아갑니다.");
				inputMenu();
				break;
			}else {
				System.out.println("잘못된 번호 입니다. 다시 입력해주세요.");
			}
			
			
		}
		
	}
	
	//도형관련 요청 사항 처리 
	public void inputSize(int type, int menuNum) {
		
		//삼각형 일때
		if(type ==3) {
			//면적구하기 일때
			if(menuNum == 1) {
				System.out.println("높이 : ");
				double height = sc.nextInt();
				System.out.println("너비 : ");
				double width = sc.nextInt();
				tc.calcArea(height, width);
				System.out.println(tc.calcArea(height, width) + "삼각형 넓이");
				triangleMenu();
			}else if(menuNum == 2) {
				//색 설정
				System.out.println("색깔을 입력하세요 : ");
				//nextint 입력후 자동 개행 방지
				sc.nextLine();
				String color = sc.nextLine();
				tc.paintColor(color);
				System.out.println("색이 수정되었습니다.");
				triangleMenu();
			}
		}else if(type == 4) {
			if(menuNum == 1){
				System.out.print("높이 : ");
				double height = sc.nextInt();
				System.out.print("너비 : ");
				double width = sc.nextInt();
				System.out.println(scr.calcPerimeter(height, width) + " 사각형 둘레"); 
				squareMenu();
			}else if(menuNum == 2){
				System.out.print("높이 : ");
				double height = sc.nextInt();
				System.out.print("너비 : ");
				double width = sc.nextInt();
				scr.calcArea(height, width);
				System.out.println(scr.calcArea(height, width) + "사각형 넓이");
				squareMenu();
			}else if(menuNum == 3) {
				//색 설정
				System.out.print("색깔을 입력하세요 : ");
				//nextint 입력후 자동 개행 방지
				sc.nextLine();
				String color = sc.nextLine();
				scr.paintColor(color);
				System.out.println("색이 수정되었습니다.");
				squareMenu();
			}
			
		}
	}
	
	//도형 종류 출력
	public void printInformation(int type) {
		if(type == 3) {
			System.out.println(tc.print()); 
			triangleMenu();
		}else if(type == 4) {
			 System.out.println(scr.print());
			 squareMenu();
		}
	}
	
}
