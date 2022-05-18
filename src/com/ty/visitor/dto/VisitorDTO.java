package com.ty.visitor.dto;

import java.time.LocalDate;

public class VisitorDTO {

	private int id;
	private String name;
	private String email;
	private String gender;
	private String phone;
	private int age;
	private LocalDate dob;
	private LocalDate visitedDateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getVisitedDateTime() {
		return visitedDateTime;
	}

	public void setVisitedDateTime(LocalDate visitedDateTime) {
		this.visitedDateTime = visitedDateTime;
	}

	@Override
	public String toString() {
		return id+"\t"+name+"\t"+email+"\t"+gender+"\t"+phone+"\t"+age+"\t"+dob+"\t"+visitedDateTime;
	}
}
