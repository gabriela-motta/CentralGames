package jogo;

//114110443 - Gabriela Motta Oliveira: LAB 05 - Turma 3

import java.util.HashSet;

import exceptions.EntradaException;

public class Luta extends Jogo {

	public Luta(String nome, double preco, HashSet<Jogabilidade> jogabilidade)
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
			pontosExtras = getHighScore() / 1000;
		}
		return pontosExtras;
	}

	public String toString() {
		final String EOL = System.getProperty("line.separator");

		return "+ " + getNome() + " - Luta" + EOL + "==> Jogou "
				+ getQuantidadeJogada() + " vez(es)" + EOL + "==> Zerou "
				+ getQuantidadeZerada() + " vez(es)" + EOL
				+ "==> Maior score: " + getHighScore() + EOL;
	}

}
