package usuario;

//114110443 - Gabriela Motta Oliveira: LAB 06 - Turma 3

import java.util.ArrayList;

import jogo.Jogabilidade;
import jogo.Jogo;

public class CatalogoJogos {

	private ArrayList<Jogo> listaJogos;

	public CatalogoJogos() {
		this.listaJogos = new ArrayList<Jogo>();
	}

	public void adicionaJogo(Jogo jogo) {
		this.listaJogos.add(jogo);
	}

	public void removeJogo(Jogo jogo) {
		this.listaJogos.remove(jogo);
	}

	public String retornaMaiorScore() {
		String retorno = "";
		int score = 0;
		for (Jogo j : listaJogos) {
			if (j.getHighScore() >= score) {
				retorno = j.toString();
				score = j.getHighScore();
			}
		}
		return retorno;
	}

	public String retornaMaisJogado() {
		String retorno = "";
		int jogadas = 0;
		for (Jogo j : listaJogos) {
			if (j.getQuantidadeJogada() >= jogadas) {
				retorno = j.toString();
				jogadas = j.getQuantidadeJogada();
			}
		}
		return retorno;
	}

	public String retornaMaisZerado() {
		String retorno = "";
		int zeradas = 0;
		for (Jogo j : listaJogos) {
			if (j.getQuantidadeZerada() >= zeradas) {
				retorno = j.toString();
				zeradas = j.getQuantidadeZerada();
			}
		}
		return retorno;
	}

	public ArrayList<Jogo> retornaJogabilidade(Jogabilidade jogabilidade) {
		ArrayList<Jogo> retorno = new ArrayList<Jogo>();
		for (Jogo j : this.listaJogos) {
			if (j.getJogabilidade().contains(jogabilidade)) {
				retorno.add(j);
			}
		}
		return retorno;
	}

	public ArrayList<Jogo> getListaJogos() {
		return listaJogos;
	}

	public void setListaJogos(ArrayList<Jogo> listaJogos) {
		this.listaJogos = listaJogos;
	}
}
