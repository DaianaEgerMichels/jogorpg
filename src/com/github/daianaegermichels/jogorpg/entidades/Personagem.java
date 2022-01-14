package com.github.daianaegermichels.jogorpg.entidades;

import java.util.Random;

public abstract class Personagem {
	private String nome;
	private int sexo;
	
	public Personagem() {
		
	}
	
	public Personagem(String nome) {
		this.nome = nome;
	}
	
	public Personagem(int sexo) {
		this.sexo = sexo;
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
	
	
	
	private int vida;
	private int golpe;
	private int defesa;
	private int geradorGolpe;
	
	
	public int ataque(int geradorGolpe){
		Random geradorGolpe = new Random();
		return this.geradorGolpe= geradorGolpe;
	}

	


	public int getGolpe() {
		return golpe;
	}


	public void setGolpe(int golpe) {
		this.golpe = golpe;
	}
	
}
