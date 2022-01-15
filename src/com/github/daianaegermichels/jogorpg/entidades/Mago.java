package com.github.daianaegermichels.jogorpg.entidades;

public class Mago extends Jogador{


	public Mago(String nome, int sexo) {
		super(nome, sexo);
	}
	
	@Override
	public int getArma() {
		return ESCOLHA_ARMA;
	}


	@Override
	public void setArma(int armaJogador) {
		setArma(EscolhaArma(armaJogador));
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
//arma = livro , cajado
}
