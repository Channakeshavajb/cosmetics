package com.xworkz.hibernateController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xworkz.hibernate.dao.CosmeticsDAO;
import com.xworkz.hibernate.dto.CosmeticsDTO;

/**
 * Servlet implementation class SuccessServlet
 */
@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuccessServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String brand = request.getParameter("brand");
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String mfdDate = request.getParameter("mfd_date");
		String expDate = request.getParameter("exp_date");

		CosmeticsDTO dto = new CosmeticsDTO();
		dto.setBrand(brand);
		dto.setPrice(price);
		dto.setQuantity(quantity);
		dto.setMfd_date(mfdDate);
		dto.setExp_date(expDate);

		CosmeticsDAO dao = new CosmeticsDAO();
		boolean b = dao.save(dto);

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		if (b == true) {
			pw.println("<html><body>" + "<center>" + "data added successfully" + "</center>" + "</body></html>");
		} else {
			pw.println("<html><body>" + "<center>" + "data added not  successfully" + "</center>" + "</body></html>");
		}

	}

}
