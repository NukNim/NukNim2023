package com.kh.practice.snack.view;

import java.util.Scanner;

import com.kh.practice.snack.controller.SnackController;

public class SnackMenu {
	private Scanner sc = new Scanner(System.in);
	private SnackController scr = new SnackController();
	
	public void menu() {
		
		String kind;
		String name;
		String flavor;
		int numOf;
		int price;
		String checkFlag;
		
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : ");
		kind = sc.nextLine();
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("맛 : ");
		flavor = sc.nextLine();
		System.out.print("개수 : ");
		numOf = sc.nextInt();
		System.out.print("가격 : ");
		price = sc.nextInt(); sc.nextLine();
		
		String succMessage = scr.saveData(kind,name,flavor,numOf,price);
		
		System.out.println(succMessage);
		System.out.print("저장한 정보를 확인하시겠습니까?(y/n)");
		checkFlag = sc.nextLine();
		if(checkFlag.toUpperCase().equals("Y")) {
			System.out.println( scr.confirmData());
		}
		
		
	}

}
