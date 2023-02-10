package com.kh.hw.employee.controller;

import com.kh.hw.employee.model.vo.Employee;

public class EmployeeController {
	
	private Employee e = new Employee();
	
	public void add(int empNo,String name,char gender,String phone) {
		e.setEmpNo(empNo);
		e.setName(name);
		e.setGender(gender);
		e.setPhone(phone);
		
	}
	
	public void add(int empNo,String name,char gender,String phone,String dept,int salary,double bonus) {
		e.setEmpNo(empNo);
		e.setName(name);
		e.setGender(gender);
		e.setPhone(phone);
		e.setDept(dept);
		e.setSalary(salary);
		e.setBonus(bonus);
		
		
	}
	
	public void modify(String phone) {
		e.setPhone(phone);
	}
	
	public void modify(int salary) {
		e.setSalary(salary);
	}
	
	public void modify(double bonus) {
		e.setBonus(bonus);
	}
	
	public Employee remove() {
		if(e != null) {
			e = null;
			System.out.println("삭제에 성공했습니다.");
		}else {
			System.out.println("삭제에 실패했습니다.");
		}
		return e;
	}
	
	public String inform() {
		if(e != null) {
			return "사원 정보 : " + e.printEmployee();
		}else {
			return "사원 정보가 없습니다.";
		}
	}

}
