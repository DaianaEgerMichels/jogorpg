package com.github.daianaegermichels.jogorpg.entidades;

public class Cacador extends Jogador {

	public Cacador(String nome, int sexo) {
		super(nome, sexo);
	}
	
	@Override
	public int getArma() {
		return arma;
	}


	@Override
	public void setArma(int arma) {
		setArma(EscolhaArma(arma));
	}
	
	public int EscolhaArma(int arma) {
		int armaJogador = 0;
		//setArma(armaJogador);
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
//arma = arcoFlecha ou bestaVirote
	
}
