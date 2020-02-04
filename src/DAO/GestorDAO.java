package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.GestorDTO;

public class GestorDAO {

	private Connection con;

	public GestorDAO(Connection con) {
		this.con = con;

	}

//	Cadastar Gestor
	public void cadastrarGestor(GestorDTO usr) throws SQLException {

		try {
			String sql = "INSERT INTO gestor(nome,idade,endereco,telefone) VALUES(?,?,?,?) ";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, usr.getNome());
			stmt.setInt(2, usr.getIdade());
			stmt.setString(3, usr.getEndereco());
			stmt.setInt(4, usr.getTelefone());

			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

//	Listar Gestor
	public ArrayList<GestorDTO> pesquisarTudo() throws Exception {

		String sql = "SELECT id,nome FROM gestor";

		PreparedStatement stmt = con.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		ArrayList<GestorDTO> listaNomes = new ArrayList<GestorDTO>();

		while (rs.next()) {
			GestorDTO rgsts;
			rgsts = new GestorDTO();
			rgsts.setId(rs.getInt("id"));
			rgsts.setNome(rs.getString("nome"));
			listaNomes.add(rgsts);
		}

		rs.close();
		stmt.close();
		con.close();
		return listaNomes;
	}

	// Pesquisar pelo id
	public GestorDTO pesquisar(int id) throws Exception {
		try {
			GestorDTO registro = new GestorDTO();

			String sql = "SELECT * FROM gestor where id = " + id + " ";

			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				registro.setId(rs.getInt("id"));
				registro.setNome(rs.getString("nome"));
				registro.setIdade(rs.getInt("idade"));
				registro.setEndereco(rs.getString("endereco"));
				registro.setTelefone(rs.getInt("telefone"));
				return registro;
			}

		} catch (Exception e) {
		}
		return null;
	}

	// Alterar
	public void alterar(GestorDTO registro) throws Exception {
		try {

			String sql = "UPDATE gestor SET nome=?, idade=?, endereco=?, telefone=? WHERE id=?";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, registro.getNome());
			stmt.setInt(2, registro.getIdade());
			stmt.setString(3, registro.getEndereco());
			stmt.setInt(4, registro.getTelefone());
			stmt.setInt(5, registro.getId());

			stmt.execute();
			stmt.close();

		} catch (Exception e) {
		}
	}
	
	// Deletar
	public void deletar(GestorDTO dto) throws Exception{
        
        String sql = "delete FROM gestor where id=?";
        
        PreparedStatement stmt = con.prepareStatement(sql);
        
        stmt.setInt(1, dto.getId());
        stmt.execute();
        stmt.close();  
    }

}
