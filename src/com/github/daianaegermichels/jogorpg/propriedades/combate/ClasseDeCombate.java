package com.github.daianaegermichels.jogorpg.propriedades.combate;

public class ClasseDeCombate {
	private String classe;
	private String arma;
	private int pontosDeVida;
	private String defesa;
	
	public ClasseDeCombate(){
		
	}
	
	
	
	public void atacar(String arma){
		this.setArma(arma);
	}



	public String getArma() {
		return arma;
	}



	public String setArma(String arma) {
		this.arma = arma;
		return arma;
	}



	public int getPontosDeVida() {
		return pontosDeVida;
	}



	public void setPontosDeVida(int pontosDeVida) {
		this.pontosDeVida = pontosDeVida;
	}



	public String getClasse() {
		return classe;
	}



	public void setClasse(String classe) {
		this.classe = classe;
	}



	public String getDefesa() {
		return defesa;
	}



	public void setDefesa(String defesa) {
		this.defesa = defesa;
	}
}
