package usuario;

import jogo.Jogo;

public abstract class Jogador {

	private int x2p;

	public Jogador() {
		this.x2p = 0;
	}

	public abstract double calculaPreco(double preco);

	/**
	 * Recompensa o usuario adicionando x2p de acordo com a jogabilidade do jogo
	 * 
	 * @param nomeJogo
	 *            O nome do jogo
	 */
	public abstract void ganhouPartida(Jogo jogo, int score, boolean zerou);

	/**
	 * Pune o usuario removendo x2p de acordo com a jogabilidade do jogo
	 * 
	 * @param nomeJogo
	 *            O nome do jogo
	 */
	public abstract void perdeuPartida(Jogo jogo, int score, boolean zerou);

	@Override
	public String toString() {
		return "Jogador: " + this.x2p + " x2p";
	}

	public int getX2p() {
		return x2p;
	}

	public void setX2p(int x2p) {
		this.x2p = x2p;
	}

}
