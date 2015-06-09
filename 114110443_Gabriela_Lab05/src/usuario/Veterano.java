package usuario;

//114110443 - Gabriela Motta Oliveira: LAB 05 - Turma 3

import jogo.Jogabilidade;
import jogo.Jogo;
import sistema.EntradaException;

public class Veterano extends Usuario {

	public static final double DESCONTO = 0.2;

	public Veterano(String nome, String login) throws EntradaException {
		super(nome, login);
	}

	public double calculaPreco(double preco) {
		double aPagar = preco - (preco * DESCONTO);
		return aPagar;
	}

	public int recompensar(String nomeJogo) {
		int pontos = 0;
		for (Jogo jogo : getJogosComprados()) {
			if (jogo.getNome().equals(nomeJogo)) {
				if (jogo.getJogabilidade().contains(Jogabilidade.ONLINE)) {
					pontos = pontos + 10;
				}
				if (jogo.getJogabilidade().contains(Jogabilidade.COOPERATIVO)) {
					pontos = pontos + 20;
				}
			}
		}
		return pontos;
	}

	public int punir(String nomeJogo) {
		int pontos = 0;
		for (Jogo jogo : getJogosComprados()) {
			if (jogo.getNome().equals(nomeJogo)) {
				if (jogo.getJogabilidade().contains(Jogabilidade.COMPETITIVO)) {
					pontos = pontos - 10;
				}
				if (jogo.getJogabilidade().contains(Jogabilidade.COOPERATIVO)) {
					pontos = pontos - 20;
				}
			}
		}
		return pontos;
	}

	public String toString() {
		final String EOL = System.getProperty("line.separator");

		String mensagemJogos = "";
		for (Jogo j : getJogosComprados()) {
			mensagemJogos = mensagemJogos + j.toString() + EOL;
		}

		return getLogin() + EOL + getNome() + EOL + "Jogador Veterano: "
				+ getX2p() + " x2p" + EOL + "Lista de Jogos:" + EOL
				+ mensagemJogos + "Total de preco dos jogos: R$ "
				+ getTotalGasto() + EOL;
	}

}
