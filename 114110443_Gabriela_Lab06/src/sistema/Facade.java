package sistema;

//114110443 - Gabriela Motta Oliveira: LAB 06 - Turma 3

import java.util.HashSet;

import jogo.Jogabilidade;

public class Facade {
	private Controller controller;

	public Facade() {
		this.controller = new Controller();
	}

	public void criaUsuario(String nome, String login) {
		try {
			this.controller.criaUsuario(nome, login);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void vendeJogo(String nomeUsuario, String nomeJogo, String tipoJogo,
			double precoJogo, HashSet<Jogabilidade> jogabilidades) {
		try {
			this.controller.vendeJogo(nomeUsuario, nomeJogo, tipoJogo,
					precoJogo, jogabilidades);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void adicionaDinheiro(String nome, double valor) {
		this.controller.adicionaDinheiro(nome, valor);
	}
}
