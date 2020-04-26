package br.com.foursys.locadora.backingbean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.bean.Cliente;
import br.com.foursys.locadora.dao.ClienteDAO;
import br.com.foursys.locadora.util.ConnectionFactory;
import br.com.foursys.locadora.util.JSFUtil;

public class ClienteBacking {

	private int codigo;
	private String nome;
	private String logradouro;
	private int numeroLogradouro;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String telefone;
	private String cpf;
	private String rg;
	private String sexo;
	private String dataNascimento;
	private int idade;

	private Cliente cliente = new Cliente();
	private Cliente clienteSelecionado = new Cliente();
	private List<Cliente> listaCliente;

	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumeroLogradouro() {
		return numeroLogradouro;
	}

	public void setNumeroLogradouro(int numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public String cadastraCliente() {
		return "";
	}

	public String consultaCliente() {
		return "";
	}

	public String cancelar() {
		return "cancelar";
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public String salvar() {

		if (validarDados()) {

			cliente.setNome(nome);
			cliente.setLogradouro(logradouro);
			cliente.setNumeroLogradouro(numeroLogradouro);
			cliente.setBairro(bairro);
			cliente.setCidade(cidade);
			cliente.setEstado(estado);
			cliente.setCep(cep);
			cliente.setTelefone(telefone);
			cliente.setCpf(cpf);
			cliente.setRg(rg);
			cliente.setSexo(sexo.charAt(0));
			cliente.setDataNascimento(dataNascimento);
			cliente.setIdade(idade);

			Connection bd = ConnectionFactory.getConnection();
			ClienteDAO dao = new ClienteDAO(bd);

			try {
				dao.inserir(cliente);
				bd.close();
				limparDados();
				JSFUtil.addInfoMessage("Cliente salvo com sucesso!");
			} catch (SQLException e) {
				JSFUtil.addInfoMessage("Erro ao inserir o cliente!");
				e.printStackTrace();
			}

		}

		return "";
	}

	public void limparDados() {
		nome = null;
		logradouro = null;
		numeroLogradouro = 0;
		bairro = null;
		cidade = null;
		estado = null;
		cep = null;
		telefone = null;
		cpf = null;
		rg = null;
		sexo = null;
		dataNascimento = null;
		idade = 0;
	}

	public boolean validarDados() {
		if (nome.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o nome, campo obrigatório!");
			return false;
		}
		if (logradouro.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o logradouro, campo obrigatório!");
			return false;
		}
		if (numeroLogradouro == 0) {
			JSFUtil.addInfoMessage("Informe o numero, campo obrigatório!");
			return false;
		}
		if (bairro.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o bairro, campo obrigatório!");
			return false;
		}
		if (cidade.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o cidade, campo obrigatório!");
			return false;
		}
		if (estado.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o estado, campo obrigatório!");
			return false;
		}
		if (cep.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o cep, campo obrigatório!");
			return false;
		}
		if (telefone.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o telefone, campo obrigatório!");
			return false;
		}
		if (cpf.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o cpf, campo obrigatório!");
			return false;
		}
		if (rg.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o rg, campo obrigatório!");
			return false;
		}
		if (sexo.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o sexo, campo obrigatório!");
			return false;
		}
		if (dataNascimento.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o nascimento, campo obrigatório!");
			return false;
		}
		if (idade == 0) {
			JSFUtil.addInfoMessage("Informe a idade, campo obrigatório!");
			return false;
		}
		return true;
	}

	public String pesquisar() {
		listaCliente = new ArrayList<Cliente>();

		Connection bd = ConnectionFactory.getConnection();
		ClienteDAO dao = new ClienteDAO(bd);

		try {
			listaCliente = dao.buscarNome(nome);
			bd.close();
		} catch (SQLException e) {
			JSFUtil.addInfoMessage("Erro ao pesquisar o Cliente!");
			e.printStackTrace();
		}
		return "";
	}
	
	public String excluir() {
		Connection bd = ConnectionFactory.getConnection();
		ClienteDAO dao = new ClienteDAO(bd);
		
		try {
			dao.excluir(clienteSelecionado);
			bd.close();
			pesquisar();
			JSFUtil.addInfoMessage("Cliente excluido com sucesso!");
		} catch (SQLException e) {
			JSFUtil.addInfoMessage("Erro ao excluir Cliente!");
			e.printStackTrace();
		}
		
		
		return "";
	}
	
	public String alterarCliente() {
		codigo = clienteSelecionado.getCodigo();
		nome = clienteSelecionado.getNome();
		logradouro = clienteSelecionado.getLogradouro();
		numeroLogradouro = clienteSelecionado.getNumeroLogradouro();
		bairro = clienteSelecionado.getBairro();
		cidade = clienteSelecionado.getCidade();
		estado = clienteSelecionado.getEstado();
		cep = clienteSelecionado.getCep();
		telefone = clienteSelecionado.getTelefone();
		cpf = clienteSelecionado.getCpf();
		rg = clienteSelecionado.getRg();
		sexo = clienteSelecionado.getSexo() + "";
		dataNascimento = clienteSelecionado.getDataNascimento();
		idade = clienteSelecionado.getIdade();
		
		return "alterar";
	}
	
	public String alterar() {
		
		if (validarDados()) {
			
			clienteSelecionado.setCodigo(codigo);
			clienteSelecionado.setNome(nome);
			clienteSelecionado.setLogradouro(logradouro);
			clienteSelecionado.setNumeroLogradouro(numeroLogradouro);
			clienteSelecionado.setBairro(bairro);
			clienteSelecionado.setCidade(cidade);
			clienteSelecionado.setEstado(estado);
			clienteSelecionado.setCep(cep);
			clienteSelecionado.setTelefone(telefone);
			clienteSelecionado.setCpf(cpf);
			clienteSelecionado.setRg(rg);
			clienteSelecionado.setSexo(sexo.charAt(0));
			clienteSelecionado.setDataNascimento(dataNascimento);
			clienteSelecionado.setIdade(idade);

			Connection bd = ConnectionFactory.getConnection();
			ClienteDAO dao = new ClienteDAO(bd);

			try {
				dao.alterar(clienteSelecionado);
				bd.close();
				limparDados();
				JSFUtil.addInfoMessage("Cliente alterado com sucesso!");
			} catch (SQLException e) {
				JSFUtil.addInfoMessage("Erro ao inserir o cliente!");
				e.printStackTrace();
			}

		}

		return "";
	}
	

}
