package com.github.daianaegermichels.jogorpg.entidades;

public class Guerreiro extends Jogador {

	public Guerreiro(String nome, int sexo, int agilidade) {
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
	

	public int EscolhaArma(int arma) {
		int armaJogador = 0;
		
		if(arma == 1) {
			System.out.println("Arma escolhida: Martelo");
			return armaJogador = 3;
		} else if (arma == 2) {
			System.out.println("Arma escolhida: Machado");
			return armaJogador = 7;
		} else if (arma == 3){
			System.out.println("Arma escolhida: Espada");
			return armaJogador = 5;
		} else if (arma == 4) {
			System.out.println("Arma escolhida: Clava");
			return armaJogador = 6;
		} else {
			System.out.println("Arma inválida");
			return armaJogador;
		}
		
	}
	

}
