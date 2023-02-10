package com.kh.hw.person.controller;

import com.kh.hw.person.model.vo.Employee;
import com.kh.hw.person.model.vo.Student;

public class PersonController {
	
	private Student[] s = new Student[3];
	private Employee[] e =new Employee[10];
	public int sSize = 0;
	public int eSize = 0;
	
	public int[] personCount() { 
		
		int[] pCount = new int[2];
		pCount[0] = sSize;
		pCount[1] = eSize;
		return pCount;
	}
	
	public void insertStudent(String name, int age, double height, double weight, int grade, String major) {
		
		if(sSize<3) {
			
			s[sSize] = new Student();
			
			s[sSize].setName(name);
			s[sSize].setAge(age);
			s[sSize].setHeight(height);
			s[sSize].setWeight(weight);
			s[sSize].setGrade(grade);
			s[sSize].setMajor(major);
			
			sSize++;
			
			
		}
		
	}
	
	public Student[] printStudent() {
		
		Student[] list = new Student[sSize];
		
		for(int i = 0 ;i<sSize;i++) {
			list[i] = new Student();
			list[i].setName(s[i].getName());
			list[i].setAge(s[i].getAge());
			list[i].setHeight(s[i].getHeight());
			list[i].setWeight(s[i].getWeight());
			list[i].setGrade(s[i].getGrade());
			list[i].setMajor(s[i].getMajor());
			
		}
		
		return list;
	}
	
	public void insertEmployee(String name, int age, double height, double weight, int salary, String dept) {
		if(eSize<10) {
			
			e[eSize] = new Employee();
			
			e[eSize].setName(name);
			e[eSize].setAge(age);
			e[eSize].setHeight(height);
			e[eSize].setWeight(weight);
			e[eSize].setSalary(salary);
			e[eSize].setDept(dept);
			
			eSize++;
			
			
		}
		
	}
	
	public Employee[] printEmployees() {
		Employee[] list = new Employee[eSize];
		
		for(int i = 0 ;i<eSize;i++) {
			list[i] = new Employee();
			list[i].setName(e[i].getName());
			list[i].setAge(e[i].getAge());
			list[i].setHeight(e[i].getHeight());
			list[i].setWeight(e[i].getWeight());
			list[i].setSalary(e[i].getSalary());
			list[i].setDept(e[i].getDept());
			
		}
		
		return list;
	}

	

}
