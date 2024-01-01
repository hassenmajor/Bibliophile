
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import projet.liu.dao.LivreDao;
import projet.liu.metier.Livre;

import java.io.IOException;
import java.sql.*;

/**
 * Servlet implementation class MyServlet
 */
public class LivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LivreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		response.getWriter().append("Served at: ").append(request.getRequestURI());
		this.getServletContext().getRequestDispatcher("/livre.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		LivreDao dao = new LivreDao();
		String ancienTitre = request.getParameter("ancienTitre");
		if (ancienTitre!=null) {
			Livre nouveauLivre = new Livre(request.getParameter("titre"), 
					request.getParameter("soustitre"), 
					Integer.parseInt(request.getParameter("annee")), 
					request.getParameter("image"), 
					request.getParameter("lien"));
			if (dao.get(ancienTitre)!=null)
				dao.update(request.getParameter("ancienTitre"), nouveauLivre);
			else
				dao.save(nouveauLivre);
		}
		this.getServletContext().getRequestDispatcher("/livre.jsp").forward(request, response);
	}

}
