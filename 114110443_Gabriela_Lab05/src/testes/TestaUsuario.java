package testes;

import java.util.HashSet;

import jogo.Jogabilidade;
import jogo.Jogo;
import jogo.Plataforma;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sistema.DadoInvalidoException;
import usuario.Noob;
import usuario.Usuario;
import usuario.Veterano;

public class TestaUsuario {

	private Usuario user1;
	private Usuario user2;
	private Usuario user3;
	private Usuario user4;
	private Jogo jogo1;
	private HashSet<Jogabilidade> j1;

	@Before
	public void setUp() {
		try {
			user1 = new Noob("Maria", "m123");
			user2 = new Veterano("Joao", "j123");

			j1 = new HashSet<>();
			j1.add(Jogabilidade.ONLINE);
			jogo1 = new Plataforma("Burrito", 100, j1);

		} catch (DadoInvalidoException e) {
			Assert.fail();
		}
	}

	@Test
	public void testaConstrutor() {
		try {
			Assert.assertEquals("Maria", user1.getNome());
			Assert.assertEquals("m123", user1.getLogin());
			Assert.assertEquals(0.0, user1.getQuantidadeDinheiro(), 0.1);
			Assert.assertEquals(0, user1.getX2p());
			Assert.assertEquals(0.0, user1.getTotalPreco(), 0.1);

			Assert.assertEquals("Joao", user2.getNome());
			Assert.assertEquals("j123", user2.getLogin());
			Assert.assertEquals(0.0, user2.getQuantidadeDinheiro(), 0.1);
			Assert.assertEquals(0, user2.getX2p());
			Assert.assertEquals(0.0, user2.getTotalPreco(), 0.1);

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaUsuarioInvalido() {
		try {
			user3 = new Noob("", "abc");
			Assert.fail("Esperava excecao de dado invalido");

		} catch (DadoInvalidoException e) {
			Assert.assertEquals("Nome nao pode ser vazio", e.getMessage());
		}

		try {
			user4 = new Veterano("Fulano", "");
			Assert.fail("Esperava excecao de dado invalido");

		} catch (DadoInvalidoException e) {
			Assert.assertEquals("Login nao pode ser vazio", e.getMessage());
		}
	}

	@Test
	public void testaCalculaPreco() {
		try {
			Assert.assertEquals(90.0, user1.calculaPreco(100), 0.1);
			Assert.assertEquals(80.0, user2.calculaPreco(100), 0.1);

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaAdicionaJogo() {
		try {
			user1.setQuantidadeDinheiro(250);
			jogo1.joga(120, true);
			user1.adicionaJogo(jogo1);
			Assert.assertEquals(100, user1.getTotalPreco(), 0.1);
			Assert.assertEquals(1, user1.getJogosComprados().size());
			Assert.assertEquals(150, user1.getQuantidadeDinheiro(), 0.1);
			Assert.assertEquals(1020, user1.getX2p());

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaToString() {
		try {
			user1.setQuantidadeDinheiro(250);
			jogo1.joga(120, true);
			user1.adicionaJogo(jogo1);

			final String EOL = System.getProperty("line.separator");
			String mensagem = "m123" + EOL + "Maria" + EOL
					+ "Jogador Noob: 1020 x2p" + EOL + "Lista de Jogos:" + EOL
					+ user1.getJogosComprados() + EOL
					+ "Total de preco dos jogos: R$ 100.0" + EOL;
			Assert.assertEquals(mensagem, user1.toString());

		} catch (Exception e) {
			Assert.fail();
		}
	}
}
