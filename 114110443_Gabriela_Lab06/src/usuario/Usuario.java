package usuario;

//114110443 - Gabriela Motta Oliveira: LAB 06 - Turma 3

import java.util.ArrayList;

import jogo.Jogo;
import exceptions.DadoInvalidoException;
import exceptions.EntradaException;
import exceptions.StringInvalidaException;

public abstract class Usuario {

	private String nome;
	private String login;
	private CatalogoJogos jogosComprados;
	private double totalGasto;
	private double quantidadeDinheiro;
	private int x2p;

	/**
	 * Construtor de Usuario
	 * 
	 * @param nome
	 *            O nome do usuario
	 * @param login
	 *            O login do usuario
	 * @throws DadoInvalidoException
	 *             Se o nome ou o login forem vazios
	 */
	public Usuario(String nome, String login) throws EntradaException {
		if (nome.equals("")) {
			throw new StringInvalidaException();
		}
		if (login.equals("")) {
			throw new StringInvalidaException();
		}
		this.nome = nome;
		this.login = login;
		this.jogosComprados = new CatalogoJogos();
		this.totalGasto = 0;
		this.quantidadeDinheiro = 0;
		this.x2p = 0;
	}

	/**
	 * Adiciona um jogo na lista de jogos comprados do usuario, diminuindo a
	 * quantidade de dinheiro e aumentando o total gasto em compras e o x2p do
	 * usuario
	 * 
	 * @param jogo
	 *            O jogo a ser adicionado
	 */
	public void adicionaJogo(Jogo jogo) {
		this.jogosComprados.adicionaJogo(jogo);
		this.quantidadeDinheiro = this.quantidadeDinheiro - jogo.getPreco();
		this.totalGasto = this.totalGasto + jogo.getPreco();
		this.x2p = (int) (this.x2p + (10 * jogo.getPreco()));
	}

	/**
	 * Recompensa o usuario adicionando x2p de acordo com a jogabilidade do jogo
	 * 
	 * @param nomeJogo
	 *            O nome do jogo
	 */
	public abstract void recompensar(String nomeJogo, int score, boolean zerou);

	/**
	 * Pune o usuario removendo x2p de acordo com a jogabilidade do jogo
	 * 
	 * @param nomeJogo
	 *            O nome do jogo
	 */
	public abstract void punir(String nomeJogo, int score, boolean zerou);

	/**
	 * Calcula quanto o usuario vai pagar em um jogo usando descontos
	 * 
	 * @param preco
	 *            O preco do jogo
	 * @return O valor a pagar com desconto
	 */
	public abstract double calculaPreco(double preco);

	/**
	 * Retorna uma String com informacoes do usuario
	 */
	@Override
	public abstract String toString();

	// GETTERS E SETTERS
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public ArrayList<Jogo> getJogosComprados() {
		return jogosComprados.getListaJogos();
	}

	public void setJogosComprados(ArrayList<Jogo> jogosComprados) {
		this.jogosComprados.setListaJogos(jogosComprados);
	}

	public double getQuantidadeDinheiro() {
		return quantidadeDinheiro;
	}

	public void setQuantidadeDinheiro(double quantidadeDinheiro) {
		this.quantidadeDinheiro = quantidadeDinheiro;
	}

	public double getTotalGasto() {
		return totalGasto;
	}

	public void setTotalGasto(double totalGasto) {
		this.totalGasto = totalGasto;
	}

	public int getX2p() {
		return x2p;
	}

	public void setX2p(int x2p) {
		this.x2p = x2p;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			Usuario outroUsuario = (Usuario) obj;
			if (this.getLogin().equals(outroUsuario.getLogin())) {
				return true;
			}
		}
		return false;
	}

}
