package br.com.fabio.jdbc.teste;

import java.sql.SQLException;
import java.util.List;

import br.com.fabio.jdbc.dao.PessoaDAO;
import br.com.fabio.jdbc.database.Conexao;
import br.com.fabio.jdbc.database.ConnectionPool;
import br.com.fabio.jdbc.model.Pessoa;

public class TestaPessoaDao {
	
	public static void main(String[] args) throws SQLException {
		
		Pessoa p1 = new Pessoa("João Ferreira",50);
		
		PessoaDAO pessoaDao = new PessoaDAO(new ConnectionPool().pegaConexao());
		
		pessoaDao.salvaPessoa(p1);
		
		List<Pessoa> pessoas = pessoaDao.lista();
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
		
	}
}
