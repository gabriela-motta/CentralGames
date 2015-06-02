package jogo;

import java.util.HashSet;

import exceptions.DadoInvalidoException;

public class JogoFactory {

	private Jogo criaRPG(String nome, double preco,
			HashSet<Jogabilidade> jogabilidade) {
		try {
			return new RPG(nome, preco, jogabilidade);

		} catch (DadoInvalidoException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	private Jogo criaLuta(String nome, double preco,
			HashSet<Jogabilidade> jogabilidade) {
		try {
			return new Luta(nome, preco, jogabilidade);

		} catch (DadoInvalidoException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	private Jogo criaPlataforma(String nome, double preco,
			HashSet<Jogabilidade> jogabilidade) {
		try {
			return new Plataforma(nome, preco, jogabilidade);

		} catch (DadoInvalidoException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Jogo criaJogo(String nome, double preco, String tipo,
			HashSet<Jogabilidade> jogabilidade) {
		if (tipo.equals("Plataforma")) {
			return criaPlataforma(nome, preco, jogabilidade);
		} else if (tipo.equals("RPG")) {
			return criaRPG(nome, preco, jogabilidade);
		} else if (tipo.equals("Luta")) {
			return criaLuta(nome, preco, jogabilidade);
		}
		return null;
	}

}
