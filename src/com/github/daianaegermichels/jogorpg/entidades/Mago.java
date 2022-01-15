package com.github.daianaegermichels.jogorpg.entidades;

public class Mago extends Jogador{

	public Mago(String nome, int sexo, int arma) {
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
			System.out.println("Arma escolhida: Livro");
			return armaJogador = 5;
		} else if (getArma() == 2) {
			System.out.println("Arma escolhida: Cajado");
			return armaJogador = 7;
		} else {
			System.out.println("Arma inválida");
			return armaJogador;
		}
		
	}
//arma = livro , cajado
}
