package usuario;

import java.util.ArrayList;

import sistema.DadoInvalidoException;
import jogo.Jogo;

public class Usuario {
	protected String nome;
	protected String login;
	protected ArrayList<Jogo> jogosComprados;
	protected double totalPreco;
	protected double quantidadeDinheiro;
	protected int x2p;

	public Usuario(String nome, String login) throws DadoInvalidoException {
		if (nome.equals("")) {
			throw new DadoInvalidoException("Nome nao pode ser vazio");
		}
		if (login.equals("")) {
			throw new DadoInvalidoException("Login nao pode ser vazio");
		}
		this.nome = nome;
		this.login = login;
		this.jogosComprados = new ArrayList<Jogo>();
		this.totalPreco = 0;
		this.quantidadeDinheiro = 0;
		this.x2p = 0;
	}

	public void adicionaJogo(Jogo jogo) {
		if (this.quantidadeDinheiro >= jogo.getPreco()) {
			this.jogosComprados.add(jogo);
			this.quantidadeDinheiro = this.quantidadeDinheiro - jogo.getPreco();
			this.totalPreco = this.totalPreco + jogo.getPreco();
			this.x2p = (int) (this.x2p + (10 * jogo.getPreco()) + jogo
					.getTotalPontos());
		}
	}

	public double calculaPreco(double preco) {
		return preco;
	}

	@Override
	public String toString() {
		final String EOL = System.getProperty("line.separator");

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
