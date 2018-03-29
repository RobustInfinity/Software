package com.mayank.mfg;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MfgServlet
 */
@WebServlet("/manufacturer")
public class MfgController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MfgDAO mfgDAO = new MfgDAO();
		try {
			ArrayList<MfgDTO> mfgList = mfgDAO.view();
			request.setAttribute("mfgList", mfgList);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MfgDTO mfgDTO = new MfgDTO();
		mfgDTO.setCompany_name(request.getParameter("companyName"));
		mfgDTO.setContact_no(request.getParameter("contactNo"));
		mfgDTO.setSupervisor(request.getParameter("supervisor"));
		mfgDTO.setAddress(request.getParameter("address"));
		mfgDTO.setGstin_no(request.getParameter("gstin"));
		MfgDAO  mfgDAO = new MfgDAO();
		
		try {
			
			if(mfgDAO.add(mfgDTO)) {
				ArrayList<MfgDTO> mfgList = mfgDAO.view();
				request.setAttribute("mfgList", mfgList);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}

	} 
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
