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
 * Servlet implementation class BuscarIdServlet
 */
public class BuscarIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
int id = Integer.parseInt(request.getParameter("id"));
        
        GestorDTO dto = new GestorDTO();

        Connection con;
        
       try {
            con = Conexao.conect();
              GestorDAO dao = new GestorDAO(con);
              
              dto = dao.pesquisar(id);

              RequestDispatcher rd = 
               request.getRequestDispatcher("alterar.jsp");
               rd.forward(request, response);}
          catch(Exception e){

                  }
   	String msg = "";
           
	if (dto == null) {

		msg = "Não foram encontrados registros.";

		request.setAttribute("msgResposta", msg);

		RequestDispatcher enviar = request
				.getRequestDispatcher("lista.jsp");
		enviar.forward(request, response);

	} else {
		request.setAttribute("id", dto.getId());
        request.setAttribute("nome", dto.getNome());
		request.setAttribute("idade", dto.getIdade());
        request.setAttribute("endereco", dto.getEndereco());
        request.setAttribute("telefone", dto.getTelefone());

                   RequestDispatcher lista = request
				.getRequestDispatcher("alterar.jsp");
		lista.forward(request, response);
	}


		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
	}

}
