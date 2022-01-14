package com.github.daianaegermichels.jogorpg.entidades;

import java.util.Random;

import com.github.daianaegermichels.jogorpg.propriedades.Jogadores;

public class Jogador extends Personagem {

	private String nome;
	private int sexoAvatar;
	private String arma;
	private String classeCombate;

	@Override
	public int ataque(int geradorGolpe) {
		int geradorGolpe1 = new Random();
		geradorGolpe1 = geradorGolpe1.nextInt(20) + 1;
	}

	public int ataque() {
		Random geradorGolpe = new Random();
		return geradorGolpe.nextInt(20) + 1;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSexoAvatar() {
		return sexoAvatar;
	}

	public void setSexoAvatar(int sexoAvatar) {
		this.sexoAvatar = sexoAvatar;
	}

	public String getArma() {
		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}

	public String getClasseCombate() {
		return classeCombate;
	}

	public void setClasseCombate(String classeCombate) {
		this.classeCombate = classeCombate;
	}

}
