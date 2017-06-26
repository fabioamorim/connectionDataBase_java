package br.com.fabio.jdbc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexao {
	
	private Connection conn = null;
	
	private String servidor = "jdbc:mysql://localhost:3306/pessoa_simples";
	private String usuario = "root";
	private String senha = "adm123";
	private String driver = "com.mysql.jdbc.Driver";
	
	public Connection pegaConexao() throws SQLException{
		try {
			Class.forName(driver);
		    conn = DriverManager.getConnection(servidor,usuario,senha);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return conn;
	}

}
