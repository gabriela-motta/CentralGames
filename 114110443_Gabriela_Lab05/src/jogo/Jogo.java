package jogo;

//114110443 - Gabriela Motta Oliveira: LAB 05 - Turma 3

import java.util.HashSet;

import sistema.DadoInvalidoException;
import sistema.EntradaException;
import sistema.StringInvalidaException;

public abstract class Jogo {

	private String nome;
	private double preco;
	private int highScore;
	private int quantidadeJogada;
	private int quantidadeZerada;
	private HashSet<Jogabilidade> jogabilidade;

	/**
	 * Construtor de Jogo
	 * 
	 * @param nome
	 *            O nome do jogo
	 * @param preco
	 *            O preco do jogo
	 * @param jogabilidade
	 *            Conjunto de jogabilidades do jogo
	 * @throws DadoInvalidoException
	 *             Se o nome for vazio ou o se o preco for negativo
	 */
	public Jogo(String nome, double preco, HashSet<Jogabilidade> jogabilidade)
			throws EntradaException {
		if (nome.equals("")) {
			throw new StringInvalidaException();
		}
		if (preco < 0.0) {
			throw new DadoInvalidoException();
		}
		this.nome = nome;
		this.preco = preco;
		this.highScore = 0;
		this.quantidadeJogada = 0;
		this.quantidadeZerada = 0;
		this.jogabilidade = jogabilidade;
	}

	/**
	 * Retorna uma String com informacoes do jogo
	 */
	@Override
	public abstract String toString();

	/**
	 * Joga o jogo, alterando a quantidade jogada, a quantidade zerada e o high
	 * score se necessario
	 * 
	 * @param score
	 *            A pontuacao atingida
	 * @param zerou
	 *            Indica se o usuario zerou o jogo
	 * @return Pontos extras que o usuario ganhou ao jogar
	 */
	public abstract int joga(int score, boolean zerou);

	// GETTERS E SETTERS
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	public int getQuantidadeJogada() {
		return quantidadeJogada;
	}

	public void setQuantidadeJogada(int quantidadeJogada) {
		this.quantidadeJogada = quantidadeJogada;
	}

	public int getQuantidadeZerada() {
		return quantidadeZerada;
	}

	public void setQuantidadeZerada(int quantidadeZerada) {
		this.quantidadeZerada = quantidadeZerada;
	}

	public HashSet<Jogabilidade> getJogabilidade() {
		return jogabilidade;
	}

	public void setJogabilidade(HashSet<Jogabilidade> jogabilidade) {
		this.jogabilidade = jogabilidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Jogo) {
			Jogo outroJogo = (Jogo) obj;
			if (outroJogo.getNome().equals(this.getNome())
					&& outroJogo.getPreco() == this.getPreco()) {
				return true;
			}
		}
		return false;
	}

}
