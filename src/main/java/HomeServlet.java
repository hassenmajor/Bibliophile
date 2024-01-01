
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import projet.liu.dao.*;
import projet.liu.metier.*;

import java.io.IOException;
import java.sql.*;
import java.util.Iterator;

/**
 * Servlet implementation class MyServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LivreDao dao = new LivreDao();
		if (request.getParameter("ancienTitre")!=null) {
			dao.delete(request.getParameter("ancienTitre"));
		}
		if (request.getParameter("reset")!=null) {
			for (Livre livre : Something.ORIGINAL_BOOKS)
				dao.save(livre);
		}
//		response.getWriter().append("Served at: ").append(request.getRequestURI());
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
