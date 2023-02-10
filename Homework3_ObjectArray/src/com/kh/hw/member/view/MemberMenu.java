package com.kh.hw.member.view;

import java.util.Scanner;

import com.kh.hw.member.controller.MemberController;
import com.kh.hw.member.model.vo.Member;

public class MemberMenu {
	
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();

	
	public MemberMenu() {
	
	}
	
	public void mainMenu() {
		
		int existNum = mc.existMemberNum();
		int menuNum;
		
		 
			while(true) {
				
				System.out.println("최대 등록 가능한 회원 수는 "+existNum+"명입니다.");
				System.out.println("현재 등록 가능한 회원 수는 "+(existNum - mc.size)+"명입니다.");
				System.out.println("현재 등록한 회원 수는 "+(mc.size)+"명입니다.");
				
				if(existNum !=0) {
					System.out.println("1.새 회원 등록");
				}else {
					System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
				}
					System.out.println("2.회원 검색");
					System.out.println("3.회원 정보 수정");
					System.out.println("4.회원 삭제");
					System.out.println("5.모두 출력");
					System.out.println("9.끝내기");
					System.out.print("메뉴 번호 : ");
					menuNum = sc.nextInt(); 
					
					
				if(menuNum ==1) {
					insertMember();
				}else if(menuNum == 2) {
					searchMember();
				}else if(menuNum == 3) {
					updateMember();
				}else if(menuNum == 4) {
					deleteMember();
				}else if(menuNum == 5) {
					printAll();
				}else if(menuNum == 9) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}else {
					System.out.println("잘못된 번호를 입력 하셨습니다.");
				}
				
		}
		
	}
	
	public void insertMember() {
		int existNum = mc.existMemberNum();
		
			if(existNum !=0) {
				String id = "";
				String name;
				String password;
				String email;
				char gender = 0;
				int age;
				boolean idLoop = true;
				boolean genderLoop = true;
			
				sc.nextLine();
				
				while(idLoop) {
					System.out.print("아이디 : ");
					id = sc.nextLine();
					
					boolean checkIdFlag = mc.checkId(id);
					
					if(checkIdFlag == true ) {
						System.out.println("중복된 아이디 입니다. 다시 입력해 주세요.");
					}else {
						idLoop = false;
					}
				}
				
				System.out.print("이름 : ");
				name = sc.nextLine();
				System.out.print("비밀번호 : ");
				password = sc.nextLine();
				System.out.print("이메일 : ");
				email = sc.nextLine();
				
				while(genderLoop) {
					System.out.print("성별(M/F) : ");
					String genderFlag = sc.next().toUpperCase();
					
					if(genderFlag.equals("M") || genderFlag.equals("F")) {
						gender = genderFlag.charAt(0);
						genderLoop = false;
					}else {
						System.out.println("성별을 다시 입력하세요");
					}
				}
				
				System.out.print("나이 : ");
				age = sc.nextInt(); sc.nextLine();
				
				mc.insertMember(id, name, password, email, gender, age);
				
				
			}else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
				
	}
	
	public void searchMember() {
		
		System.out.println("1. 아이디로 검색하기 ");
		System.out.println("2. 이름으로 검색하기 ");
		System.out.println("3. 이메일로 검색하기 ");
		System.out.println("9. 메인으로 돌아가기 ");
		System.out.print("번호를입력하세요 : ");
		
		int searchNum = sc.nextInt();
		
		if(searchNum ==1) {
			searchId();
		}else if(searchNum ==2) {
			searchName();
		}else if(searchNum ==3) {
			searchEmail();
		}else if(searchNum ==9) {
			System.out.println("메인으로 돌아갑니다.");
		}else {
			System.out.println("잘못 입력 하셨습니다.");
		}
		
	}
	
	public void searchId() {
		sc.nextLine();
		System.out.print("검색할 아이디 :");
		String id = sc.nextLine();
		
		String message = mc.searchId(id);
		
		System.out.println(message);
		
		
	}
	
	public void searchName() {
		sc.nextLine();
		System.out.print("검색할 이름 : ");
		String name = sc.nextLine();
		
		Member[] list = mc.searchName(name);
		if(list.length>0) {
			System.out.println("찾으시는 회원 조회 결과입니다.");
			for(Member l : list) {
				System.out.println(l.getId()+" "+l.getName()+" "+l.getPassword()+" "+l.getEmail()+" "+l.getGender()+" "+l.getAge());
			}			
		}else {
			System.out.println("검색 결과가 없습니다.");
		}
		
	}
	
	public void searchEmail() {
		sc.nextLine();
		System.out.println("검색할 이메일 : ");
		String email = sc.nextLine();
		
		Member[] list = mc.searchName(email);
		if(list.length>0) {
			System.out.println("찾으시는 회원 조회 결과입니다.");
			for(Member l : list) {
				System.out.println(l.getId()+" "+l.getName()+" "+l.getPassword()+" "+l.getEmail()+" "+l.getGender()+" "+l.getAge());
			}			
		}else {
			System.out.println("검색 결과가 없습니다.");
		}

	}
	
	public void updateMember() {
		
		System.out.println("1. 비밀번호 수정하기 ");
		System.out.println("2. 이름 수정하기 ");
		System.out.println("3. 이메일 수정하기 ");
		System.out.println("9. 메인으로 돌아가기 ");
		System.out.print("번호를입력하세요 : ");
		
		int searchNum = sc.nextInt();
		
		if(searchNum ==1) {
			updatePassword();
		}else if(searchNum ==2) {
			updateName();
		}else if(searchNum ==3) {
			updateEmail();
		}else if(searchNum ==9) {
			System.out.println("메인으로 돌아갑니다.");
		}else {
			System.out.println("잘못 입력 하셨습니다.");
		}
		
	}
	
	public void updatePassword() {
		sc.nextLine();
		System.out.print("수정할 회원의 아이디 : ");
		String upId = sc.nextLine();
		System.out.print("수정할 회원의 비밀번호 : ");
		String upPw = sc.nextLine();
		
		boolean succ =  mc.updatePassword(upId, upPw);
		
		if(succ) {
			System.out.println("수정이 성공적으로 되었습니다.");
		}else {
			System.out.println("존재하지 않는 아이디 입니다.");
		}
		
	}
	
	public void updateName() {
		sc.nextLine();
		System.out.print("수정할 회원의 아이디 : ");
		String upId = sc.nextLine();
		System.out.print("수정할 회원의 이름 : ");
		String upNm = sc.nextLine();
		
		boolean succ =  mc.updateName(upId, upNm);
		
		if(succ) {
			System.out.println("수정이 성공적으로 되었습니다.");
		}else {
			System.out.println("존재하지 않는 아이디 입니다.");
		}
	
		
	}
	
	public void updateEmail() {
		sc.nextLine();
		System.out.print("수정할 회원의 아이디 : ");
		String upId = sc.nextLine();
		System.out.print("수정할 회원의 이메일 : ");
		String upEm = sc.nextLine();
		
		boolean succ =  mc.updateName(upId, upEm);
		
		if(succ) {
			System.out.println("수정이 성공적으로 되었습니다.");
		}else {
			System.out.println("존재하지 않는 아이디 입니다.");
		}
		
	}
	
	public void deleteMember() {
		System.out.println("1. 특정 회원 삭제하기 ");
		System.out.println("2. 모든 회원 삭제하기 ");
		System.out.println("9. 메인으로 돌아가기 ");
		System.out.print("번호를입력하세요 : ");
		
		int searchNum = sc.nextInt();
		
		if(searchNum ==1) {
			deleteOne();
		}else if(searchNum ==2) {
			deleteAll();
		}else if(searchNum ==9) {
			System.out.println("메인으로 돌아갑니다.");
		}else {
			System.out.println("잘못 입력 하셨습니다.");
		}
		
	}
	
	public void deleteOne() {
		sc.nextLine();
		System.out.print("삭제할 회원 아이디 : ");
		String id = sc.nextLine();
		System.out.print("정말로 삭제 하실 겁니까?(Y/N)");
		String delFalg = sc.nextLine();
		
		if(delFalg.toUpperCase().equals("Y")) {
			boolean delSucc= mc.delete(id);
			if(delSucc) {
				System.out.println("성공적으로 삭제하였습니다.");
			}else {
				System.out.println("존재하지 않는 아이디 입니다.");
			}
		}
	}
	
	public void deleteAll() {
		
		sc.nextLine();
		System.out.print("정말로 삭제 하실 겁니까?(Y/N)");
		String delFalg = sc.nextLine();
		if(delFalg.toUpperCase().equals("Y")) {
			mc.delete();
			System.out.println("성공적으로 삭제 하였습니다.");
		}
		
	}
	
	public void printAll() {
		Member[] list = mc.printAll();
		
		if(list.length>0) {
			for(Member l : list) {
				System.out.println(l.getId()+" "+l.getName()+" "+l.getPassword()+" "+l.getEmail()+" "+l.getGender()+" "+l.getAge());
			}			
		}else {
			System.out.println("저장된 회원이 없습니다.");
		}
	}
}

