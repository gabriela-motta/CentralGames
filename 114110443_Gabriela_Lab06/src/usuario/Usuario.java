package usuario;

//114110443 - Gabriela Motta Oliveira: LAB 06 - Turma 3

import java.util.ArrayList;

import jogo.Jogo;
import exceptions.DadoInvalidoException;
import exceptions.EntradaException;
import exceptions.StringInvalidaException;

public class Usuario implements Comparable<Usuario> {

	private String nome;
	private String login;
	private CatalogoJogos jogosComprados;
	private double totalGasto;
	private double quantidadeDinheiro;
	private int x2p;
	private Jogador jogador;

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
		this.jogador = new Noob();
	}

	public int compareTo(Usuario outroUsuario) {
		if (this.x2p > outroUsuario.getX2p()) {
			return 1;
		} else if (this.x2p == outroUsuario.getX2p()) {
			return 0;
		} else {
			return -1;
		}
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

		if (getX2p() >= 1000) {
			viraVeterano();

		} else {
			viraNoob();
		}
	}

	public void ganhouPartida(String nomeJogo, int score, boolean zerou) {
		for (Jogo jogo : getJogosComprados()) {
			if (jogo.getNome().equals(nomeJogo)) {
				this.x2p = this.x2p
						+ this.jogador.ganhouPartida(jogo, score, zerou);
			}
		}

		if (getX2p() >= 1000) {
			viraVeterano();

		} else {
			viraNoob();
		}
	}

	public void perdeuPartida(String nomeJogo, int score, boolean zerou) {
		for (Jogo jogo : getJogosComprados()) {
			if (jogo.getNome().equals(nomeJogo)) {
				this.x2p = this.x2p
						+ this.jogador.perdeuPartida(jogo, score, zerou);
			}
		}

		if (getX2p() >= 1000) {
			viraVeterano();

		} else {
			viraNoob();
		}
	}

	/**
	 * Calcula quanto o usuario vai pagar em um jogo usando descontos
	 * 
	 * @param preco
	 *            O preco do jogo
	 * @return O valor a pagar com desconto
	 */
	public double calculaPreco(double preco) {
		return this.jogador.calculaPreco(preco);
	}

	public void viraNoob() {
		this.jogador = new Noob();
	}

	public void viraVeterano() {
		this.jogador = new Veterano();
	}

	/**
	 * Retorna uma String com informacoes do usuario
	 */
	@Override
	public String toString() {
		final String EOL = System.getProperty("line.separator");

		String mensagemJogos = "";
		for (Jogo j : getJogosComprados()) {
			mensagemJogos = mensagemJogos + j.toString() + EOL;
		}

		String mensagemJogador = this.jogador.toString();

		return getLogin() + EOL + getNome() + EOL + mensagemJogador + this.x2p
				+ " x2p" + EOL + "Lista de Jogos:" + EOL + mensagemJogos
				+ "Total de preco dos jogos: R$ " + getTotalGasto() + EOL;
	}

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
		return this.x2p;
	}

	public void setX2p(int x2p) {
		this.x2p = x2p;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public void setJogosComprados(CatalogoJogos jogosComprados) {
		this.jogosComprados = jogosComprados;
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
