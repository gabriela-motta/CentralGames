package sistema;

import java.util.ArrayList;
import java.util.HashSet;

import jogo.Jogabilidade;
import jogo.Jogo;
import jogo.JogoFactory;
import usuario.Noob;
import usuario.Usuario;
import usuario.Veterano;

public class Loja {

	private ArrayList<Usuario> usuarios;
	private double totalArrecadado;
	private JogoFactory fabricaDeJogos;

	public Loja() {
		this.usuarios = new ArrayList<Usuario>();
		this.totalArrecadado = 0;
		this.fabricaDeJogos = new JogoFactory();
	}

	public void criaUsuario(String nome, String login, String tipo) {
		try {
			if (tipo.equals("Noob")) {
				Usuario novo = new Noob(nome, login);
				this.usuarios.add(novo);

			} else if (tipo.equals("Veterano")) {
				Usuario novo = new Veterano(nome, login);
				this.usuarios.add(novo);
			}

		} catch (DadoInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}

	public Jogo criaJogo(String nome, double preco, String tipo,
			HashSet<Jogabilidade> jogabilidades) {
		return fabricaDeJogos.criaJogo(nome, preco, tipo, jogabilidades);
	}

	public void vendeJogo(String nomeUsuario, String nomeJogo, String tipoJogo,
			double precoJogo, HashSet<Jogabilidade> jogabilidades) {
		try {
			for (Usuario user : usuarios) {
				if (user.getNome().equals(nomeUsuario)) {
					if (user.getQuantidadeDinheiro() >= precoJogo) {
						Jogo novoJogo = criaJogo(nomeJogo, precoJogo, tipoJogo,
								jogabilidades);
						user.adicionaJogo(novoJogo);
						this.totalArrecadado = this.totalArrecadado
								+ user.calculaPreco(precoJogo);
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void adicionaDinheiro(String nome, double valor) {
		for (Usuario user : usuarios) {
			if (user.getNome().equals(nome)) {
				double quantia = user.getQuantidadeDinheiro() + valor;
				user.setQuantidadeDinheiro(quantia);
			}
		}
	}

	public String toString() {
		final String EOL = System.getProperty("line.separator");
		String mensagemUsuarios = "";
		for (Usuario u : usuarios) {
			mensagemUsuarios = mensagemUsuarios + u.toString() + EOL;
		}

		return "=== Central P2-CG ===" + EOL + mensagemUsuarios
				+ "-------------------------------" + EOL
				+ "Total arrecadado com vendas de jogos: R$ "
				+ this.totalArrecadado;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public double getTotalArrecadado() {
		return totalArrecadado;
	}

	public void setTotalArrecadado(double totalArrecadado) {
		this.totalArrecadado = totalArrecadado;
	}
}
