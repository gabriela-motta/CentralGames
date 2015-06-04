package testes;

import java.util.HashSet;

import jogo.Jogabilidade;
import jogo.Jogo;
import jogo.Luta;
import jogo.Plataforma;
import jogo.RPG;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sistema.DadoInvalidoException;

public class TestaJogo {

	private Jogo jogo1;
	private Jogo jogo2;
	private Jogo jogo3;
	private Jogo jogo4;
	private Jogo jogo5;
	private HashSet<Jogabilidade> j1;
	private HashSet<Jogabilidade> j2;
	private HashSet<Jogabilidade> j3;

	@Before
	public void setUp() {
		try {
			j1 = new HashSet<>();
			j1.add(Jogabilidade.ONLINE);
			jogo1 = new Plataforma("Burrito", 100, j1);

			j2 = new HashSet<>();
			j2.add(Jogabilidade.COMPETITIVO);
			jogo2 = new Luta("Fight", 50.0, j2);

			j3 = new HashSet<>();
			j3.add(Jogabilidade.COOPERATIVO);
			jogo3 = new RPG("Medieval", 70, j3);

		} catch (DadoInvalidoException e) {
			Assert.fail();
		}
	}

	@Test
	public void testaConstrutor() {
		try {
			Assert.assertEquals("Burrito", jogo1.getNome());
			Assert.assertEquals(100, jogo1.getPreco(), 0.1);
			Assert.assertEquals(j1, jogo1.getJogabilidade());
			Assert.assertEquals(0, jogo1.getTotalPontos());

			Assert.assertEquals("Fight", jogo2.getNome());
			Assert.assertEquals(50, jogo2.getPreco(), 0.1);
			Assert.assertEquals(j2, jogo2.getJogabilidade());
			Assert.assertEquals(0, jogo2.getTotalPontos());

			Assert.assertEquals("Medieval", jogo3.getNome());
			Assert.assertEquals(70, jogo3.getPreco(), 0.1);
			Assert.assertEquals(j3, jogo3.getJogabilidade());
			Assert.assertEquals(0, jogo3.getTotalPontos());

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaJogoInvalido() {
		try {
			jogo4 = new Plataforma("", 10, j2);
			Assert.fail("Esperava excecao de dado invalido");

		} catch (DadoInvalidoException e) {
			Assert.assertEquals("Nome nao pode ser vazio", e.getMessage());
		}

		try {
			jogo5 = new RPG("Castle", -1, j3);
			Assert.fail("Esperava excecao de dado invalido");

		} catch (DadoInvalidoException e) {
			Assert.assertEquals("Preco nao pode ser negativo", e.getMessage());
		}
	}

	@Test
	public void testaJoga() {
		try {
			jogo1.joga(600, false);
			Assert.assertEquals(1, jogo1.getQuantidadeJogada());
			Assert.assertEquals(600, jogo1.getHighScore());
			Assert.assertEquals(0, jogo1.getQuantidadeZerada());
			Assert.assertEquals(0, jogo1.getTotalPontos());

			jogo1.joga(200, true);
			Assert.assertEquals(2, jogo1.getQuantidadeJogada());
			Assert.assertEquals(600, jogo1.getHighScore());
			Assert.assertEquals(1, jogo1.getQuantidadeZerada());
			Assert.assertEquals(20, jogo1.getTotalPontos());

			jogo1.joga(601, false);
			Assert.assertEquals(3, jogo1.getQuantidadeJogada());
			Assert.assertEquals(601, jogo1.getHighScore());
			Assert.assertEquals(1, jogo1.getQuantidadeZerada());
			Assert.assertEquals(20, jogo1.getTotalPontos());
			
			jogo2.joga(3000, false);
			Assert.assertEquals(3, jogo2.getTotalPontos());
			
			jogo2.joga(4000, false);
			Assert.assertEquals(7, jogo2.getTotalPontos());
			
			jogo3.joga(400, false);
			Assert.assertEquals(10, jogo3.getTotalPontos());
			
			jogo3.joga(200, true);
			Assert.assertEquals(20, jogo3.getTotalPontos());

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaToString() {
		try {
			jogo1.joga(100, true);

			final String EOL = System.getProperty("line.separator");
			String mensagem = "+ Burrito - Plataforma" + EOL
					+ "==> Jogou 1 vez(es)" + EOL + "==> Zerou 1 vez(es)" + EOL
					+ "==> Maior score: 100" + EOL;
			Assert.assertEquals(mensagem, jogo1.toString());

		} catch (Exception e) {
			Assert.fail();
		}
	}

}
