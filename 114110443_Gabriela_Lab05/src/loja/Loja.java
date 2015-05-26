package loja;

import java.util.ArrayList;
import java.util.HashMap;

import jogo.*;
import usuario.*;

public class Loja {

	private ArrayList<Usuario> usuarios;
	private double totalArrecadado;
	private HashMap<Jogo, Double> tabelaPrecos;

	public Loja() {
		this.usuarios = new ArrayList<Usuario>();
		this.totalArrecadado = 0;
		this.tabelaPrecos = new HashMap<Jogo, Double>();
	}

	public void criaUsuario(String nome, String login) {
		Usuario novo = new Noob(nome, login);
		this.usuarios.add(novo);
	}

	public void criaJogo(String nome, double preco) {
		Jogo novo = new Jogo(nome, preco);
		this.tabelaPrecos.put(novo, preco);
	}

	public void vendeJogo(String usuario, String jogo) {

	}

	public void imprimeUsuarios() {
		System.out.println("=== Central P2-CG ===");
		System.out.println(usuarios);
		System.out.println("нннннннннннннннннннннннннннннннннннннннннннн");
		System.out.println("Total arrecadado com vendas de jogos: R$ "
				+ this.totalArrecadado);
	}
}
