package jogo;

import java.util.HashSet;

import exceptions.DadoInvalidoException;

public class RPG extends Jogo {

	public RPG(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws DadoInvalidoException {
		super(nome, preco, jogabilidade);
	}

}
