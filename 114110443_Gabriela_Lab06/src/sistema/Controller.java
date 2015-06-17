package sistema;

//114110443 - Gabriela Motta Oliveira: LAB 06 - Turma 3

import java.util.HashSet;

import jogo.Jogabilidade;
import jogo.Jogo;
import jogo.JogoFactory;
import usuario.Usuario;
import usuario.UsuarioFactory;
import exceptions.EntradaException;

public class Controller {
	private UsuarioFactory fabricaDeUsuarios;
	private JogoFactory fabricaDeJogos;
	private Loja loja;

	public Controller() {
		this.fabricaDeUsuarios = new UsuarioFactory();
		this.fabricaDeJogos = new JogoFactory();
		this.loja = new Loja();
	}

	public void criaUsuario(String nome, String login, String tipo)
			throws EntradaException {
		Usuario novo = this.fabricaDeUsuarios.criaUsuario(nome, login, tipo);
		this.loja.adicionaUsuario(novo);
	}

	public Jogo criaJogo(String nomeJogo, double precoJogo, String tipo,
			HashSet<Jogabilidade> jogabilidades) throws EntradaException {
		return this.fabricaDeJogos.criaJogo(nomeJogo, precoJogo, tipo,
				jogabilidades);
	}

	public void vendeJogo(String nomeUsuario, String nomeJogo, String tipoJogo,
			double precoJogo, HashSet<Jogabilidade> jogabilidades)
			throws EntradaException {
		for (Usuario user : this.loja.getUsuarios()) {
			if (user.getNome().equals(nomeUsuario)) {
				if (user.getQuantidadeDinheiro() >= precoJogo) {
					Jogo novoJogo = criaJogo(nomeJogo, precoJogo, tipoJogo,
							jogabilidades);
					user.adicionaJogo(novoJogo);
					this.loja.aumentaTotalArrecadado(user
							.calculaPreco(precoJogo));
				}
			}
		}
	}

	public void adicionaDinheiro(String nome, double valor) {
		this.loja.adicionaDinheiro(nome, valor);
	}

}
