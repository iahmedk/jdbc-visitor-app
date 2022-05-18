package com.ty.visitor.service;

import static com.ty.visitor.util.ApplicationConstants.SECRETE_KEY;

import java.util.List;

import com.ty.visitor.dao.VisitorDAO;
import com.ty.visitor.dto.VisitorDTO;
import com.ty.visitor.util.AES;

public class VisitorService {

	public int saveVisitor(VisitorDTO dto) {

		String encName = AES.encrypt(dto.getName(), SECRETE_KEY);
		String encEmail = AES.encrypt(dto.getEmail(), SECRETE_KEY);
		String encPhone = AES.encrypt(dto.getPhone() + "", SECRETE_KEY);

		dto.setName(encName);
		dto.setEmail(encEmail);
		dto.setPhone(encPhone);

		VisitorDAO dao = new VisitorDAO();
		return dao.saveVisitor(dto);
	}

	public VisitorDTO getVisitorById(int id) {

		VisitorDAO dao = new VisitorDAO();
		VisitorDTO dto = dao.getVisitorById(id);

		if (dto != null) {
			dto.setName(AES.decrypt(dto.getName(), SECRETE_KEY));
			dto.setEmail(AES.decrypt(dto.getEmail(), SECRETE_KEY));
			dto.setPhone(AES.decrypt(dto.getPhone(), SECRETE_KEY));
			return dto;
		} else {
			return null;
		}

	}
	
	public List<VisitorDTO> getAllVisitors(){
		return new VisitorDAO().getAllVisitor();
	}
}
