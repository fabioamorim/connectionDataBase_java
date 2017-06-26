package br.com.fabio.jdbc.database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class ConnectionPool {
	
	private DataSource dataSource;
	
	public ConnectionPool() {
		MysqlConnectionPoolDataSource pool = new MysqlConnectionPoolDataSource();
		pool.setUrl("jdbc:mysql://localhost:3306/pessoa_simples");
		pool.setUser("root");
		pool.setPassword("adm123");
		
		this.dataSource = pool;
	}
	
	public Connection pegaConexao() throws SQLException{
		Connection conn = dataSource.getConnection();
		return conn;
	}

}
