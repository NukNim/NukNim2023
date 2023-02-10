package com.kh.hw.shape.model.vo;

public class Shape {
	
	private int type;
	private double height;
	private double width;
	private String color = "white";
	
	//기본 생성자
	public Shape(){
		
	}
	//매개변수가 있는 생성자
	public Shape(int type, double height,double width){
		
	}
	//높이 너비 색깔을 반환하는 메서드
	public String information() {
		return "[height=" + height + ", width=" + width + ", color=" + color + "]";
	}
	
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	

}
