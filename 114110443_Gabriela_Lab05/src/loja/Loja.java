package loja;

import java.util.ArrayList;
import java.util.HashSet;

import exceptions.DadoInvalidoException;
import jogo.Jogabilidade;
import jogo.Jogo;
import jogo.JogoFactory;
import usuario.Noob;
import usuario.Usuario;

public class Loja {

	private ArrayList<Usuario> usuarios;
	private double totalArrecadado;
	private JogoFactory fabricaDeJogos;

	public Loja() {
		this.usuarios = new ArrayList<Usuario>();
		this.totalArrecadado = 0;
		this.fabricaDeJogos = new JogoFactory();
	}

	public void criaUsuario(String nome, String login) {
		try {
			Usuario novo = new Noob(nome, login);
			this.usuarios.add(novo);
			
		} catch (DadoInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}

	public void adicionaDinheiro(String nome, double valor) {
		for (Usuario user : usuarios) {
			if (user.getNome().equals(nome)) {
				double quantia = user.getQuantidadeDinheiro() + valor;
				user.setQuantidadeDinheiro(quantia);
			}
		}
	}

	public Jogo criaJogo(String nome, double preco, String tipo,
			HashSet<Jogabilidade> jogabilidade) {
		return fabricaDeJogos.criaJogo(nome, preco, tipo, jogabilidade);
	}

	/*
	 * public void adicionaJogo(String nome, String jogo) {
	 * 
	 * for (Usuario user : usuarios) { if (user.getNome().equals(nome)) { if
	 * (user.getQuantidadeDinheiro() >= precoJogo) { double quantia =
	 * user.getQuantidadeDinheiro() - user.disconto(precoJogo);
	 * user.setQuantidadeDinheiro(quantia);
	 * 
	 * int pontos = user.getX2p() + (int) (10 * precoJogo); user.setX2p(pontos);
	 * 
	 * totalArrecadado = totalArrecadado + quantia; } } }
	 * 
	 * }
	 */

	public void imprimeUsuarios() {
		System.out.println("=== Central P2-CG ===");
		System.out.println(usuarios);
		System.out.println("-------------------------------");
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
