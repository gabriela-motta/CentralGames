package testes;

import jogo.Jogo;
import jogo.Plataforma;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaJogo {

	private Jogo jogo1;
	private Jogo jogo2;

	@Before
	public void setUp() {
		jogo1 = new Jogo("Flappy Bird", 3.99);
		jogo2 = new Plataforma("Jetpack Run", 2.0);
	}

	@Test
	public void testConstrutor() {
		try {
			Assert.assertEquals("Flappy Bird", jogo1.getNome());
			Assert.assertEquals(3.99, jogo1.getPreco(), 0.001);

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaJoga() {
		try {
			jogo1.joga(100);
			Assert.assertEquals(1, jogo1.getQuantidadeJogada());
			
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
