package br.com.foursys.locadora.backingbean;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.bean.Vendedor;
import br.com.foursys.locadora.dao.VendedorDAO;
import br.com.foursys.locadora.util.ConnectionFactory;
import br.com.foursys.locadora.util.JSFUtil;

public class VendedorBacking {

	private int codigo;
	private String nome;
	private String areaVenda;
	private String cidade;
	private String estado;
	private String sexo;
	private int idade;
	private String salario;

	private Vendedor vendedor = new Vendedor();
	private Vendedor vendedorSelecionado = new Vendedor();
	private List<Vendedor> listaVendedor;

	
	

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

	public String getAreaVenda() {
		return areaVenda;
	}

	public void setAreaVenda(String areaVenda) {
		this.areaVenda = areaVenda;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Vendedor getVendedorSelecionado() {
		return vendedorSelecionado;
	}

	public void setVendedorSelecionado(Vendedor vendedorSelecionado) {
		this.vendedorSelecionado = vendedorSelecionado;
	}

	public void setListaVendedor(List<Vendedor> listaVendedor) {
		this.listaVendedor = listaVendedor;
	}

	public String cadastraVendedor() {
		return "";
	}

	public String consultaVendedor() {
		return "";
	}

	public String cancelar() {
		return "cancelar";
	}

	public List<Vendedor> getListaVendedor() {
		return listaVendedor;
	}

	public String salvar() {

		if (validarDados()) {

			vendedor.setNome(nome);
			vendedor.setAreaVenda(areaVenda);
			vendedor.setCidade(cidade);
			vendedor.setEstado(estado);
			vendedor.setSexo(sexo.charAt(0));
			vendedor.setIdade(idade);
			vendedor.setSalario(Double.parseDouble(salario.replace(".", "").replace(",", ".")));
			Connection bd = ConnectionFactory.getConnection();
			VendedorDAO dao = new VendedorDAO(bd);

			try {
				dao.inserir(vendedor);
				bd.close();
				limparDados();
				JSFUtil.addInfoMessage("Vendedor salvo com sucesso!");
			} catch (SQLException e) {
				JSFUtil.addInfoMessage("Erro ao inserir o vendedor!");
				e.printStackTrace();
			}

		}

		return "";
	}

	public void limparDados() {
		nome = null;
		areaVenda = null;
		cidade = null;
		estado = null;
		sexo = null;	
		idade = 0;
		salario = null;
	}

	public boolean validarDados() {
		if (nome.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o nome, campo obrigatório!");
			return false;
		}
		if (areaVenda.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe a area de venda, campo obrigatório!");
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
		
		if (sexo.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o sexo, campo obrigatório!");
			return false;
		}
		
		if (idade == 0) {
			JSFUtil.addInfoMessage("Informe a idade, campo obrigatório!");
			return false;
		}
		if (salario.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o salario, campo obrigatório!");
			return false;
		}
		return true;
	}

	public String pesquisar() {
		listaVendedor = new ArrayList<Vendedor>();

		Connection bd = ConnectionFactory.getConnection();
		VendedorDAO dao = new VendedorDAO(bd);

		try {
			listaVendedor = dao.buscarNome(nome);
			bd.close();
		} catch (SQLException e) {
			JSFUtil.addInfoMessage("Erro ao pesquisar o Vendedor!");
			e.printStackTrace();
		}
		return "";
	}
	
	public String excluir() {
		Connection bd = ConnectionFactory.getConnection();
		VendedorDAO dao = new VendedorDAO(bd);
		
		try {
			dao.excluir(vendedorSelecionado);
			bd.close();
			pesquisar();
			JSFUtil.addInfoMessage("Vendedor excluido com sucesso!");
		} catch (SQLException e) {
			JSFUtil.addInfoMessage("Erro ao excluir Vendedor!");
			e.printStackTrace();
		}
		
		
		return "";
	}
	
	public String alterarVendedor() {
		codigo = vendedorSelecionado.getCodigo();
		nome = vendedorSelecionado.getNome();
		areaVenda = vendedorSelecionado.getAreaVenda();
		cidade = vendedorSelecionado.getCidade();
		estado = vendedorSelecionado.getEstado();
		sexo = vendedorSelecionado.getSexo() + "";
		idade = vendedorSelecionado.getIdade();
		salario = vendedorSelecionado.getSalario() + "";
		
		return "alterar";
	}
	
	public String alterar() {
		
		if (validarDados()) {
			
			vendedorSelecionado.setCodigo(codigo);
			vendedorSelecionado.setNome(nome);
			vendedorSelecionado.setAreaVenda(areaVenda);
			vendedorSelecionado.setCidade(cidade);
			vendedorSelecionado.setEstado(estado);
			vendedorSelecionado.setSexo(sexo.charAt(0));
			vendedorSelecionado.setIdade(idade);
			vendedorSelecionado.setSalario(Double.parseDouble(salario.replace(".", "").replace(",", ".")));

			Connection bd = ConnectionFactory.getConnection();
			VendedorDAO dao = new VendedorDAO(bd);

			try {
				dao.alterar(vendedorSelecionado);
				bd.close();
				limparDados();
				JSFUtil.addInfoMessage("Vendedor alterado com sucesso!");
			} catch (SQLException e) {
				JSFUtil.addInfoMessage("Erro ao alterar o vendedor!");
				e.printStackTrace();
			}

		}

		return "";
	}
	public String valorTabela(Vendedor vendedor) {
		NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance();
		return formatoMoeda.format(vendedor.getSalario());
	}

}
