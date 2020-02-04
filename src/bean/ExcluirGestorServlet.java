package bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Conexao;
import DAO.GestorDAO;
import DTO.GestorDTO;

/**
 * Servlet implementation class ExcluirGestorServlet
 */
public class ExcluirGestorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExcluirGestorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		try (PrintWriter out = response.getWriter()) {
			/* TODO output your page here. You may use following sample code. */
			String id = request.getParameter("id");

			Connection con;

			GestorDTO dto = new GestorDTO();// criando o objeto Noticia
			dto.setId(Integer.valueOf(id));

			try {
				con = Conexao.conect();
				GestorDAO dao = new GestorDAO(con);
				dao.deletar(dto);
				RequestDispatcher rd = request.getRequestDispatcher("listar.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				out.println(
						" " + e.getMessage());
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
