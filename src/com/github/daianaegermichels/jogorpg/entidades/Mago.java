package com.github.daianaegermichels.jogorpg.entidades;

public class Mago extends Jogador{


	public Mago(String nome, int sexo, int agilidade) {
		super(nome, sexo, agilidade);
	}
	
	@Override
	public int getArma() {
		return arma;
	}


	@Override
	public int setArma(int arma) {
		return this.arma = EscolhaArma(arma);
	}
	
	public int EscolhaArma(int arma) {//getArma ao inves do int arma??
		
		int armaJogador = 0;
		
		if(arma == 1) {
			System.out.println("Arma escolhida: Livro");
			return armaJogador = 5; //pontos da arma escolhida
		} else if (arma == 2) {
			System.out.println("Arma escolhida: Cajado");
			return armaJogador = 7;
		} else {
			System.out.println("Arma inválida");
			return armaJogador;
		}
		
	}

}
