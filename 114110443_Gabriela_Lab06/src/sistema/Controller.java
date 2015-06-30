package sistema;

//114110443 - Gabriela Motta Oliveira: LAB 06 - Turma 3

import java.util.HashSet;

import jogo.Jogabilidade;
import jogo.Jogo;
import jogo.JogoFactory;
import usuario.Usuario;
import exceptions.EntradaException;

public class Controller {
	private JogoFactory fabricaDeJogos;
	private Loja loja;

	public Controller() {
		this.fabricaDeJogos = new JogoFactory();
		this.loja = new Loja();
	}

	public void criaUsuario(String nome, String login) throws EntradaException {
		Usuario novo = new Usuario(nome, login);
		this.loja.adicionaUsuario(novo);
	}

	private Jogo criaJogo(String nomeJogo, double precoJogo, String tipo,
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

	public Usuario[] top5() {
		int tamanho = this.loja.getUsuarios().size();
		Usuario[] tops = new Usuario[5];
		this.loja.ordenaUsuarios();
		for (int i = tamanho - 5; i == tamanho; i++) {
			tops[i] = this.loja.getUsuarios().get(i);
		}
		return tops;
	}
}
