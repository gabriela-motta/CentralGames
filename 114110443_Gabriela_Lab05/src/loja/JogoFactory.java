package loja;

import jogo.Jogo;
import jogo.Luta;
import jogo.Plataforma;
import jogo.RPG;

public class JogoFactory {
	
	private Jogo criaRPG(String nome, double preco){
		return new RPG(nome, preco);
	}
	
	private Jogo criaLuta(String nome, double preco){
		return new Luta(nome, preco);
	}
	
	private Jogo criaPlataforma(String nome, double preco){
		return new Plataforma(nome, preco);
	}
	
	public Jogo criaJogo(String nome, double preco, String tipo){
		if (tipo.equals("Plataforma")){                            
			return criaPlataforma(nome, preco);
		} else if (tipo.equals("RPG")){
			return criaRPG(nome, preco);
		} else if (tipo.equals("Luta")){
			return criaLuta(nome, preco);
		}
		return null;
	}

}
