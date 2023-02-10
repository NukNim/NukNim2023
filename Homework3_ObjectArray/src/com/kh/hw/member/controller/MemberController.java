package com.kh.hw.member.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.kh.hw.member.model.vo.Member;

public class MemberController {
	
	private Member[] m = new Member[10];
	public int size = 0; 
	
	public int existMemberNum() {
		
		return m.length - size ;
		
	}
	
	//true 면 중복
	public boolean checkId(String inputId) {
		
		if(size == 0) {
			return false;
		}else if(size>0) {
			for(Member l : m) {
				if(l.getId().equals(inputId)) {
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}
	
	public void insertMember(String id,String name, String password, String email, char gender, int age) {
		
		if(size<10) {
			m[size] = new Member();
			m[size].setId(id);
			m[size].setName(name);
			m[size].setPassword(password);
			m[size].setEmail(email);
			m[size].setGender(gender);
			m[size].setAge(age);

			size++;
		}
		
	}
	
	public String searchId(String id) {
		
		for(int i =0;i<size;i++) {
			if(m[i].getId().equals(id)) {
				return "찾으신 회원 조회 결과입니다.\r\n" + m[i].getId()+" "+m[i].getName()+" "+m[i].getPassword()+" "+m[i].getEmail()+" "+m[i].getGender()+" "+m[i].getAge();
			} 
		}
		return "검색 결과가 없습니다.";
	}
	
	public Member[] searchName(String name) {
		
		Member[] list = new Member[size];
		int count = 0;
		
		for(int i =0;i<size;i++) {
			if(m[i].getName().equals(name)) {
				list[count] = new Member();
				list[count].setId(m[i].getId());
				list[count].setName(m[i].getName());
				list[count].setPassword(m[i].getPassword());
				list[count].setEmail(m[i].getEmail());
				list[count].setGender(m[i].getGender());
				list[count].setAge(m[i].getAge());
				count++;
			}
		}
		if(count == 0) {
			return list = new Member[0];
		}else {
			return list;
		}
		
	}
	
	public Member[] searchEmail(String email) {
		Member[] list = new Member[size];
		int count = 0;
		for(int i =0;i<size;i++) {
			if(m[i].getEmail().equals(email)) {
				list[count] = new Member();
				list[count].setId(m[i].getId());
				list[count].setName(m[i].getName());
				list[count].setPassword(m[i].getPassword());
				list[count].setEmail(m[i].getEmail());
				list[count].setGender(m[i].getGender());
				list[count].setAge(m[i].getAge());
				count++;
			}
			
		}
		if(count == 0) {
			return list = new Member[0];
		}else {
			return list;
		}
	}
	
	public boolean updatePassword(String id, String password) {
		
		for(int i =0;i<size;i++) {
			if(m[i].getId().equals(id)) {
				m[i].setPassword(password);
				return true;
			}
		}
		return false;
	}
	
	public boolean updateName(String id, String name) {
		for(int i =0;i<size;i++) {
			if(m[i].getId().equals(id)) {
				m[i].setPassword(name);
				return true;
			}
		}
		return false;
	
	}
	
	public boolean updateEmail(String id, String email) {
		for(int i =0;i<size;i++) {
			if(m[i].getId().equals(id)) {
				m[i].setPassword(email);
				return true;
			} 
		}
		return false;
	}
	
	public boolean delete(String id) {
		
		for(int i =0;i<size;i++) {
			System.out.println("============" + m[i].getId().equals(id));
			if(m[i].getId().equals(id)) {
				List<Member> mList = new ArrayList<>(Arrays.asList(m));
				mList.remove(i);
				System.out.println(mList.toString());
				m = mList.toArray(new Member[size-1]);
				size = size -1;
				return true;
			} 
		}
		return false;
	}
	
	public void delete() {
		m = new Member[10];
		size = 0;
	}
	
	public Member[] printAll(){
		
		Member[] list = new Member[size];
		
		for(int i = 0 ;i<size;i++) {
			list[i] = new Member();
			list[i].setId(m[i].getId());
			list[i].setName(m[i].getName());
			list[i].setPassword(m[i].getPassword());
			list[i].setEmail(m[i].getEmail());
			list[i].setGender(m[i].getGender());
			list[i].setAge(m[i].getAge());
		}
		
		return list;
	}
	
}
