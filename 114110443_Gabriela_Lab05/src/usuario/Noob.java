package usuario;

//114110443 - Gabriela Motta Oliveira: LAB 05 - Turma 3

import jogo.Jogabilidade;
import jogo.Jogo;
import sistema.DadoInvalidoException;

public class Noob extends Usuario {

	private static final double DESCONTO = 0.1;

	public Noob(String nome, String login) throws DadoInvalidoException {
		super(nome, login);
	}

	public int recompensar(String nomeJogo) {
		int pontos = 0;
		for (Jogo jogo : getJogosComprados()) {
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

	public int punir(String nomeJogo) {
		int pontos = 0;
		for (Jogo jogo : getJogosComprados()) {
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

	public double calculaPreco(double preco) {
		double aPagar = preco - (preco * DESCONTO);
		return aPagar;
	}

	public String toString() {
		final String EOL = System.getProperty("line.separator");

		String mensagemJogos = "";
		for (Jogo j : getJogosComprados()) {
			mensagemJogos = mensagemJogos + j.toString() + EOL;
		}

		return getLogin() + EOL + getNome() + EOL + "Jogador Noob: " + getX2p()
				+ " x2p" + EOL + "Lista de Jogos:" + EOL + mensagemJogos
				+ "Total de preco dos jogos: R$ " + getTotalGasto() + EOL;
	}

}
