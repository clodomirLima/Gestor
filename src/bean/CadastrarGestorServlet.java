package bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Conexao;
import DAO.GestorDAO;
import DTO.GestorDTO;

/**
 * Servlet implementation class CadastrarGestorServlet
 */
public class CadastrarGestorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarGestorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
		
            String nome = request.getParameter("nome");
            Integer idade =  Integer.parseInt(request.getParameter("idade"));
            String endereco = request.getParameter("endereco");
            Integer telefone =  Integer.parseInt(request.getParameter("telefone"));
            
            Connection con;
            
            try {
                con = Conexao.conect();
                
                GestorDTO dto = new GestorDTO();
                dto.setNome(nome);
                dto.setIdade(idade);
                dto.setEndereco(endereco);
                dto.setTelefone(telefone);
                
                GestorDAO dao = new GestorDAO(con);
                dao.cadastrarGestor(dto);
                
                //request.setAttribute("usuario",dto.getUsuario());
                request.getRequestDispatcher("listar.jsp").forward(request, response);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        }
	}

}
