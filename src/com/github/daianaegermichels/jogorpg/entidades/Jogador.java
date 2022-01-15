package com.github.daianaegermichels.jogorpg.entidades;

public class Jogador {
	protected String nome;
	protected int sexo;
	protected int arma;
	
	public Jogador(String nome, int sexo) {
		this.nome = nome;
		this.sexo = sexo;
	
	}
	
	public int EscolhaArma(int arma) {
		return this.arma = arma;
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
