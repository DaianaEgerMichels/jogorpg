package com.github.daianaegermichels.jogorpg.entidades;

public class Jogador {
	protected String nome;
	protected int sexo;
	protected static int arma;
	
	public static final int ESCOLHA_ARMA = arma;
	
	public Jogador(String nome, int sexo) {
		this.nome = nome;
		this.sexo = sexo;
	
	}
	
	public int EscolhaArma(int arma) {
		return Jogador.arma = arma;
	}

	public int getArma() {
		return arma;
	}

	public void setArma(int arma) {
		Jogador.arma = arma;
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
