package com.synopsys.reachability;

/*
 * the source and sink are within the same function.
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author aphadke
 * Servlet implementation class SameFunction
 */
@WebServlet("/SameFunction")
public class SameFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramValue = request.getParameter("evilParam");

		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://local/", "userName", "password");

			Statement st = conn.createStatement();

			ResultSet res = st.executeQuery("SELECT * FROM  User where userId='" + paramValue + "'");

			res.close();
			
		} catch (Exception e) {
			// TODO do nothing
		}

	}


}
