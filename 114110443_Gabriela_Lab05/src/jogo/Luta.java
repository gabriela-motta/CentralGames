package jogo;

import java.util.HashSet;

import exceptions.DadoInvalidoException;

public class Luta extends Jogo {

	public Luta(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws DadoInvalidoException {
		super(nome, preco, jogabilidade);
	}

}
