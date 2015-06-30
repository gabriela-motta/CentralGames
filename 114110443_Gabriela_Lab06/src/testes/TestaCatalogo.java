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

import usuario.CatalogoJogos;
import usuario.TiposOrdenacao;

public class TestaCatalogo {

	private CatalogoJogos catalogo;
	private Jogo jogo1;
	private Jogo jogo2;
	private Jogo jogo3;
	private HashSet<Jogabilidade> j1;
	private HashSet<Jogabilidade> j2;
	private HashSet<Jogabilidade> j3;

	@Before
	public void setUp() {
		try {
			catalogo = new CatalogoJogos();

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

			jogo1.joga(10000, false);
			jogo2.joga(200, false);
			jogo2.joga(250, false);
			jogo3.joga(999, true);

			catalogo.adicionaJogo(jogo1);
			catalogo.adicionaJogo(jogo2);
			catalogo.adicionaJogo(jogo3);

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testAdicionaJogo() {
		try {
			Assert.assertEquals(3, catalogo.getListaJogos().size());

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testRemoveJogo() {
		try {
			catalogo.removeJogo(jogo1);
			Assert.assertEquals(2, catalogo.getListaJogos().size());

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testRetornaMaiorScore() {
		Assert.assertEquals(jogo1.toString(), catalogo.retornaMaiorScore());
	}

	@Test
	public void testRetornaMaisJogado() {
		Assert.assertEquals(jogo2.toString(), catalogo.retornaMaisJogado());
	}

	@Test
	public void testRetornaMaisZerado() {
		Assert.assertEquals(jogo3.toString(), catalogo.retornaMaisZerado());
	}

	@Test
	public void testRetornaJogabilidade() {
		try {
			Assert.assertTrue(catalogo.retornaJogabilidade(
					Jogabilidade.COMPETITIVO).contains(jogo1));
			Assert.assertTrue(catalogo.retornaJogabilidade(
					Jogabilidade.COMPETITIVO).contains(jogo2));

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaOrdenaJogos() {
		try {
			catalogo.ordenaJogos(TiposOrdenacao.DEFAULT);
			Assert.assertEquals(jogo1, catalogo.getListaJogos().get(0));
			Assert.assertEquals(jogo2, catalogo.getListaJogos().get(1));
			Assert.assertEquals(jogo3, catalogo.getListaJogos().get(2));

			catalogo.ordenaJogos(TiposOrdenacao.VICIO);
			Assert.assertEquals(jogo1, catalogo.getListaJogos().get(0));
			Assert.assertEquals(jogo3, catalogo.getListaJogos().get(1));
			Assert.assertEquals(jogo2, catalogo.getListaJogos().get(2));

			catalogo.ordenaJogos(TiposOrdenacao.EXPERIENCIA);
			Assert.assertEquals(jogo1, catalogo.getListaJogos().get(0));
			Assert.assertEquals(jogo2, catalogo.getListaJogos().get(1));
			Assert.assertEquals(jogo3, catalogo.getListaJogos().get(2));

			catalogo.ordenaJogos(TiposOrdenacao.DESEMPENHO);
			Assert.assertEquals(jogo2, catalogo.getListaJogos().get(0));
			Assert.assertEquals(jogo3, catalogo.getListaJogos().get(1));
			Assert.assertEquals(jogo1, catalogo.getListaJogos().get(2));

		} catch (Exception e) {
			Assert.fail();
		}
	}

}
