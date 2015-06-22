package usuario;

//114110443 - Gabriela Motta Oliveira: LAB 06 - Turma 3

import jogo.Jogabilidade;
import jogo.Jogo;

public class Veterano extends Jogador {

	public static final double DESCONTO = 0.2;

	public double calculaPreco(double preco) {
		double aPagar = preco - (preco * DESCONTO);
		return aPagar;
	}

	@Override
	public void ganhouPartida(Jogo jogo, int score, boolean zerou) {
		int pontos = getX2p();
		pontos = pontos + jogo.joga(score, zerou);

		if (jogo.getJogabilidade().contains(Jogabilidade.ONLINE)) {
			pontos = pontos + 10;
		}
		if (jogo.getJogabilidade().contains(Jogabilidade.COOPERATIVO)) {
			pontos = pontos + 20;
		}
		setX2p(pontos);
	}

	@Override
	public void perdeuPartida(Jogo jogo, int score, boolean zerou) {
		int pontos = getX2p();
		pontos = pontos + jogo.joga(score, zerou);

		if (jogo.getJogabilidade().contains(Jogabilidade.COMPETITIVO)) {
			pontos = pontos - 10;
		}
		if (jogo.getJogabilidade().contains(Jogabilidade.COOPERATIVO)) {
			pontos = pontos - 20;
		}
		setX2p(pontos);
	}

	public String toString() {
		return "Jogador Veterano: " + getX2p() + " x2p";
	}

}
