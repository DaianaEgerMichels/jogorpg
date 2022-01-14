package com.github.daianaegermichels.jogorpg.entidades;


public class Personagem {
	private String nome;
	private int sexo;
	private int arma;
	private int vida;
	private int defesa;
	private int golpe;
	
	public Personagem(String nome, int sexo, int arma, int vida, int defesa, int golpe) {
		this.nome = nome;
		this.sexo = sexo;
		this.arma = arma;
		this.vida = vida;
		this.defesa = defesa;
		this.golpe = golpe;
	}

	public int getArma() {
		return arma;
	}

	public void setArma(int arma) {
		this.arma = arma;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	
	public int getGolpe() {
		return golpe;
	}

	public void setGolpe(int golpe) {
		this.golpe = golpe;
	}
	
}
