package comparacoes;

import java.util.Comparator;

import jogo.Jogo;

public class DesempenhoCompare implements Comparator<Jogo> {

	@Override
	public int compare(Jogo jogo1, Jogo jogo2) {
		if (jogo1.getHighScore() > jogo2.getHighScore()) {
			return 1;
		} else if (jogo1.getHighScore() == jogo2.getHighScore()) {
			return 0;
		} else {
			return -1;
		}
	}

}
