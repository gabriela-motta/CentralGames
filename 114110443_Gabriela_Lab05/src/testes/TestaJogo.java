package testes;

import jogo.Jogo;
import jogo.Plataforma;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaJogo {

	private Jogo jogo2;

	@Before
	public void setUp() {
		jogo2 = new Plataforma("Jetpack Run", 2.0);
	}

	@Test
	public void testConstrutor() {
		try {
			Assert.assertEquals("Jetpack Run", jogo2.getNome());
			Assert.assertEquals(2.0, jogo2.getPreco(), 0.001);

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaJoga() {
		try {			
			jogo2.joga(100, false);
			Assert.assertEquals(100, jogo2.getHighScore());
			Assert.assertEquals(0, jogo2.getQuantidadeZerada());
			
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
