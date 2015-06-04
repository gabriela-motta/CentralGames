package jogo;

import java.util.HashSet;

import sistema.DadoInvalidoException;

public class RPG extends Jogo {

	public RPG(String nome, double preco, HashSet<Jogabilidade> jogabilidade)
			throws DadoInvalidoException {
		super(nome, preco, jogabilidade);
	}

	public int joga(int score, boolean zerou) {
		int pontosExtras = 0;
		quantidadeJogada = quantidadeJogada + 1;
		if (zerou) {
			quantidadeZerada = quantidadeZerada + 1;
		}
		if (score > highScore) {
			highScore = score;
		}
		pontosExtras = 10 * quantidadeJogada;
		return pontosExtras;
	}

	public String toString() {
		final String EOL = System.getProperty("line.separator");

		return "+ " + this.nome + " - RPG" + EOL + "==> Jogou "
				+ this.quantidadeJogada + " vez(es)" + EOL + "==> Zerou "
				+ this.quantidadeZerada + " vez(es)" + EOL
				+ "==> Maior score: " + this.highScore + EOL;
	}
}
