package testes;

import java.util.HashSet;

import jogo.Jogabilidade;
import jogo.Plataforma;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sistema.Loja;
import usuario.Usuario;

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
			loja1.vendeJogo("Maria", "Burrito", "Plataforma", 100, j1);
			Assert.assertEquals(90, loja1.getTotalArrecadado(), 0.1);

			loja1.criaUsuario("Joao", "j123", "Veterano");
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
	public void testaToString() {
		try {
			loja1.criaUsuario("Maria", "m123", "Noob");
			loja1.vendeJogo("Maria", "Burrito", "Plataforma", 100, j1);

			final String EOL = System.getProperty("line.separator");
			String mensagem = "=== Central P2-CG ===" + EOL
					+ loja1.getUsuarios() + EOL
					+ "-------------------------------" + EOL
					+ "Total arrecadado com vendas de jogos: R$ 90.0";
			Assert.assertEquals(mensagem, loja1.toString());

		} catch (Exception e) {
			Assert.fail();
		}
	}
}
