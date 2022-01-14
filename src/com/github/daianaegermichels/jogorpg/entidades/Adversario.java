package com.github.daianaegermichels.jogorpg.entidades;

import java.util.Random;

public class Adversario extends Personagem{
	private int vida;
	private int golpe;
	private int defesa;
	
	public int Adversario(int vida, int golpe, int defesa) {
		return this.vida = this.golpe + this.defesa;
		
	}
	
	
	static int ataqueAdversario() {
		Random geradorGolpe = new Random();
		return geradorGolpe.nextInt(3) + 1;
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
