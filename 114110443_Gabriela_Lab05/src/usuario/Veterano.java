package usuario;

import sistema.DadoInvalidoException;

public class Veterano extends Usuario {

	public static final double PERCENTUAL = 0.2;

	public Veterano(String nome, String login) throws DadoInvalidoException {
		super(nome, login);
	}

	@Override
	public double calculaPreco(double preco) {
		double aPagar = preco - (preco * PERCENTUAL);
		return aPagar;
	}

	@Override
	public String toString() {
		final String EOL = System.getProperty("line.separator");

		return this.login + EOL + this.nome + EOL + "Jogador Veterano: "
				+ this.x2p + " x2p" + EOL + "Lista de Jogos:" + EOL
				+ this.getJogosComprados() + EOL
				+ "Total de preco dos jogos: R$ " + this.totalPreco + EOL;
	}

}
