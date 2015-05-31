package usuario;

public class Veterano extends Usuario {

	public Veterano(String nome, String login) {
		super(nome, login);
	}

	@Override
	public double disconto(double preco) {
		double percentual = 0.2;
		double aPagar = preco - (preco * percentual);
		return aPagar;
	}

}
