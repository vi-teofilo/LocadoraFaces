package br.com.foursys.locadora.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.bean.Cliente;

public class ClienteDAO {

private Connection bd;
	
	public ClienteDAO(Connection bd) {
		this.bd = bd;
	}

	public void inserir(Cliente cliente) throws SQLException {
		String sql = "INSERT INTO cliente (nome, logradouro, numero_logradouro, bairro, cidade, estado, cep, telefone, cpf, rg, sexo,"
				+ "data_nascimento, idade) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement comando = bd.prepareStatement(sql);
		comando.setString(1, cliente.getNome());
		comando.setString(2, cliente.getLogradouro());
		comando.setInt(3, cliente.getNumeroLogradouro());
		comando.setString(4, cliente.getBairro());
		comando.setString(5, cliente.getCidade());
		comando.setString(6, cliente.getEstado());
		comando.setString(7, cliente.getCep());
		comando.setString(8, cliente.getTelefone());
		comando.setString(9, cliente.getCpf());
		comando.setString(10, cliente.getRg());
		comando.setString(11, cliente.getSexo() + "");
		comando.setString(12, cliente.getDataNascimento());
		comando.setInt(13, cliente.getIdade());
		
		comando.execute();
	}
	
	
	public List<Cliente> buscarTodos() throws SQLException{
		String sql = "SELECT * FROM cliente ORDER BY nome";
		PreparedStatement comando = bd.prepareStatement(sql);
		ResultSet cursor = comando.executeQuery();
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		
		while (cursor.next()) {
			Cliente cliente = new Cliente();
			cliente.setCodigo(cursor.getInt("codigo"));
			cliente.setNome(cursor.getString("nome"));
			cliente.setLogradouro(cursor.getString("logradouro"));
			cliente.setNumeroLogradouro(cursor.getInt("numero_logradouro"));
			cliente.setBairro(cursor.getString("bairro"));
			cliente.setCidade(cursor.getString("cidade"));
			cliente.setEstado(cursor.getString("estado"));
			cliente.setCep(cursor.getString("cep"));
			cliente.setTelefone(cursor.getString("telefone"));
			cliente.setCpf(cursor.getString("cpf"));
			cliente.setRg(cursor.getString("rg"));
			cliente.setSexo(cursor.getString("sexo").charAt(0));
			cliente.setDataNascimento(cursor.getString("data_nascimento"));
			cliente.setIdade(cursor.getInt("idade"));
			
			listaClientes.add(cliente);
		}
		return listaClientes;
	}
	
	public List<Cliente> buscarNome(String nome) throws SQLException{
		String sql = "SELECT * FROM cliente WHERE nome LIKE ? ORDER BY nome";
		PreparedStatement comando = bd.prepareStatement(sql);
		comando.setString(1, nome + "%");
		ResultSet cursor = comando.executeQuery();
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		
		while (cursor.next()) {
			Cliente cliente = new Cliente();
			cliente.setCodigo(cursor.getInt("codigo"));
			cliente.setNome(cursor.getString("nome"));
			cliente.setLogradouro(cursor.getString("logradouro"));
			cliente.setNumeroLogradouro(cursor.getInt("numero_logradouro"));
			cliente.setBairro(cursor.getString("bairro"));
			cliente.setCidade(cursor.getString("cidade"));
			cliente.setEstado(cursor.getString("estado"));
			cliente.setCep(cursor.getString("cep"));
			cliente.setTelefone(cursor.getString("telefone"));
			cliente.setCpf(cursor.getString("cpf"));
			cliente.setRg(cursor.getString("rg"));
			cliente.setSexo(cursor.getString("sexo").charAt(0));
			cliente.setDataNascimento(cursor.getString("data_nascimento"));
			cliente.setIdade(cursor.getInt("idade"));
			
			listaClientes.add(cliente);
		}
		return listaClientes;
	}
	
	public void excluir(Cliente cliente) throws SQLException {
		String sql = "DELETE FROM cliente WHERE codigo=?";
		PreparedStatement comando = bd.prepareStatement(sql);
		comando.setInt(1, cliente.getCodigo());
		comando.execute();
	}
	
	public void alterar(Cliente cliente) throws SQLException {
        String sql = "UPDATE cliente SET nome=?, logradouro=?, numero_logradouro=?, bairro=?, cidade=?, estado=?, cep=?, telefone=?, cpf=?, rg=?, "
                + "sexo=?, data_nascimento=?, idade=? WHERE codigo=?";
        PreparedStatement comando = bd.prepareStatement(sql);
        comando.setString(1, cliente.getNome());
        comando.setString(2, cliente.getLogradouro());
        comando.setInt(3, cliente.getNumeroLogradouro());
        comando.setString(4, cliente.getBairro());
        comando.setString(5, cliente.getCidade());
        comando.setString(6, cliente.getEstado());
        comando.setString(7, cliente.getCep());
        comando.setString(8, cliente.getTelefone());
        comando.setString(9, cliente.getCpf());
        comando.setString(10, cliente.getRg());
        comando.setString(11, String.valueOf(cliente.getSexo()));
        comando.setString(12, cliente.getDataNascimento());
        comando.setInt(13, cliente.getIdade());
        comando.setInt(14, cliente.getCodigo());
        comando.execute();
    }
}
