package com.ty.visitor.controller;

import java.time.LocalDate;

import com.ty.visitor.dto.VisitorDTO;
import com.ty.visitor.service.VisitorService;

public class SaveVisitor {

	public static void main(String[] args) {

		VisitorDTO dto = new VisitorDTO();
		dto.setId(60);
		dto.setName("Umesh");
		dto.setEmail("umesh123@gmail.com");
		dto.setGender("male");
		dto.setPhone("9980354363");
		dto.setAge(35);
		dto.setDob(LocalDate.now());
		dto.setVisitedDateTime(LocalDate.now());

		VisitorService service = new VisitorService();
		service.saveVisitor(dto);

		if (service.saveVisitor(dto) > 0) {
			System.out.println("Visitor Saved !!");
		} else {
			System.out.println("Visitor not saved !!");
		}
	}

}
