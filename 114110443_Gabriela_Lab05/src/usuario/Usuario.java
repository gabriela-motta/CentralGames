package usuario;

import java.util.ArrayList;

import jogo.Jogo;

public class Usuario {
	private String nome;
	private String login;
	private ArrayList<Jogo> jogosComprados;
	private double totalPreco;
	private double quantidadeDinheiro;

	final String EOL = System.getProperty("line.separator");

	public Usuario(String nome, String login) {
		this.nome = nome;
		this.login = login;
		this.jogosComprados = new ArrayList<Jogo>();
		this.totalPreco = 0;
		this.quantidadeDinheiro = 0;
	}

	@Override
	public String toString() {
		return this.login + EOL + this.nome + " - Jogador " + this.getClass()
				+ EOL + "Lista de Jogos:" + EOL + this.getJogosComprados()
				+ EOL + "Total de preco dos jogos: R$ " + this.totalPreco + EOL;
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
