package jogo;

//114110443 - Gabriela Motta Oliveira: LAB 06 - Turma 3

import java.util.HashSet;

import exceptions.DadoInvalidoException;
import exceptions.EntradaException;

public class JogoFactory {

	/**
	 * Cria um jogo do tipo RPG
	 * 
	 * @param nome
	 *            O nome do jogo
	 * @param preco
	 *            O preco do jogo
	 * @param jogabilidade
	 *            As jogabilidades do jogo
	 * @return Um jogo do tipo RPG
	 * @throws EntradaException
	 */
	private Jogo criaRPG(String nome, double preco,
			HashSet<Jogabilidade> jogabilidade) throws EntradaException {
		return new RPG(nome, preco, jogabilidade);

	}

	/**
	 * Cria um jogo do tipo Luta
	 * 
	 * @param nome
	 *            O nome do jogo
	 * @param preco
	 *            O preco do jogo
	 * @param jogabilidade
	 *            As jogabilidades do jogo
	 * @return Um jogo do tipo Luta
	 * @throws EntradaException
	 */
	private Jogo criaLuta(String nome, double preco,
			HashSet<Jogabilidade> jogabilidade) throws EntradaException {

		return new Luta(nome, preco, jogabilidade);

	}

	/**
	 * Cria um jogo do tipo Plataforma
	 * 
	 * @param nome
	 *            O nome do jogo
	 * @param preco
	 *            O preco do jogo
	 * @param jogabilidade
	 *            As jogabilidades do jogo
	 * @return Um jogo do tipo Plataforma
	 * @throws EntradaException
	 */
	private Jogo criaPlataforma(String nome, double preco,
			HashSet<Jogabilidade> jogabilidade) throws EntradaException {
		return new Plataforma(nome, preco, jogabilidade);

	}

	/**
	 * Cria um jogo usando um dos metodos especificos
	 * 
	 * @param nome
	 *            O nome do jogo a ser criado
	 * @param preco
	 *            O preco do jogo a ser criado
	 * @param tipo
	 *            O tipo do jogo a ser criado
	 * @param jogabilidade
	 *            As jogabilidades do jogo a ser criado
	 * @return O jogo criado
	 * @throws EntradaException
	 */
	public Jogo criaJogo(String nome, double preco, String tipo,
			HashSet<Jogabilidade> jogabilidade) throws EntradaException {
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
