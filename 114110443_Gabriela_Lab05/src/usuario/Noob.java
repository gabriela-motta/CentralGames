package usuario;

public class Noob extends Usuario {

	public Noob(String nome, String login) {
		super(nome, login);
	}

	@Override
	public double disconto(double preco) {
		double percentual = 0.1;
		double aPagar = preco - (preco * percentual);
		return aPagar;
	}

}
