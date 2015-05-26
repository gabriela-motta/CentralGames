package jogo;

import java.util.HashSet;

public class Jogo {

	private String nome;
	private double preco;
	private int highScore;
	private int quantidadeJogada;
	private int quantidadeZerada;
	private HashSet<String> jogabilidade;
	
	public Jogo(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
		this.highScore = 0;
		this.quantidadeJogada = 0;
		this.quantidadeZerada = 0;
		this.jogabilidade = new HashSet<String>();
	}
	
	public boolean joga(int score){
		if (score > this.highScore){
			this.highScore = score;
		}
		return true;
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
		if (obj instanceof Jogo){
			Jogo outroJogo = (Jogo)obj;
			if (outroJogo.getNome().equals(this.getNome()) && outroJogo.getPreco() == this.getPreco()){
				return true;
			}
		}
		return false;
	}
	
	
}
