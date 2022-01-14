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
		System.out.println("Vida do Adversário: " + vidaAdversario);
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
			// golpe crítico, óbito do adversário, vitória do jogador
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
					"O inimigo acertou um ataque crítico! Você sofreu %d de dano e agora possui %d pontos de vida.",
					danoNoJogador, vidaJogador);
		} else {
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			pontosDefesaJogador -= danoNoJogador;
			vidaJogador--;
			System.out.printf("O inimigo atacou! Você sofreu %d de dano e agora possui %d pontos de vida.",
					danoNoJogador, vidaJogador);
		}

		if (motivacao.equals("vingança")) {
			String vinganca;
			vinganca = "Não foi possível concluir sua vingança, e agora resta saber se alguém se vingará por você.";
			motivacao = vinganca;
		} else {
			String gloria;
			String genero = "";
			String mensagemGeneroEscolhido = "";
			if (genero.equals("Feminino")) {
				mensagemGeneroEscolhido = "sua próxima heróina";
			} else {
				mensagemGeneroEscolhido = "seu próximo herói";
			}
			gloria = "A glória que buscavas não será sua, e a cidade aguarda por ";

			motivacao = gloria + mensagemGeneroEscolhido;

		}

		if (vidaJogador == 0) {
			System.out.printf("Você não estava preparado para a força do inimigo. %s", motivacao);
			System.out.println("JOGO ENCERRADO");
		}

		if (vidaAdversario == 0) {
			System.out.println("O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.");
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
					System.out.println("Acertou um golpe crítico e matou o adversário! VITÓRIA");
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
						System.out.println("Acerto crítico, matou o adversário, fim de jogo!");
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

			System.out.println("Você atacou {COMPLEMENTO DA ARMA} e causou X de dano no inimigo!");

			/*
			 * Espada, machado, martelo ou clava: “com sua/seu {ARMA}”. Arco+flecha ou
			 * besta+virote: “com seu/sua {ARMA}, a/o {MUNIÇÃO} atingiu”. Cajado: “com seu
			 * cajado, lançando uma bola de fogo”. Livro: “absorvendo energia do livro com
			 * uma mão e liberando com a outra”. Se o jogador errar, a mensagem exibida deve
			 * ser “Você errou seu ataque! O inimigo não sofreu dano algum.” . Se o jogador
			 * acertar um ataque crítico, a mensagem deve ser: "Você acertou um ataque
			 * crítico! {COMPLEMENTO}” substituindo o conteúdo entre chaves pela mensagem de
			 * ataque normal.
			 * 
			 * 
			 * Caso o inimigo morra com o seu ataque, o jogo deve exibir “O inimigo não é
			 * páreo para o seu heroísmo, e jaz imóvel aos seus pés.”
			 */
			System.out.printf("O que você deseja fazer? %n1 - Seguir em frente %n2 - Fugir");
			continua = entrada.nextInt();
		}
		entrada.close();
	}

	/*
	 * O jogo foi pensado com três níveis de dificuldade: fácil, normal e difícil.
	 * No nível fácil, todos os inimigos causam 20% a menos de dano no personagem;
	 * enquanto no nível difícil o personagem causa 10% a menos de dano nos
	 * inimigos. No nível normal não há nenhum modificador sobre o ataque de
	 * personagens ou inimigos.
	 */

	
}
