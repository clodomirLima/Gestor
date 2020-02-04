package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection conect() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/db", "root", "23r0");
        } catch (SQLException e) {
            throw new SQLException(e);
        } catch (ClassNotFoundException e1) {
            throw new SQLException(e1);
        }

    }

}
