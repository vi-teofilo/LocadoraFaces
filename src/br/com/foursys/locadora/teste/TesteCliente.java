package br.com.foursys.locadora.teste;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.dao.ClienteDAO;
import br.com.foursys.locadora.util.ConnectionFactory;

public class TesteCliente {
	
	
	public void salvar() {
		
		Cliente cliente = new Cliente();
		cliente.setNome("João do Teste");
		cliente.setLogradouro("Rua de teste");
		cliente.setNumeroLogradouro(123);
		cliente.setBairro("Centro");
		cliente.setCidade("São Paulo");
		cliente.setEstado("SP");
		cliente.setCep("06.454-050");
		cliente.setTelefone("(11) 1234-1234");
		cliente.setCpf("111.111.111-11");
		cliente.setRg("11.111.111");
		cliente.setSexo('M');
		cliente.setDataNascimento("20/02/2000");
		cliente.setIdade(20);
		
		Connection bd = ConnectionFactory.getConnection();
		ClienteDAO dao = new ClienteDAO(bd);
		
		try {
			dao.inserir(cliente);
			System.out.println("Cliente inserido com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void pesquisar() {
		
		Connection bd = ConnectionFactory.getConnection();
		ClienteDAO dao = new ClienteDAO(bd);
		
		try {
			List<Cliente> lista = dao.buscarNome("João");
			for (Cliente cliente : lista) {
				System.out.println("Nome do cliente: " + cliente.getNome());
				System.out.println("Telefone do cliente: " + cliente.getTelefone());
				System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new TesteCliente().pesquisar();
	}

}
