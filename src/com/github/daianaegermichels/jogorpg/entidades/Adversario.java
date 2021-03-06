package com.github.daianaegermichels.jogorpg.entidades;

public abstract class Adversario {

	protected int vidaAdversario;
	protected int ataqueAdversario;
	protected int pontosDefesaAdversario;
	protected int armaAdversario;

	public Adversario() {
		
		
	}

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
