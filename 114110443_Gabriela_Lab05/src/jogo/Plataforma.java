package jogo;

import java.util.HashSet;

import sistema.DadoInvalidoException;

public class Plataforma extends Jogo {

	public Plataforma(String nome, double preco,
			HashSet<Jogabilidade> jogabilidade) throws DadoInvalidoException {
		super(nome, preco, jogabilidade);
	}

	@Override
	public void joga(int score, boolean zerou) {
		quantidadeJogada = quantidadeJogada + 1;
		if (zerou) {
			quantidadeZerada = quantidadeZerada + 1;
		}
		if (score > highScore) {
			highScore = score;
		}
		totalPontos = 20 * quantidadeZerada;
	}

	public String toString() {
		final String EOL = System.getProperty("line.separator");

		return "+ " + this.nome + " - Plataforma" + EOL + "==> Jogou "
				+ this.quantidadeJogada + " vez(es)" + EOL + "==> Zerou "
				+ this.quantidadeZerada + " vez(es)" + EOL
				+ "==> Maior score: " + this.highScore + EOL;
	}

}
