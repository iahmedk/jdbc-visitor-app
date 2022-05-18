package com.ty.visitor.controller;

import com.ty.visitor.dto.VisitorDTO;
import com.ty.visitor.service.VisitorService;

public class GetVisitorById {

	public static void main(String[] args) {
		
		VisitorService service = new VisitorService();
		VisitorDTO dto = service.getVisitorById(10);
		
		if(dto != null) {
			System.out.println(dto);
		}
		else {
			System.out.println("Visitor is not found");
		}
	}
}
