package loja;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import usuario.Noob;
import usuario.Usuario;

public class Loja {

	private ArrayList<Usuario> usuarios;
	private double totalArrecadado;
	private HashMap<String, Double> tabelaPrecos;

	public Loja() {
		this.usuarios = new ArrayList<Usuario>();
		this.totalArrecadado = 0;
		this.tabelaPrecos = new HashMap<String, Double>();
	}

	public void criaUsuario(String nome, String login) {
		Usuario novo = new Noob(nome, login);
		this.usuarios.add(novo);
	}

	public void adicionaNaTabela(String nome, double preco) {
		this.tabelaPrecos.put(nome, preco);
	}

	public void adicionaDinheiro(String nome, double valor) {
		for (Usuario user : usuarios) {
			if (user.getNome().equals(nome)) {
				double quantia = user.getQuantidadeDinheiro() + valor;
				user.setQuantidadeDinheiro(quantia);
			}
		}
	}

	public void criaJogo(String nome, double preco, String tipo,
			HashSet<String> jogabilidade) {

	}

	public void adicionaJogo(String nome, String jogo) {
		double precoJogo = tabelaPrecos.get(jogo);

		for (Usuario user : usuarios) {
			if (user.getNome().equals(nome)) {
				if (user.getQuantidadeDinheiro() >= precoJogo) {
					double quantia = user.getQuantidadeDinheiro()
							- user.disconto(precoJogo);
					user.setQuantidadeDinheiro(quantia);

					/*
					 * Jogo novo = new Jogo(jogo, precoJogo); ArrayList<Jogo>
					 * lista = user.getJogosComprados(); lista.add(novo);
					 * user.setJogosComprados(lista);
					 */

					int pontos = user.getX2p() + (int) (10 * precoJogo);
					user.setX2p(pontos);

					totalArrecadado = totalArrecadado + quantia;
				}
			}
		}

	}

	public void imprimeUsuarios() {
		System.out.println("=== Central P2-CG ===");
		System.out.println(usuarios);
		System.out.println("нннннннннннннннннннннннннннннннннннннннннннн");
		System.out.println("Total arrecadado com vendas de jogos: R$ "
				+ this.totalArrecadado);
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public double getTotalArrecadado() {
		return totalArrecadado;
	}

	public void setTotalArrecadado(double totalArrecadado) {
		this.totalArrecadado = totalArrecadado;
	}
}
