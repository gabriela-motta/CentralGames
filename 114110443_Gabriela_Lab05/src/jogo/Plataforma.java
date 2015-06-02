package jogo;

import java.util.HashSet;

import exceptions.DadoInvalidoException;

public class Plataforma extends Jogo {

	public Plataforma(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws DadoInvalidoException {
		super(nome, preco, jogabilidade);
	}

}
