package com.github.daianaegermichels.jogorpg.entidades;

public class Adversario extends Jogador {

	private int vida;
	private int golpe;
	private int defesa;

	public Adversario(String nome, int sexo, int arma) {
		super(nome, sexo, arma);
		
	}

	public int getVida() {
		return vida;
	}

	public int getGolpe() {
		return golpe;
	}

	public int getDefesa() {
		return defesa;
	}

}
