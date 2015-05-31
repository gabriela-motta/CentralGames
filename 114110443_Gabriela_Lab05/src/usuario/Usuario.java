package usuario;

import java.util.ArrayList;

import jogo.Jogo;

public abstract class Usuario {
	protected String nome;
	protected String login;
	protected ArrayList<Jogo> jogosComprados;
	protected double totalPreco;
	protected double quantidadeDinheiro;
	protected int x2p;

	final String EOL = System.getProperty("line.separator");

	public Usuario(String nome, String login) {
		this.nome = nome;
		this.login = login;
		this.jogosComprados = new ArrayList<Jogo>();
		this.totalPreco = 0;
		this.quantidadeDinheiro = 0;
		this.x2p = 0;
	}
	
	public abstract double disconto(double preco);

	@Override
	public String toString() {
		return this.login + EOL + this.nome + EOL + "Jogador "
				+ this.getClass() + ": " + this.x2p + " x2p" + EOL
				+ "Lista de Jogos:" + EOL + this.getJogosComprados() + EOL
				+ "Total de preco dos jogos: R$ " + this.totalPreco + EOL;
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

	public double getTotalPreco() {
		return totalPreco;
	}

	public void setTotalPreco(double totalPreco) {
		this.totalPreco = totalPreco;
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
