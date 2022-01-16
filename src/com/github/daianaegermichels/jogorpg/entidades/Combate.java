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
	String escolhaMotivacao;
	int modoDeAndar;
	String classeCombate;

	public Combate() {

	}

	public void imprimeVida(int vidaJogador, int vidaAdversario) {
		System.out.println("Vida do jogador:" + vidaJogador);
		System.out.println("Vida do Advers�rio: " + vidaAdversario);
	}

	public int ataqueFlechas() {
		Random geradorFlechas = new Random();
		return geradorFlechas.nextInt(10) + 1;

	}

	public int ataqueJogador() {
		Random geradorGolpe = new Random();
		return geradorGolpe.nextInt(20) + 1;
	}

	public int ataqueAdversario() {
		Random geradorGolpe = new Random();
		return geradorGolpe.nextInt(3) + 1;
	}

	public void combateJogador(int armaJogador, int modoDeAndar, String escolhaMotivacao, String classeCombate) {

		this.modoDeAndar = 0; // se modo de andar for 1 - jogador perde de 1 a 10 pontos pontosDefesaJogador -
								// ataqueFlechas();
		this.vidaJogador = 5;
		this.pontosDefesaJogador = 100;
		this.golpeJogador = ataqueJogador();
		this.ataqueJogador = 15; // somado com arma e golpe tem que dar 10% da defesa do Adversario no nivel
									// dificil
		this.vidaAdversario = 3;
		this.pontosDefesaAdversario = 20;// vai para 50 nivel dificil
		// this.golpeAdversario = ataqueAdversario();
		// this.ataqueAdversario = 13;
		this.armaJogador = 15;// vai depender da arma escolhida de acordo com o personagem;
		// this.armaAdversario = 5;
		this.escolhaMotivacao = "";
		this.classeCombate = classeCombate;

		this.danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;
		this.danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;

		if (modoDeAndar == 1) {
			pontosDefesaJogador -= ataqueFlechas();
		}

		ataqueJogador();

		if (golpeJogador == 1) {
			danoNoAdversario = 0;
			System.out.println("Voc� errou seu ataque! O inimigo n�o sofreu dano algum.");
		} else if (golpeJogador == 20) {
			danoNoAdversario = pontosDefesaAdversario;
			vidaAdversario = 0;
			System.out.println("Voc� acertou um ataque cr�tico!");
			if (vidaAdversario == 0) {
				System.out.println("O inimigo n�o � p�reo para o seu hero�smo, e jaz im�vel aos seus p�s.");
			}
		} else {
			danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;
			pontosDefesaAdversario -= danoNoAdversario;
			vidaAdversario--;
			String complementoArma = "";
			String arma = "";
			if (classeCombate.equals("G")) {
				if (armaJogador == 3) {
					arma = "Martelo";
				} else if (armaJogador == 7) {
					arma = "Machado";
				} else if (armaJogador == 5) {
					arma = "Espada";
				} else {
					arma = "Clava";
				}
				complementoArma = "com sua/seu " + arma;
			} else if (classeCombate.equals("M")) {
				if (armaJogador == 5) {
					arma = "Livro";
					complementoArma = "absorvendo energia do livro com uma m�o e liberando com a outra";
				} else {
					arma = "Cajado";
					complementoArma = "com seu cajado, lan�ando uma bola de fogo";
				}
			} else if (classeCombate.equals("C")) {
				if (armaJogador == 7) {
					arma = "Arco e Flecha";
					complementoArma = "com seu Arco, a Flecha atingiu";
				} else {
					arma = "Besta e Virote";
					complementoArma = "com sua Besta, o Virote atingiu";
				}
			}

			System.out.printf("�Voc� atacou %s e causou %d de dano no inimigo! %n", complementoArma, danoNoAdversario);
		}
	}

	
	public void combateAdversario() {
		//this.modoDeAndar = 0; // se modo de andar for 1 - jogador perde de 1 a 10 pontos pontosDefesaJogador -
		// ataqueFlechas();
		this.vidaJogador = 5;
		this.pontosDefesaJogador = 100;
		//this.golpeJogador = ataqueJogador();
		//this.ataqueJogador = 15; // somado com arma e golpe tem que dar 10% da defesa do Adversario no nivel
		// dificil
		this.vidaAdversario = 3;
		this.pontosDefesaAdversario = 20;// vai para 50 nivel dificil
		this.golpeAdversario = ataqueAdversario();
		this.ataqueAdversario = 13;
		//this.armaJogador = 15;// vai depender da arma escolhida de acordo com o personagem;
		this.armaAdversario = 5;
		this.escolhaMotivacao = "";
		//this.tipoJogador = classeCombate;

		//this.danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;
		this.danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;

		ataqueAdversario();

		if (golpeAdversario == 1) {
			danoNoJogador = 0;
			System.out.println("O inimigo errou o ataque! Voc� n�o sofreu dano.%n");
		} else if (golpeAdversario == 3) {
			danoNoJogador = pontosDefesaJogador;
			vidaJogador = 0;
			System.out.printf(
					"O inimigo acertou um ataque cr�tico! Voc� sofreu %d de dano e agora possui %d pontos de vida.%n",
					danoNoJogador, vidaJogador);
		} else {
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			pontosDefesaJogador -= danoNoJogador;
			vidaJogador--;
			System.out.printf("O inimigo atacou! Voc� sofreu %d de dano e agora possui %d pontos de vida.%n",
					danoNoJogador, vidaJogador);
		}

	}

	@SuppressWarnings("resource")
	public int batalhaFacilPortaDireita(
			int escolhaSeguimentoJogo) {
		Scanner entrada = new Scanner(System.in);
		//this.modoDeAndar = 0; // se modo de andar for 1 - jogador perde de 1 a 10 pontos pontosDefesaJogador -
								// ataqueFlechas();
		//this.vidaJogador = 5;
		//this.pontosDefesaJogador = 100;
		//this.golpeJogador = ataqueJogador();
		//this.ataqueJogador = 15; // somado com arma e golpe tem que dar 10% da defesa do Adversario no nivel
									// dificil
		//this.vidaAdversario = 3;
		//this.pontosDefesaAdversario = 20;// vai para 50 nivel dificil
		//this.golpeAdversario = ataqueAdversario();
		//this.ataqueAdversario = 13;
		//this.armaJogador = 15;// vai depender da arma escolhida de acordo com o personagem;
		//this.armaAdversario = 5;
		//this.escolhaMotivacao = "";
		//this.classeCombate = "";

		//this.danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;
		//this.danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;

		while (vidaJogador > 0 && escolhaSeguimentoJogo == 1) {
			/*if (modoDeAndar == 1) {
				pontosDefesaJogador -= ataqueFlechas();
			} else {
				return pontosDefesaJogador;
			}

			ataqueJogador();

			if (golpeJogador == 1) {
				danoNoAdversario = 0;
				System.out.println("Voc� errou seu ataque! O inimigo n�o sofreu dano algum.");
			} else if (golpeJogador == 20) {
				danoNoAdversario = pontosDefesaAdversario;
				vidaAdversario = 0;
				System.out.println("Voc� acertou um ataque cr�tico! {COMPLEMENTO Mensagem do else abaixo}");
				if (vidaAdversario == 0) {
					System.out.println("O inimigo n�o � p�reo para o seu hero�smo, e jaz im�vel aos seus p�s.");
				}
			} else {
				danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;
				pontosDefesaAdversario -= danoNoAdversario;
				vidaAdversario--;
				String complementoArma = "";
				String arma = "";
				if (classeCombate.equals("G")) {
					if (armaJogador == 3) {
						arma = "Martelo";
					} else if (armaJogador == 7) {
						arma = "Machado";
					} else if (armaJogador == 5) {
						arma = "Espada";
					} else {
						arma = "Clava";
					}
					complementoArma = "com sua/seu " + arma;
				} else if (classeCombate.equals("M")) {
					if (armaJogador == 5) {
						arma = "Livro";
						complementoArma = "absorvendo energia do livro com uma m�o e liberando com a outra";
					} else {
						arma = "Cajado";
						complementoArma = "com seu cajado, lan�ando uma bola de fogo";
					}
				} else if (classeCombate.equals("C")) {
					if (armaJogador == 7) {
						arma = "Arco e Flecha";
						complementoArma = "com seu Arco, a Flecha atingiu";
					} else {
						arma = "Besta e Virote";
						complementoArma = "com sua Besta, o Virote atingiu";
					}
				}

				System.out.printf("�Voc� atacou %s e causou %d de dano no inimigo!", complementoArma, danoNoAdversario);
			}*/
			combateJogador(armaJogador, modoDeAndar, escolhaMotivacao, classeCombate);
			combateAdversario();

			/*ataqueAdversario();

			if (golpeAdversario == 1) {
				danoNoJogador = 0;
				System.out.println("O inimigo errou o ataque! Voc� n�o sofreu dano.");
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
			}*/

			if (vidaJogador == 0) {
				if (escolhaMotivacao.equals("V")) {
					String vinganca;
					vinganca = "N�o foi poss�vel concluir sua vingan�a, e agora resta saber se algu�m se vingar� por voc�.";
					escolhaMotivacao = vinganca;
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

					escolhaMotivacao = gloria + mensagemGeneroEscolhido;

				}
				System.out.printf("Voc� n�o estava preparado para a for�a do inimigo. %s%n", escolhaMotivacao);
				System.out.printf("JOGO ENCERRADO%n");
			} else if (vidaJogador > 0 && vidaAdversario > 0) {

				System.out.printf("O que voc� deseja? %n 1 - Continuar %n 2 - Fugir");
				escolhaSeguimentoJogo = entrada.nextInt();
				if (escolhaSeguimentoJogo == 1) {
					continue;
				} else {
					System.out.printf(
							"O medo invade o seu cora��o e voc� sente que ainda n�o est� � altura do desafio. %nVoc� se volta para a noite l� fora e corre em dire��o � seguran�a.%n");
					System.out.printf("%nJOGO ENCERRADO!");
					break;
				}

			}

			else if (vidaJogador > 0 && vidaAdversario == 0) {
				System.out.println("O inimigo n�o � p�reo para o seu hero�smo, e jaz im�vel aos seus p�s.");
				System.out.printf("O que voc� deseja? %n 1 - Seguir em frente %n 2 - Desistir");
				escolhaSeguimentoJogo = entrada.nextInt();
				
				if(escolhaSeguimentoJogo == 1) {
					return escolhaSeguimentoJogo;
				} else {
					System.out.println(
							"Voc� n�o estava preparado para a for�a do inimigo, e decide fugir para que possa tentar novamente em uma pr�xima vez.");
				
					System.out.printf("%n:::::::::::::::::::::  JOGO ENCERRADO  ::::::::::::::::::::::::::");
				}
				
			}
		}
		return escolhaSeguimentoJogo;

		/*if (vidaJogador == 0) {
			if (escolhaMotivacao.equals("V")) {
				String vinganca;
				vinganca = "N�o foi poss�vel concluir sua vingan�a, e agora resta saber se algu�m se vingar� por voc�.";
				escolhaMotivacao = vinganca;
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

				escolhaMotivacao = gloria + mensagemGeneroEscolhido;

			}
			System.out.printf("Voc� n�o estava preparado para a for�a do inimigo. %s", escolhaMotivacao);
			System.out.println("JOGO ENCERRADO");
		} else {
			System.out.printf("O que voc� deseja? %n 1 - Seguir em frente %n 2 - Desistir");
			escolhaSeguimentoJogo = entrada.nextInt();
		}*/

		// :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		/*System.out.printf("O que voc� deseja fazer? %n1 - Seguir em frente %n2 - Fugir");
		int continua = entrada.nextInt();

		if (continua == 1) {
			System.out.printf(
					"Ap�s derrotar o Armeiro, voc� percebe que seus equipamentos est�o muito danificados, e olha em volta, encarando todas aquelas pe�as de armaduras resistentes e em �timo estado.");

			System.out.println("Decidi se usa a armadura ou n�o ");

		} else {
			System.out.println(
					"Voc� n�o estava preparado para a for�a do inimigo, e decide fugir para que possa tentar novamente em uma pr�xima vez.");
		}*/

		/*
		 * [jogador escolhe pegar ou n�o as armaduras novas. Se escolher pegar, o jogo
		 * deve exibir a mensagem: �Voc� resolve usar os equipamentos do inimigo contra
		 * ele, e trocar algumas pe�as suas, que estavam danificadas, pelas pe�as de
		 * armaduras existentes na sala. De armadura nova, voc� se sente mais protegido
		 * para os desafios � sua frente.� O jogo deve acrescentar +5 pontos de defesa
		 * para o jogador. Se escolher n�o pegar, o jogo deve exibir a mensagem: �Voc�
		 * decide que n�o precisa utilizar nada que venha das m�os do inimigo.�]
		 * 
		 */

		// :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	}

	public void batalha() {
		int vidaJogador = 100;
		int vidaAdversario = 100;
		int escolhaAtaque = 1; // representa que vai seguir no jogo 2- ir� fugir
		while (vidaJogador > 0 && escolhaAtaque == 1) { // enquanto o jogador estiver vivo e decidir seguir jogando,
														// fa�a o combate
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
			//combateFacilPortaDireita(continua, continua, escolhaMotivacao, escolhaMotivacao, continua);

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
