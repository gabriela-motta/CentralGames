package testes;

//114110443 - Gabriela Motta Oliveira: LAB 06 - Turma 3

import java.util.HashSet;

import jogo.Jogabilidade;
import jogo.Jogo;
import jogo.Luta;
import jogo.Plataforma;
import jogo.RPG;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exceptions.EntradaException;
import usuario.Noob;
import usuario.Usuario;
import usuario.Veterano;

public class TestaUsuario {

	private Usuario user1;
	private Usuario user2;
	private Usuario user3;
	private Usuario user4;
	private Jogo jogo1;
	private Jogo jogo2;
	private Jogo jogo3;
	private HashSet<Jogabilidade> j1;
	private HashSet<Jogabilidade> j2;
	private HashSet<Jogabilidade> j3;

	@Before
	public void setUp() {
		try {
			user1 = new Usuario("Maria", "m123");
			user2 = new Usuario("Joao", "j123");

			j1 = new HashSet<>();
			j1.add(Jogabilidade.COMPETITIVO);
			j1.add(Jogabilidade.OFFLINE);
			jogo1 = new Plataforma("Burrito", 100, j1);

			j2 = new HashSet<>();
			j2.add(Jogabilidade.ONLINE);
			j2.add(Jogabilidade.MULTIPLAYER);
			j2.add(Jogabilidade.COMPETITIVO);
			jogo2 = new Luta("Fight", 50.0, j2);

			j3 = new HashSet<>();
			j3.add(Jogabilidade.COOPERATIVO);
			j3.add(Jogabilidade.MULTIPLAYER);
			jogo3 = new RPG("Medieval", 70, j3);

		} catch (EntradaException e) {
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
			Assert.assertEquals(0.0, user1.getTotalGasto(), 0.1);

			Assert.assertEquals("Joao", user2.getNome());
			Assert.assertEquals("j123", user2.getLogin());
			Assert.assertEquals(0.0, user2.getQuantidadeDinheiro(), 0.1);
			Assert.assertEquals(0, user2.getX2p());
			Assert.assertEquals(0.0, user2.getTotalGasto(), 0.1);

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaUsuarioInvalido() {
		try {
			user3 = new Usuario("", "abc");
			Assert.fail("Esperava excecao de dado invalido");

		} catch (EntradaException e) {
			Assert.assertEquals("String especificada e invalida",
					e.getMessage());
		}

		try {
			user4 = new Usuario("Fulano", "");
			Assert.fail("Esperava excecao de dado invalido");

		} catch (EntradaException e) {
			Assert.assertEquals("String especificada e invalida",
					e.getMessage());
		}
	}

	@Test
	public void testaGanhouPartida() {
		try {
			user1.adicionaJogo(jogo2);
			user1.ganhouPartida("Fight", 4000, false);
			Assert.assertEquals(514, user1.getX2p());
			Assert.assertTrue(user1.getJogador() instanceof Noob);

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaPerdeuPartida() {
		try {
			user1.adicionaJogo(jogo1);
			user1.perdeuPartida("Burrito", 500, true);
			Assert.assertEquals(1010, user1.getX2p());
			Assert.assertTrue(user1.getJogador() instanceof Veterano);

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaAdicionaJogo() {
		try {
			user1.setQuantidadeDinheiro(250);
			user1.adicionaJogo(jogo1);
			Assert.assertEquals(100, user1.getTotalGasto(), 0.1);
			Assert.assertEquals(1, user1.getJogosComprados().size());
			Assert.assertEquals(150, user1.getQuantidadeDinheiro(), 0.1);
			Assert.assertEquals(1000, user1.getX2p());
			Assert.assertTrue(user1.getJogador() instanceof Veterano);

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaCalculaPreco() {
		try {
			Assert.assertEquals(90.0, user1.calculaPreco(100), 0.1);

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaToString() {
		try {
			user1.setQuantidadeDinheiro(2500);
			user1.adicionaJogo(jogo1);
			user1.adicionaJogo(jogo2);

			user1.perdeuPartida("Burrito", 500, true);
			user1.ganhouPartida("Fight", 4000, false);

			final String EOL = System.getProperty("line.separator");
			String mensagemJogos = "";
			for (Jogo j : user1.getJogosComprados()) {
				mensagemJogos = mensagemJogos + j.toString() + EOL;
			}
			String mensagem = "m123" + EOL + "Maria" + EOL
					+ "Jogador Veterano: 1524 x2p" + EOL + "Lista de Jogos:"
					+ EOL + mensagemJogos
					+ "Total de preco dos jogos: R$ 150.0" + EOL;
			Assert.assertEquals(mensagem, user1.toString());

		} catch (Exception e) {
			Assert.fail();
		}
	}
}
