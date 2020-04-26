package br.com.foursys.locadora.backingbean;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.bean.Filme;
import br.com.foursys.locadora.dao.FilmeDAO;
import br.com.foursys.locadora.util.ConnectionFactory;
import br.com.foursys.locadora.util.JSFUtil;

public class FilmeBacking {

	private int codigo;
	private String nome;
	private String genero;
	private String valor;
	private String promocao;
	private String disponivel;
	private String valorPromocao;
	

	private Filme filme	= new Filme();
	private Filme filmeSelecionado = new Filme();
	private List<Filme> listaFilme;

	

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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	
	public String getPromocao() {
		return promocao;
	}

	public void setPromocao(String promocao) {
		this.promocao = promocao;
	}

	public String getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(String disponivel) {
		this.disponivel = disponivel;
	}



	public String getValorPromocao() {
		return valorPromocao;
	}

	public void setValorPromocao(String valorPromocao) {
		this.valorPromocao = valorPromocao;
	}

	public List<Filme> getListaFilme() {
		return listaFilme;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Filme getFilmeSelecionado() {
		return filmeSelecionado;
	}

	public void setFilmeSelecionado(Filme filmeSelecionado) {
		this.filmeSelecionado = filmeSelecionado;
	}

	public void setListaFilme(List<Filme> listaFilme) {
		this.listaFilme = listaFilme;
	}

	public String cadastraFilme() {
		return "";
	}

	public String consultaFilme() {
		return "";
	}

	public String cancelar() {
		return "cancelar";
	}

	

	public String salvar() {

		if (validarDados()) {

			filme.setNome(nome);
			filme.setGenero(genero);
			filme.setValor(Double.parseDouble(valor.replace(".", "").replace(",", ".")));
			filme.setPromocao(promocao);
			filme.setDisponivel(disponivel);
			filme.setValorPromocao(Double.parseDouble(valorPromocao.replace(".", "").replace(",", ".")));
			

			Connection bd = ConnectionFactory.getConnection();
			FilmeDAO dao = new FilmeDAO(bd);

			try {
				dao.inserir(filme);
				bd.close();
				limparDados();
				JSFUtil.addInfoMessage("Filme salvo com sucesso!");
			} catch (SQLException e) {
				JSFUtil.addInfoMessage("Erro ao inserir o filme!");
				e.printStackTrace();
			}

		}

		return "";
	}

	public void limparDados() {
		nome = null;
		genero= null;
		valor = null;
		promocao = null;
		disponivel = null;
		valorPromocao= null;
	}

	public boolean validarDados() {
		if (nome.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o nome, campo obrigatório!");
			return false;
		}
		if (genero.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o Genêro, campo obrigatório!");
			return false;
		}
		if (valor.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o Valor, campo obrigatório!");
			return false;
		}
		if (promocao.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o Promoção, campo obrigatório!");
			return false;
		}
		if (disponivel.trim().equals("")) {
			JSFUtil.addInfoMessage("Informe o Disponivel, campo obrigatório!");
			return false;
		}
	
		return true;
	}
	
	

	public String pesquisar() {
		listaFilme = new ArrayList<Filme>();

		Connection bd = ConnectionFactory.getConnection();
		FilmeDAO dao = new FilmeDAO(bd);

		try {
			listaFilme= dao.buscarNome(nome);
			bd.close();
		} catch (SQLException e) {
			JSFUtil.addInfoMessage("Erro ao pesquisar o Filme!");
			e.printStackTrace();
		}
		return "";
	}
	
	public String excluir() {
		Connection bd = ConnectionFactory.getConnection();
		FilmeDAO dao = new FilmeDAO(bd);
		
		try {
			dao.excluir(filmeSelecionado);
			bd.close();
			pesquisar();
			JSFUtil.addInfoMessage("Filme excluido com sucesso!");
		} catch (SQLException e) {
			JSFUtil.addInfoMessage("Erro ao excluir Filme!");
			e.printStackTrace();
		}
		
		
		return "";
	}
	
	public String alterarFilme() {
		
		codigo = filmeSelecionado.getCodigo();
		nome = filmeSelecionado.getNome();
		genero= filmeSelecionado.getGenero();
		valor = filmeSelecionado.getValor()+"";
		promocao = filmeSelecionado.getPromocao();
		disponivel = filmeSelecionado.getDisponivel();
		valorPromocao=filmeSelecionado.getValorPromocao()+"";
		
		return "alterar";
	}
	
	public String alterar() {
		
		if (validarDados()) {
			
			filmeSelecionado.setCodigo(codigo);
			filmeSelecionado.setNome(nome);
			filmeSelecionado.setGenero(genero);
			filmeSelecionado.setValor(Double.parseDouble(valor.replace(".", "").replace(",", ".")));
			filmeSelecionado.setPromocao(promocao);
			filmeSelecionado.setDisponivel(disponivel);
			filmeSelecionado.setValorPromocao(Double.parseDouble(valorPromocao.replace(".", "").replace(",", ".")));
			

			Connection bd = ConnectionFactory.getConnection();
			FilmeDAO dao = new FilmeDAO(bd);

			try {
				dao.alterar(filmeSelecionado);
				bd.close();
				limparDados();
				JSFUtil.addInfoMessage("Filme alterado com sucesso!");
			} catch (SQLException e) {
				JSFUtil.addInfoMessage("Erro ao inserir o Filme!");
				e.printStackTrace();
			}

		}

		return "";
	}
	
	public String valorTabela(Filme filme) {
		NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance();
		return formatoMoeda.format(filme.getValor());
	}
}
