package usuario;

//114110443 - Gabriela Motta Oliveira: LAB 06 - Turma 3

import jogo.Jogo;

public abstract class Jogador {

	public Jogador() {

	}

	public abstract double calculaPreco(double preco);

	/**
	 * Recompensa o usuario adicionando x2p de acordo com a jogabilidade do jogo
	 * 
	 * @param nomeJogo
	 *            O nome do jogo
	 */
	public abstract int ganhouPartida(Jogo jogo, int score, boolean zerou);

	/**
	 * Pune o usuario removendo x2p de acordo com a jogabilidade do jogo
	 * 
	 * @param nomeJogo
	 *            O nome do jogo
	 */
	public abstract int perdeuPartida(Jogo jogo, int score, boolean zerou);

	@Override
	public String toString() {
		return "Jogador";
	}
}
