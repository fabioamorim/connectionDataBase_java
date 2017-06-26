package br.com.fabio.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import br.com.fabio.jdbc.model.Pessoa;

public class PessoaDAO {
	
	private Connection conn;
	private DataSource pool;

	public PessoaDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvaPessoa(Pessoa pessoa) throws SQLException{
		
		String nome = pessoa.getNome();
		int idade = pessoa.getIdade();
		
		String sql = "insert into pessoa (nome, idade) values (?,?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, nome);
		stmt.setInt(2, idade);
		
		System.out.println(sql);
		
		stmt.execute();
	}
	
	public void delete(int id) throws SQLException{
		
		Statement stmt = conn.createStatement();
		
		String sql = "delete from pessoa where id > "+id;
		
		stmt.execute(sql);
	}
	
	public void altera(int id, String nome, int idade) throws SQLException{
		
		Statement stmt = conn.createStatement();
		
		String sql = "update pessoa set nome ='"+nome+"', idade ="+idade+" where id = "+id;
		
		stmt.execute(sql);
	}
	
	public List lista() throws SQLException{
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		Statement stmt = conn.createStatement();
		
		ResultSet rst = stmt.executeQuery("select * from pessoa");
		
		while(rst.next()){
			
			int id = rst.getInt("id");
			String nome = rst.getString("nome");
			int idade = rst.getInt("idade");
			
			Pessoa pessoa = new Pessoa(nome,idade);
			pessoa.setId(id);
			
			pessoas.add(pessoa);
		}
		
		return pessoas;
	}


}
