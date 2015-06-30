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
	public int ganhouPartida(Jogo jogo, int score, boolean zerou) {
		int pontos = 0;
		pontos = pontos + jogo.joga(score, zerou);

		if (jogo.getJogabilidade().contains(Jogabilidade.ONLINE)) {
			pontos = pontos + 10;
		}
		if (jogo.getJogabilidade().contains(Jogabilidade.COOPERATIVO)) {
			pontos = pontos + 20;
		}
		return pontos;
	}

	@Override
	public int perdeuPartida(Jogo jogo, int score, boolean zerou) {
		int pontos = 0;
		pontos = pontos + jogo.joga(score, zerou);

		if (jogo.getJogabilidade().contains(Jogabilidade.COMPETITIVO)) {
			pontos = pontos - 10;
		}
		if (jogo.getJogabilidade().contains(Jogabilidade.COOPERATIVO)) {
			pontos = pontos - 20;
		}
		return pontos;
	}

	@Override
	public String toString() {
		return "Jogador Veterano: ";
	}
}
