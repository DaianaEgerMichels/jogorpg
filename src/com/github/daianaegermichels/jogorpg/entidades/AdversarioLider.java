package com.github.daianaegermichels.jogorpg.entidades;

public class AdversarioLider extends Adversario{
	private int vidaAdversario = 5;
	private int ataqueAdversario = 17;
	private int pontosDefesaAdversario = 170;
	private int armaAdversario = 9;
	
	public int getVidaAdversario() {
		return vidaAdversario;
	}

	public void setVidaAdversario(int vidaAdversario) {
		this.vidaAdversario = vidaAdversario;
	}
	
	public int getAtaqueAdversario() {
		return ataqueAdversario;
	}

	public void setAtaqueAdversario(int ataqueAdversario) {
		this.ataqueAdversario = ataqueAdversario;
	}

	public int getPontosDefesaAdversario() {
		return pontosDefesaAdversario;
	}

	public void setPontosDefesaAdversario(int pontosDefesaAdversario) {
		this.pontosDefesaAdversario = pontosDefesaAdversario;
	}

	public int getArmaAdversario() {
		return armaAdversario;
	}

	public void setArmaAdversario(int armaAdversario) {
		this.armaAdversario = armaAdversario;
	}

}
