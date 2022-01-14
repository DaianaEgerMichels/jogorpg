package com.github.daianaegermichels.jogorpg.entidades;


public class Jogador {
	private String nome;
	private int sexo;
	private int arma;
	
	public Jogador(String nome, int sexo, int arma) {
		this.nome = nome;
		this.sexo = sexo;
		this.arma = arma;
	
	}

	public int getArma() {
		return arma;
	}

	public void setArma(int arma) {
		this.arma = arma;
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
	
	
}
