package sistema;

//114110443 - Gabriela Motta Oliveira: LAB 06 - Turma 3

import java.util.ArrayList;
import java.util.HashSet;

import exceptions.ConversaoInvalidaException;
import exceptions.EntradaException;
import exceptions.LogicaException;
import exceptions.PontosIncompativeisException;
import jogo.Jogabilidade;
import jogo.Jogo;
import jogo.JogoFactory;
import usuario.Noob;
import usuario.Usuario;
import usuario.Veterano;

public class Loja {

	private ArrayList<Usuario> usuarios;
	private double totalArrecadado;

	/**
	 * Construtor de Loja
	 */
	public Loja() {
		this.usuarios = new ArrayList<Usuario>();
		this.totalArrecadado = 0;
	}

	/**
	 * Adiciona um usuario na lista de usuarios
	 * 
	 * @param usuario
	 *            O usuario a ser adicionado
	 */
	public void adicionaUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	/**
	 * Adiciona dinheiro na conta de um usuario
	 * 
	 * @param nome
	 *            O nome do usuario
	 * @param valor
	 *            O valor a ser adicionado
	 */
	public void adicionaDinheiro(String nome, double valor) {
		for (Usuario user : usuarios) {
			if (user.getNome().equals(nome)) {
				double quantia = user.getQuantidadeDinheiro() + valor;
				user.setQuantidadeDinheiro(quantia);
			}
		}
	}

	/**
	 * Aumenta o total arrecadado pela loja
	 * 
	 * @param valor
	 *            O valor a ser adicionado no total arrecadado
	 */
	public void aumentaTotalArrecadado(double valor) {
		this.totalArrecadado = this.totalArrecadado + valor;
	}

	/**
	 * Converte o tipo do usuario, removendo a referencia antiga da lista de
	 * usuarios da loja, adicionando a nova referencia na lista de usuarios da
	 * loja e mantendo as informacoes do usuario
	 * 
	 * @param user
	 *            O usuario a ser convertido
	 * @param tipo
	 *            O novo tipo do usuario
	 */
	public void converte(Usuario user, String tipo) {
		try {
			Usuario novoUsuario;
			String nome = user.getNome();
			String login = user.getLogin();
			ArrayList<Jogo> jogosComprados = user.getJogosComprados();
			double totalGasto = user.getTotalGasto();
			double quantidadeDinheiro = user.getQuantidadeDinheiro();
			int x2p = user.getX2p();

			this.usuarios.remove(user);

			if (tipo.equals("Noob")) {
				novoUsuario = new Noob(nome, login);

				novoUsuario.setJogosComprados(jogosComprados);
				novoUsuario.setTotalGasto(totalGasto);
				novoUsuario.setQuantidadeDinheiro(quantidadeDinheiro);
				novoUsuario.setX2p(x2p);

				this.usuarios.add(novoUsuario);

			} else if (tipo.equals("Veterano")) {
				novoUsuario = new Veterano(nome, login);

				novoUsuario.setJogosComprados(jogosComprados);
				novoUsuario.setTotalGasto(totalGasto);
				novoUsuario.setQuantidadeDinheiro(quantidadeDinheiro);
				novoUsuario.setX2p(x2p);

				this.usuarios.add(novoUsuario);
			}

		} catch (EntradaException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Faz upgrade de Noob para Veterano
	 * 
	 * @param loginUsuario
	 *            O login do usuario a ser avaliado
	 * @throws ConversaoInvalidaException
	 *             Se o usuario ja for Veterano ou seus pontos forem
	 *             incompativeis com a conversao
	 */
	public void upgrade(String loginUsuario) throws LogicaException {
		for (Usuario user : usuarios) {
			if (user.getLogin().equals(loginUsuario)) {
				if (user instanceof Veterano) {
					throw new ConversaoInvalidaException(
							"Usuario ja e Veterano");

				} else if (user.getX2p() < 1000) {
					throw new PontosIncompativeisException(
							"Pontos incompativeis para upgrade");

				} else {
					converte(user, "Veterano");
				}
			}
		}
	}

	/**
	 * Faz downgrade de Veterano para Noob
	 * 
	 * @param loginUsuario
	 *            O login do usuario a ser avaliado
	 * @throws ConversaoInvalidaException
	 *             Se o usuario ja for Noob ou seus pontos forem incompativeis
	 *             com a conversao
	 */
	public void downgrade(String loginUsuario) throws LogicaException {
		for (Usuario user : usuarios) {
			if (user.getLogin().equals(loginUsuario)) {
				if (user instanceof Noob) {
					throw new ConversaoInvalidaException("Usuario ja e Noob");

				} else if (user.getX2p() > 1000) {
					throw new PontosIncompativeisException(
							"Pontos incompativeis para downgrade");

				} else {
					converte(user, "Noob");
				}
			}
		}
	}

	/**
	 * Retorna uma String com informacoes da loja
	 */
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

	// GETTERS E SETTERS
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
