package com.github.daianaegermichels.jogorpg.entidades;

public class Guerreiro extends Jogador {

	public Guerreiro(String nome, int sexo) {
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
		setArma(armaJogador);
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
	
	//se arma = martelo::: armaJogador = 3 |||| se arma = machado ::: armaJogador = 7  
	//se arma = espada ::: armaJogador=5 ||| se arma = clava ::: armaJogador = 6


}
