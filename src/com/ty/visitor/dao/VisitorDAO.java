package com.ty.visitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.ty.visitor.dto.VisitorDTO;
import com.ty.visitor.util.SingletonConnection;

public class VisitorDAO {

	public int saveVisitor(VisitorDTO dto) {

		Connection con = SingletonConnection.getConnection();
		String sql = "insert into visitor values(?,?,?,?,?,?,?,?)";
		int rowsAffected = 0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, dto.getId());
			preparedStatement.setString(2, dto.getName());
			preparedStatement.setString(3, dto.getEmail());
			preparedStatement.setString(4, dto.getGender());
			preparedStatement.setString(5, dto.getPhone());
			preparedStatement.setInt(6, dto.getAge());
			LocalDate today = dto.getDob();
			String dob = today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			preparedStatement.setString(7, dob);
			today = dto.getVisitedDateTime();
			String visitedDateTime = today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			preparedStatement.setString(8, visitedDateTime);
			rowsAffected = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return rowsAffected;
	}

	public VisitorDTO getVisitorById(int id) {

		Connection con = SingletonConnection.getConnection();
		String sql = "Select * from visitor where id = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet res = preparedStatement.executeQuery();
			if (res.next()) {
				VisitorDTO dto = new VisitorDTO();
				dto.setId(res.getInt(1));
				dto.setName(res.getString(2));
				dto.setEmail(res.getString(3));
				dto.setGender(res.getString(4));
				dto.setPhone(res.getString(5));
				dto.setAge(res.getInt(6));
				LocalDate dob = LocalDate.parse(res.getString(7), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				dto.setDob(dob);
				LocalDate visitedDateTime = LocalDate.parse(res.getString(8),
						DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				dto.setVisitedDateTime(visitedDateTime);
				return dto;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public List<VisitorDTO> getAllVisitor() {

		List<VisitorDTO> visitors = new ArrayList<VisitorDTO>();

		Connection con = SingletonConnection.getConnection();
		String sql = "Select *from visitor";
		try {
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				VisitorDTO dto = new VisitorDTO();
				dto.setId(resultSet.getInt(1));
				dto.setName(resultSet.getString(2));
				dto.setEmail(resultSet.getString(3));
				dto.setGender(resultSet.getString(4));
				dto.setPhone(resultSet.getString(5));
				dto.setAge(resultSet.getInt(6));
				LocalDate dob = LocalDate.parse(resultSet.getString(7), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				dto.setDob(dob);
				LocalDate visitedDateTime = LocalDate.parse(resultSet.getString(8),
						DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				dto.setVisitedDateTime(visitedDateTime);
				visitors.add(dto);
			}
			return visitors;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	public List<VisitorDTO> getVisitorByDate() {

		return null;
	}

	// public

}
