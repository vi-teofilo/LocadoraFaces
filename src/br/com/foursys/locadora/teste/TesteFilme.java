package br.com.foursys.locadora.teste;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.dao.FilmeDAO;
import br.com.foursys.locadora.util.ConnectionFactory;

public class TesteFilme {
	
	
	public void salvar() {
		
		Filme filme = new Filme();
		filme.setNome("Filme do Teste");
		filme.setGenero("Teste");
		filme.setValor(123);
		filme.setPromocao("sim");
		filme.setDisponivel("sim");
		filme.setValorPromocao(10);
		
		
		Connection bd = ConnectionFactory.getConnection();
		FilmeDAO dao = new FilmeDAO(bd);
		
		try {
			dao.inserir(filme);
			System.out.println("Filme inserido com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void pesquisar() {
		
		Connection bd = ConnectionFactory.getConnection();
		FilmeDAO dao = new FilmeDAO(bd);
		
		try {
			List<Filme> lista = dao.buscarNome("A era do Gelo");
			for (Filme filme : lista) {
				System.out.println("Nome do Filme: " + filme.getNome());
				System.out.println("Genero do Filme: " + filme.getGenero());
				System.out.println("Valor do Filme: " + filme.getValor());
				System.out.println("Disponivel: " + filme.getDisponivel());
				System.out.println("Promoção: " + filme.getPromocao());
			}
		//	nome, genero, valor, disponivel, promocao
		} catch (SQLException e) {
			System.out.println("erro ao pesquisar filme");
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new TesteFilme().pesquisar();
	}

}
