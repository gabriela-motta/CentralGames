package usuario;

import jogo.Jogabilidade;
import jogo.Jogo;
import sistema.DadoInvalidoException;

public class Noob extends Usuario {

	private static final double PERCENTUAL = 0.1;

	public Noob(String nome, String login) throws DadoInvalidoException {
		super(nome, login);
	}

	@Override
	public int recompensar(String nomeJogo) {
		int pontos = 0;
		for (Jogo jogo : jogosComprados) {
			if (jogo.getNome().equals(nomeJogo)) {
				if (jogo.getJogabilidade().contains(Jogabilidade.OFFLINE)) {
					pontos = pontos + 30;
				}
				if (jogo.getJogabilidade().contains(Jogabilidade.MULTIPLAYER)) {
					pontos = pontos + 10;
				}
			}
		}
		return pontos;
	}

	@Override
	public int punir(String nomeJogo) {
		int pontos = 0;
		for (Jogo jogo : jogosComprados) {
			if (jogo.getNome().equals(nomeJogo)) {
				if (jogo.getJogabilidade().contains(Jogabilidade.ONLINE)) {
					pontos = pontos - 10;
				}
				if (jogo.getJogabilidade().contains(Jogabilidade.COMPETITIVO)) {
					pontos = pontos - 20;
				}
				if (jogo.getJogabilidade().contains(Jogabilidade.COOPERATIVO)) {
					pontos = pontos - 50;
				}
			}
		}
		return pontos;
	}

	@Override
	public double calculaPreco(double preco) {
		double aPagar = preco - (preco * PERCENTUAL);
		return aPagar;
	}

	@Override
	public String toString() {
		final String EOL = System.getProperty("line.separator");

		String mensagemJogos = "";
		for (Jogo j : jogosComprados) {
			mensagemJogos = mensagemJogos + j.toString() + EOL;
		}

		return this.login + EOL + this.nome + EOL + "Jogador Noob: " + this.x2p
				+ " x2p" + EOL + "Lista de Jogos:" + EOL + mensagemJogos
				+ "Total de preco dos jogos: R$ " + this.totalGasto + EOL;
	}

}
