package com.github.daianaegermichels.jogorpg.entidades;

public class Jogador {
	protected String nome;
	protected int sexo;
	protected int arma;
	protected int agilidade;
	
	public Jogador() {
		
	}
	
	public Jogador(String nome, int sexo, int agilidade) {
		this.nome = nome;
		this.sexo = sexo;
		this.agilidade = agilidade;
	
	}
	
	public int EscolhaArma(int arma) {
		return this.arma = arma;
	}

	public int getArma() {
		return arma;
	}

	public int setArma(int arma) {
		return this.arma = arma;
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
	
	public int getAgilidade() {
		return agilidade;
	}

	public void setAgilidade(int agilidade) {
		this.agilidade = agilidade;
	}


	
	
	
}
