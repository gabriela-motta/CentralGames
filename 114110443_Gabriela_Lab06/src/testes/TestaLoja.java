package testes;

//114110443 - Gabriela Motta Oliveira: LAB 06 - Turma 3

import java.util.HashSet;

import jogo.Jogabilidade;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exceptions.EntradaException;
import sistema.Loja;
import usuario.Noob;
import usuario.Usuario;
import usuario.Veterano;

public class TestaLoja {

	private Loja loja1;
	private HashSet<Jogabilidade> j1;
	private Usuario user1;
	private Usuario user2;
	private Usuario user3;
	private Usuario user4;

	@Before
	public void setUp() {
		try {
			loja1 = new Loja();

			j1 = new HashSet<>();
			j1.add(Jogabilidade.ONLINE);

			user1 = new Usuario("Maria", "m123");
			user2 = new Usuario("Joao", "j123");
			user3 = new Usuario("Jose", "zezinho");
			user4 = new Usuario("Ana", "aninha");

		} catch (EntradaException e) {
			Assert.fail();
		}
	}

	@Test
	public void testaConstrutor() {
		Assert.assertEquals(0, loja1.getUsuarios().size());
		Assert.assertEquals(0, loja1.getTotalArrecadado(), 0.1);
	}

	@Test
	public void testaAdicionaUsuario() {
		loja1.adicionaUsuario(user3);
		loja1.adicionaUsuario(user4);
		Assert.assertEquals(2, loja1.getUsuarios().size());
	}

	@Test
	public void testaAdicionaDinheiro() {
		try {
			loja1.adicionaDinheiro("Maria", 250);
			for (Usuario user : loja1.getUsuarios()) {
				if (user.getNome().equals("Maria")) {
					Assert.assertEquals(250, user.getQuantidadeDinheiro(), 0.1);
				}
			}

			loja1.adicionaDinheiro("Maria", 100);
			for (Usuario user : loja1.getUsuarios()) {
				if (user.getNome().equals("Maria")) {
					Assert.assertEquals(350, user.getQuantidadeDinheiro(), 0.1);
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaAumentaTotalArrecadado() {
		loja1.aumentaTotalArrecadado(100);
		Assert.assertEquals(100, loja1.getTotalArrecadado(), 0.01);
	}

	@Test
	public void testaOrdenaUsuarios() {
		try {
			user1.setX2p(1000);
			user2.setX2p(300);
			user3.setX2p(1);
			user4.setX2p(800);

			loja1.adicionaUsuario(user1);
			loja1.adicionaUsuario(user2);
			loja1.adicionaUsuario(user3);
			loja1.adicionaUsuario(user4);

			loja1.ordenaUsuarios();
			Assert.assertEquals(user3, loja1.getUsuarios().get(0));
			Assert.assertEquals(user2, loja1.getUsuarios().get(1));
			Assert.assertEquals(user4, loja1.getUsuarios().get(2));
			Assert.assertEquals(user1, loja1.getUsuarios().get(3));

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaToString() {
		try {
			loja1.aumentaTotalArrecadado(100);
			loja1.adicionaUsuario(user1);

			final String EOL = System.getProperty("line.separator");

			String mensagemUsuarios = "";
			for (Usuario u : loja1.getUsuarios()) {
				mensagemUsuarios = mensagemUsuarios + u.toString() + EOL;
			}

			String mensagem = "=== Central P2-CG ===" + EOL + mensagemUsuarios
					+ "-------------------------------" + EOL
					+ "Total arrecadado com vendas de jogos: R$ 100.0";
			Assert.assertEquals(mensagem, loja1.toString());

		} catch (Exception e) {
			Assert.fail();
		}
	}
}
