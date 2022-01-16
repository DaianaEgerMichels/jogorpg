package com.github.daianaegermichels.jogorpg.entidades;

public class Adversario {

	private int vida;
	private int golpe;
	private int defesa;

	public Adversario(int vida, int defesa) {
		this.vida = vida;
		this.defesa = defesa;
		
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
