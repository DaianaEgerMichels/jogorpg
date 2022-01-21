package com.github.daianaegermichels.jogorpg.entidades;

public class Cacador extends Jogador {

	public Cacador(String nome, int sexo, int agilidade) {
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
			System.out.println("Arma escolhida: Arco e Flecha");
			return armaJogador = 7;
		} else if (arma == 2) {
			System.out.println("Arma escolhida: Besta e Virote");
			return armaJogador = 5;
		} else {
			System.out.println("Arma inválida");
			return armaJogador;
		}
		
	}
	
}
