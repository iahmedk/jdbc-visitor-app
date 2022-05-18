package com.ty.visitor.controller;

import java.util.List;

import com.ty.visitor.dto.VisitorDTO;
import com.ty.visitor.service.VisitorService;

public class ListAllVisitors {

	public static void main(String[] args) {

		VisitorService service = new VisitorService();
		List<VisitorDTO> list = service.getAllVisitors();

		for (VisitorDTO dto : list) {
			System.out.println(dto);
		}
	}

}
