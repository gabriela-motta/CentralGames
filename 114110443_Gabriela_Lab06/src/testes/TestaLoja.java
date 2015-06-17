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

			user1 = new Noob("Maria", "m123");
			user2 = new Veterano("Joao", "j123");
			user3 = new Noob("Jose", "zezinho");
			user4 = new Veterano("Ana", "aninha");
			
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
	public void testaAumentaTotalArrecadado(){
		loja1.aumentaTotalArrecadado(100);
		Assert.assertEquals(100, loja1.getTotalArrecadado(), 0.01);
	}

	@Test
	public void testaConverte() {
		try {
			loja1.adicionaUsuario(user1);

			for (Usuario user : loja1.getUsuarios()) {
				if (user.getNome().equals("Maria")) {
					loja1.converte(user, "Veterano");
				}
			}

			Assert.assertTrue(loja1.getUsuarios().get(0) instanceof Veterano);

		} catch (Exception e) {
			Assert.fail();
		}

		try {
			loja1.adicionaUsuario(user2);

			for (Usuario user : loja1.getUsuarios()) {
				if (user.getNome().equals("Joao")) {
					loja1.converte(user, "Noob");
				}
			}

			Assert.assertTrue(loja1.getUsuarios().get(1) instanceof Noob);

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaUpgrade() {
		try {
			loja1.adicionaUsuario(user1);

			for (Usuario user : loja1.getUsuarios()) {
				if (user.getNome().equals("Maria")) {
					user.setX2p(1000);
				}
			}

			loja1.upgrade("m123");
			Assert.assertTrue(loja1.getUsuarios().get(0) instanceof Veterano);

		} catch (Exception e) {
			Assert.fail();
		}

		try {
			loja1.adicionaUsuario(user2);

			for (Usuario user : loja1.getUsuarios()) {
				if (user.getNome().equals("Joao")) {
					user.setX2p(1000);
				}
			}

			loja1.upgrade("j123");
			Assert.fail("Esperava excecao de conversao invalida");

		} catch (Exception e) {
			Assert.assertEquals("Usuario ja e Veterano", e.getMessage());
		}

		try {
		loja1.adicionaUsuario(user3);

			for (Usuario user : loja1.getUsuarios()) {
				if (user.getNome().equals("Jose")) {
					user.setX2p(999);
				}
			}

			loja1.upgrade("zezinho");
			Assert.fail("Esperava excecao de pontos insuficientes");

		} catch (Exception e) {
			Assert.assertEquals("Pontos incompativeis para upgrade",
					e.getMessage());
		}
	}

	@Test
	public void testaDowngrade() {
		try {
			loja1.adicionaUsuario(user2);

			for (Usuario user : loja1.getUsuarios()) {
				if (user.getNome().equals("Joao")) {
					user.setX2p(999);
				}
			}

			loja1.downgrade("j123");
			Assert.assertTrue(loja1.getUsuarios().get(0) instanceof Noob);

		} catch (Exception e) {
			Assert.fail();
		}

		try {
			loja1.adicionaUsuario(user1);

			for (Usuario user : loja1.getUsuarios()) {
				if (user.getNome().equals("Maria")) {
					user.setX2p(1000);
				}
			}

			loja1.downgrade("m123");
			Assert.fail("Esperava excecao de conversao invalida");

		} catch (Exception e) {
			Assert.assertEquals("Usuario ja e Noob", e.getMessage());
		}

		try {
			loja1.adicionaUsuario(user4);

			for (Usuario user : loja1.getUsuarios()) {
				if (user.getNome().equals("Ana")) {
					user.setX2p(1001);
				}
			}

			loja1.downgrade("aninha");
			Assert.fail("Esperava excecao de pontos insuficientes");

		} catch (Exception e) {
			Assert.assertEquals("Pontos incompativeis para downgrade",
					e.getMessage());
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
