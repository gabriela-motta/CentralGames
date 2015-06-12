package testes;

//114110443 - Gabriela Motta Oliveira: LAB 05 - Turma 3

import java.util.HashSet;

import jogo.Jogabilidade;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sistema.Loja;
import usuario.Noob;
import usuario.Usuario;
import usuario.Veterano;

public class TestaLoja {

	private Loja loja1;
	private HashSet<Jogabilidade> j1;

	@Before
	public void setUp() {
		loja1 = new Loja();
		j1 = new HashSet<>();
		j1.add(Jogabilidade.ONLINE);
	}

	@Test
	public void testaConstrutor() {
		try {
			Assert.assertEquals(0, loja1.getUsuarios().size());
			Assert.assertEquals(0, loja1.getTotalArrecadado(), 0.1);

		} catch (Exception e) {
			Assert.fail();
		}

	}

	@Test
	public void testaCriaUsuario() {
		try {
			loja1.criaUsuario("Maria", "m123", "Noob");
			Assert.assertEquals(1, loja1.getUsuarios().size());

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaVendeJogo() {
		try {
			loja1.criaUsuario("Maria", "m123", "Noob");
			loja1.adicionaDinheiro("Maria", 200);
			loja1.vendeJogo("Maria", "Burrito", "Plataforma", 100, j1);
			Assert.assertEquals(90, loja1.getTotalArrecadado(), 0.1);

			loja1.criaUsuario("Joao", "j123", "Veterano");
			loja1.adicionaDinheiro("Joao", 200);
			loja1.vendeJogo("Joao", "Burrito", "Plataforma", 100, j1);
			Assert.assertEquals(170, loja1.getTotalArrecadado(), 0.1);

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaAdicionaDinheiro() {
		try {
			loja1.criaUsuario("Maria", "m123", "Noob");
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
	public void testaConverte() {
		try {
			loja1.criaUsuario("Maria", "m123", "Noob");

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
			loja1.criaUsuario("Joao", "j123", "Veterano");

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
			loja1.criaUsuario("Maria", "m123", "Noob");

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
			loja1.criaUsuario("Joao", "j123", "Veterano");

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
			loja1.criaUsuario("Jose", "zezinho", "Noob");

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
			loja1.criaUsuario("Joao", "j123", "Veterano");

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
			loja1.criaUsuario("Maria", "m123", "Noob");

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
			loja1.criaUsuario("Jose", "zezinho", "Veterano");

			for (Usuario user : loja1.getUsuarios()) {
				if (user.getNome().equals("Jose")) {
					user.setX2p(1001);
				}
			}

			loja1.downgrade("zezinho");
			Assert.fail("Esperava excecao de pontos insuficientes");

		} catch (Exception e) {
			Assert.assertEquals("Pontos incompativeis para downgrade",
					e.getMessage());
		}
	}

	@Test
	public void testaToString() {
		try {
			loja1.criaUsuario("Maria", "m123", "Noob");
			loja1.adicionaDinheiro("Maria", 200);
			loja1.vendeJogo("Maria", "Burrito", "Plataforma", 100, j1);

			final String EOL = System.getProperty("line.separator");

			String mensagemUsuarios = "";
			for (Usuario u : loja1.getUsuarios()) {
				mensagemUsuarios = mensagemUsuarios + u.toString() + EOL;
			}

			String mensagem = "=== Central P2-CG ===" + EOL + mensagemUsuarios
					+ "-------------------------------" + EOL
					+ "Total arrecadado com vendas de jogos: R$ 90.0";
			Assert.assertEquals(mensagem, loja1.toString());

		} catch (Exception e) {
			Assert.fail();
		}
	}
}
