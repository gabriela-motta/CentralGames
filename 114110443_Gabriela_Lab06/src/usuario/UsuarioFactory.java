package usuario;

//114110443 - Gabriela Motta Oliveira: LAB 06 - Turma 3

import exceptions.EntradaException;

public class UsuarioFactory {

	/**
	 * Cria um usuario do tipo Noob
	 * 
	 * @param nome
	 *            O nome do usuario
	 * @param login
	 *            O login do usuario
	 * @return O usuario criado
	 * @throws EntradaException
	 */
	private Usuario criaNoob(String nome, String login) throws EntradaException {
		return new Noob(nome, login);
	}

	/**
	 * Cria um usuario do tipo Veterano
	 * 
	 * @param nome
	 *            O nome do usuario
	 * @param login
	 *            O login do usuario
	 * @return O usuario criado
	 * @throws EntradaException
	 */
	private Usuario criaVeterano(String nome, String login)
			throws EntradaException {
		return new Veterano(nome, login);
	}

	/**
	 * Cria um usuario usando um dos metodos especificos
	 * 
	 * @param nome
	 *            O nome do usuario
	 * @param login
	 *            O login do usuario
	 * @param tipo
	 *            O tipo do usuario
	 * @return O usuario criado
	 * @throws EntradaException
	 */
	public Usuario criaUsuario(String nome, String login, String tipo)
			throws EntradaException {
		if (tipo.equals("Noob")) {
			return this.criaNoob(nome, login);
		} else if (tipo.equals("Veterano")) {
			return this.criaVeterano(nome, login);
		}
		return null;
	}
}
