package com.github.daianaegermichels.jogorpg.entidades;

public class Cacador extends Jogador {

	public Cacador(String nome, int sexo, int arma) {
		super(nome, sexo, arma);
	}
	
	@Override
	public int getArma() {
		return super.getArma();
	}


	@Override
	public void setArma(int armaJogador) {
		super.setArma(armaJogador);
	}
	
	public int EscolhaArma() {
		int armaJogador = 0;
		getArma();
		setArma(armaJogador);
		if(getArma() == 1) {
			System.out.println("Arma escolhida: Arco e Flecha");
			return armaJogador = 7;
		} else if (getArma() == 2) {
			System.out.println("Arma escolhida: Besta e Virote");
			return armaJogador = 5;
		} else {
			System.out.println("Arma inválida");
			return armaJogador;
		}
		
	}
//arma = arcoFlecha ou bestaVirote
	
}
