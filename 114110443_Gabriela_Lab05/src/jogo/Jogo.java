package jogo;

import java.util.HashSet;

import exceptions.DadoInvalidoException;

public abstract class Jogo {

	protected String nome;
	protected double preco;
	protected int highScore;
	protected int quantidadeJogada;
	protected int quantidadeZerada;
	protected HashSet<Jogabilidade> jogabilidade;

	final String EOL = System.getProperty("line.separator");

	public Jogo(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws DadoInvalidoException {
		if (nome.equals("")){
			throw new DadoInvalidoException("Nome nao pode ser vazio");
		}
		this.nome = nome;
		this.preco = preco;
		this.highScore = 0;
		this.quantidadeJogada = 0;
		this.quantidadeZerada = 0;
		this.jogabilidade = jogabilidade;
	}

	@Override
	public String toString() {
		return "+ " + this.nome + " - " + this.getClass() + EOL + "==> Jogou "
				+ this.quantidadeJogada + " vez(es)" + EOL + "==> Zerou "
				+ this.quantidadeZerada + " vez(es)" + EOL
				+ "==> Maior score: " + this.highScore + EOL;
	}

	public void joga(int score, boolean zerou) {
		this.quantidadeJogada = this.quantidadeJogada + 1;
		if (zerou){
			this.quantidadeZerada = this.quantidadeZerada + 1;
		}
		if (score > this.highScore) {
			this.highScore = score;
		}
	}

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
