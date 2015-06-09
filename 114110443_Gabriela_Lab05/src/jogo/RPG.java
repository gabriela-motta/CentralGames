package jogo;

//114110443 - Gabriela Motta Oliveira: LAB 05 - Turma 3

import java.util.HashSet;

import sistema.EntradaException;

public class RPG extends Jogo {

	public RPG(String nome, double preco, HashSet<Jogabilidade> jogabilidade)
			throws EntradaException {
		super(nome, preco, jogabilidade);
	}

	public int joga(int score, boolean zerou) {
		int pontosExtras = 0;
		setQuantidadeJogada(getQuantidadeJogada() + 1);
		if (zerou) {
			setQuantidadeZerada(getQuantidadeZerada() + 1);
		}
		if (score > getHighScore()) {
			setHighScore(score);
		}
		pontosExtras = 10 * getQuantidadeJogada();
		return pontosExtras;
	}

	public String toString() {
		final String EOL = System.getProperty("line.separator");

		return "+ " + getNome() + " - RPG" + EOL + "==> Jogou "
				+ getQuantidadeJogada() + " vez(es)" + EOL + "==> Zerou "
				+ getQuantidadeZerada() + " vez(es)" + EOL
				+ "==> Maior score: " + getHighScore() + EOL;
	}
}
