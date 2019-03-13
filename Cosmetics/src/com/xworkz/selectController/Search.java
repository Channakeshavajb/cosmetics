package com.xworkz.selectController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xworkz.hibernate.dao.CosmeticsDAO;
import com.xworkz.hibernate.dto.CosmeticsDTO;
import com.xworkz.hibernate.util.HibernateUtil;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brand =request.getParameter("selects");
		CosmeticsDTO dto = new CosmeticsDTO();
		dto.setBrand(brand);
		CosmeticsDAO dao = new CosmeticsDAO();
		 List<CosmeticsDTO> dtoa=( List<CosmeticsDTO>) dao.getBySearch(brand);
		 System.out.println("simple.......");
		 response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		 pw.println("<HTML><HEAD><TITLE>Personnel Details</TITLE></HEAD><BODY>");
	
		 ServletContext cc= getServletContext();
		 cc.getRequestDispatcher("/Search.html").forward(request, response);
		 HibernateUtil.getFactory().close();
	}
	

}
