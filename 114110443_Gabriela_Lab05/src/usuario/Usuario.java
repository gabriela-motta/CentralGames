package usuario;

import java.util.ArrayList;

import sistema.DadoInvalidoException;
import sistema.NomeInvalidoException;
import jogo.Jogo;

public class Usuario {
	protected String nome;
	protected String login;
	protected ArrayList<Jogo> jogosComprados;
	protected double totalGasto;
	protected double quantidadeDinheiro;
	protected int x2p;

	/**
	 * Construtor de Usuario
	 * 
	 * @param nome
	 *            O nome do usuario
	 * @param login
	 *            O login do usuario
	 * @throws DadoInvalidoException
	 *             Se o nome ou login forem vazios
	 */
	public Usuario(String nome, String login) throws DadoInvalidoException {
		if (nome.equals("")) {
			throw new NomeInvalidoException("Nome nao pode ser vazio");
		}
		if (login.equals("")) {
			throw new NomeInvalidoException("Login nao pode ser vazio");
		}
		this.nome = nome;
		this.login = login;
		this.jogosComprados = new ArrayList<Jogo>();
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
		this.jogosComprados.add(jogo);
		this.quantidadeDinheiro = this.quantidadeDinheiro - jogo.getPreco();
		this.totalGasto = this.totalGasto + jogo.getPreco();
		this.x2p = (int) (this.x2p + (10 * jogo.getPreco()));
	}

	/**
	 * Joga um jogo comprado, alterando a quantidade de x2p do usuario
	 * 
	 * @param nomeJogo
	 *            O nome do jogo a ser jogado
	 * @param score
	 *            A pontuacao atingida
	 * @param zerou
	 *            Indica se o usuario zerou o jogo
	 */
	public void jogar(String nomeJogo, int score, boolean zerou) {
		for (Jogo jogo : jogosComprados) {
			if (jogo.getNome().equals(nomeJogo)) {
				this.x2p = this.x2p + jogo.joga(score, zerou) + punir(nomeJogo)
						+ recompensar(nomeJogo);
			}
		}
	}

	public int recompensar(String nomeJogo) {
		return 0;
	}

	public int punir(String nomeJogo) {
		return 0;
	}

	public double calculaPreco(double preco) {
		return preco;
	}

	/**
	 * Retorna uma String com informacoes do usuario
	 */
	@Override
	public String toString() {
		final String EOL = System.getProperty("line.separator");

		String mensagemJogos = "";
		for (Jogo j : jogosComprados) {
			mensagemJogos = mensagemJogos + j.toString() + EOL;
		}

		return this.login + EOL + this.nome + EOL + "Jogador "
				+ this.getClass() + ": " + this.x2p + " x2p" + EOL
				+ "Lista de Jogos:" + EOL + mensagemJogos
				+ "Total de preco dos jogos: R$ " + this.totalGasto + EOL;
	}

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
		return jogosComprados;
	}

	public void setJogosComprados(ArrayList<Jogo> jogosComprados) {
		this.jogosComprados = jogosComprados;
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
