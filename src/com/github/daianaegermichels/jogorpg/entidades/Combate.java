package com.github.daianaegermichels.jogorpg.entidades;

import java.util.Random;
import java.util.Scanner;

public class Combate {
	int vidaJogador;
	int pontosDefesaJogador;
	int golpeJogador;
	int ataqueJogador;
	int vidaAdversario;
	int pontosDefesaAdversario;
	int golpeAdversario;
	int ataqueAdversario;
	int armaJogador;// vai depender da arma escolhida de acordo com o personagem;
	int armaAdversario;
	int danoNoAdversario;
	int danoNoJogador;
	String motivacao;

	public int ataqueJogador() {
		Random geradorGolpe = new Random();
		return geradorGolpe.nextInt(20) + 1;
	}

	public int ataqueAdversario() {
		Random geradorGolpe = new Random();
		return geradorGolpe.nextInt(3) + 1;
	}

	public void imprimeVida(int vidaJogador, int vidaAdversario) {
		System.out.println("Vida do jogador:" + vidaJogador);
		System.out.println("Vida do Advers�rio: " + vidaAdversario);
	}

	public void combateFacilPortaDireita() {
		this.vidaJogador = 5;
		this.pontosDefesaJogador = 100;
		this.golpeJogador = ataqueJogador();
		this.ataqueJogador = 15; // somado com arma e golpe tem que dar 10% da defesa do Adversario no nivel
									// dificil
		this.vidaAdversario = 3;
		this.pontosDefesaAdversario = 10;// vai para 50 nivel dificil
		this.golpeAdversario = ataqueAdversario();
		this.ataqueAdversario = 13;
		this.armaJogador = 15;// vai depender da arma escolhida de acordo com o personagem;
		this.armaAdversario = 5;
		this.motivacao = "";

		this.danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;
		this.danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;

		if (golpeJogador == 1) {
			danoNoAdversario = 0;
			// errou o golpe
		} else if (golpeJogador == 20) {
			danoNoAdversario = pontosDefesaAdversario;
			vidaAdversario = 0;
			// golpe cr�tico, �bito do advers�rio, vit�ria do jogador
		} else {
			danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;
			pontosDefesaAdversario -= danoNoAdversario;
			vidaAdversario--;
		}

		if (golpeAdversario == 1) {
			danoNoJogador = 0;
			// errou o golpe
		} else if (golpeAdversario == 3) {
			danoNoJogador = pontosDefesaJogador;
			vidaJogador = 0;
			System.out.printf(
					"O inimigo acertou um ataque cr�tico! Voc� sofreu %d de dano e agora possui %d pontos de vida.",
					danoNoJogador, vidaJogador);
		} else {
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			pontosDefesaJogador -= danoNoJogador;
			vidaJogador--;
			System.out.printf("O inimigo atacou! Voc� sofreu %d de dano e agora possui %d pontos de vida.",
					danoNoJogador, vidaJogador);
		}

		if (motivacao.equals("vingan�a")) {
			String vinganca;
			vinganca = "N�o foi poss�vel concluir sua vingan�a, e agora resta saber se algu�m se vingar� por voc�.";
			motivacao = vinganca;
		} else {
			String gloria;
			String genero = "";
			String mensagemGeneroEscolhido = "";
			if (genero.equals("Feminino")) {
				mensagemGeneroEscolhido = "sua pr�xima her�ina";
			} else {
				mensagemGeneroEscolhido = "seu pr�ximo her�i";
			}
			gloria = "A gl�ria que buscavas n�o ser� sua, e a cidade aguarda por ";

			motivacao = gloria + mensagemGeneroEscolhido;

		}

		if (vidaJogador == 0) {
			System.out.printf("Voc� n�o estava preparado para a for�a do inimigo. %s", motivacao);
			System.out.println("JOGO ENCERRADO");
		}

		if (vidaAdversario == 0) {
			System.out.println("O inimigo n�o � p�reo para o seu hero�smo, e jaz im�vel aos seus p�s.");
		}

	}

	public void batalha() {
		int vidaJogador = 100;
		int vidaAdversario = 100;
		int contagemEspecial = 20;
		int escolhaAtaque;
		while (vidaJogador > 0) {
			while (vidaJogador > 0 && vidaAdversario > 0) {
				imprimeVida(vidaJogador, vidaAdversario);
				escolhaAtaque = ataqueJogador();
				switch (escolhaAtaque) {
				case 1:
					System.out.println("Errou o golpe");

					break;
				case 20:
					System.out.println("Acertou um golpe cr�tico e matou o advers�rio! VIT�RIA");
					vidaAdversario = 0;
					break;
				default:
					System.out.println("Acertou o golpe!");
					vidaAdversario -= 20;
					break;
				}
				if (vidaAdversario > 0) {
					escolhaAtaque = ataqueAdversario();
					switch (escolhaAtaque) {
					case 1:
						System.out.println("Errou o golpe");
						break;
					case 2:
						System.out.println("Acertou o golpe, -20 de vida para o jogador!");
						break;
					case 3:
						System.out.println("Acerto cr�tico, matou o advers�rio, fim de jogo!");
						break;

					}
				} else {
					System.out.println("Inimigo derrotado!");
				}

			}
		}
	}

	public void combater() {
		int continua = 1;
		Scanner entrada = new Scanner(System.in);

		while (continua == 1) {
			combateFacilPortaDireita();

			System.out.println("Voc� atacou {COMPLEMENTO DA ARMA} e causou X de dano no inimigo!");

			/*
			 * Espada, machado, martelo ou clava: �com sua/seu {ARMA}�. Arco+flecha ou
			 * besta+virote: �com seu/sua {ARMA}, a/o {MUNI��O} atingiu�. Cajado: �com seu
			 * cajado, lan�ando uma bola de fogo�. Livro: �absorvendo energia do livro com
			 * uma m�o e liberando com a outra�. Se o jogador errar, a mensagem exibida deve
			 * ser �Voc� errou seu ataque! O inimigo n�o sofreu dano algum.� . Se o jogador
			 * acertar um ataque cr�tico, a mensagem deve ser: "Voc� acertou um ataque
			 * cr�tico! {COMPLEMENTO}� substituindo o conte�do entre chaves pela mensagem de
			 * ataque normal.
			 * 
			 * 
			 * Caso o inimigo morra com o seu ataque, o jogo deve exibir �O inimigo n�o �
			 * p�reo para o seu hero�smo, e jaz im�vel aos seus p�s.�
			 */
			System.out.printf("O que voc� deseja fazer? %n1 - Seguir em frente %n2 - Fugir");
			continua = entrada.nextInt();
		}
		entrada.close();
	}

	/*
	 * O jogo foi pensado com tr�s n�veis de dificuldade: f�cil, normal e dif�cil.
	 * No n�vel f�cil, todos os inimigos causam 20% a menos de dano no personagem;
	 * enquanto no n�vel dif�cil o personagem causa 10% a menos de dano nos
	 * inimigos. No n�vel normal n�o h� nenhum modificador sobre o ataque de
	 * personagens ou inimigos.
	 */

	
}
