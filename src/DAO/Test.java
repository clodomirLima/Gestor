package DAO;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = Conexao.conect();
		System.out.println("Conectou!");

	}

}
