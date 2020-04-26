package br.com.foursys.locadora.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * Classe responsável por efetuar teste de conexão com banco de dados
 * @author dmunhoz
 *
 */
public class TestaBanco {

	private static Connection bd = null;
	
	public static void main(String[] args) {
		
		final String drive = "com.mysql.jdbc.Driver";
		final String local = "jdbc:mysql://localhost/locadora";
		final String login = "root";
		final String senha = "root";
		
		try {
			Class.forName(drive);
			System.out.println("Driver carregado com sucesso!");
			bd = (Connection) DriverManager.getConnection(local, login, senha);
			System.out.println("Conexão efetuada com sucesso!");
			bd.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao carregar o driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Falha ao conectar ao banco");
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
