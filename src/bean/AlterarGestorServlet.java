package bean;

import java.io.IOException;
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
 * Servlet implementation class AlterarGestorServlet
 */
public class AlterarGestorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlterarGestorServlet() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		Connection con;

		Integer id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		Integer idade = Integer.parseInt(request.getParameter("idade"));
		String endereco = request.getParameter("endereco");
		Integer telefone = Integer.parseInt(request.getParameter("telefone"));

		GestorDTO dto = new GestorDTO();

		try {
			con = Conexao.conect();
			dto.setId(id);
			dto.setNome(nome);
			dto.setIdade(idade);
			dto.setEndereco(endereco);
			dto.setTelefone(telefone);

			GestorDAO dao = new GestorDAO(con);
			dao.alterar(dto);
			//request.setAttribute("Noticia", "Dados atualizados");
			RequestDispatcher rd = request.getRequestDispatcher("listar.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// out.println(e);
		}

	}

}
