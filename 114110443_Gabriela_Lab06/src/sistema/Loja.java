package sistema;

//114110443 - Gabriela Motta Oliveira: LAB 06 - Turma 3

import java.util.ArrayList;
import java.util.Collections;

import jogo.Jogo;
import usuario.Noob;
import usuario.Usuario;
import usuario.Veterano;
import exceptions.ConversaoInvalidaException;
import exceptions.EntradaException;
import exceptions.LogicaException;
import exceptions.PontosIncompativeisException;

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

	public void ordenaUsuarios() {
		Collections.sort(usuarios);
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
