package com.github.daianaegermichels.jogorpg.entidades;

public class Guerreiro extends Jogador {

	public Guerreiro(String nome, int sexo, int arma) {
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
			System.out.println("Arma escolhida: Martelo");
			return armaJogador = 3;
		} else if (getArma() == 2) {
			System.out.println("Arma escolhida: Machado");
			return armaJogador = 7;
		} else if (getArma() == 3){
			System.out.println("Arma escolhida: Espada");
			return armaJogador = 5;
		} else if (getArma() == 4) {
			System.out.println("Arma escolhida: Clava");
			return armaJogador = 6;
		} else {
			System.out.println("Arma inválida");
			return armaJogador;
		}
		
	}
	
	//se arma = martelo::: armaJogador = 3 |||| se arma = machado ::: armaJogador = 7  
	//se arma = espada ::: armaJogador=5 ||| se arma = clava ::: armaJogador = 6


}
