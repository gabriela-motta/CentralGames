package comparacoes;

//114110443 - Gabriela Motta Oliveira: LAB 06 - Turma 3

import java.util.Comparator;

import jogo.Jogo;

public class VicioCompare implements Comparator<Jogo> {

	@Override
	public int compare(Jogo jogo1, Jogo jogo2) {
		if (jogo1.getQuantidadeJogada() > jogo2.getQuantidadeJogada()) {
			return 1;
		} else if (jogo1.getQuantidadeJogada() == jogo2.getQuantidadeJogada()) {
			return 0;
		} else {
			return -1;
		}
	}

}
