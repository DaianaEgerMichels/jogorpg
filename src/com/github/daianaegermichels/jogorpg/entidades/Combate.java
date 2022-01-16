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
		System.out.println("Vida do Adversário: " + vidaAdversario);
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
			System.out.println("Você errou seu ataque! O inimigo não sofreu dano algum.");
		} else if (golpeJogador == 20) {
			danoNoAdversario = pontosDefesaAdversario;
			vidaAdversario = 0;
			System.out.println("Você acertou um ataque crítico!");
			if (vidaAdversario == 0) {
				System.out.println("O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.");
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
					complementoArma = "absorvendo energia do livro com uma mão e liberando com a outra";
				} else {
					arma = "Cajado";
					complementoArma = "com seu cajado, lançando uma bola de fogo";
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

			System.out.printf("“Você atacou %s e causou %d de dano no inimigo! %n", complementoArma, danoNoAdversario);
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
			System.out.println("O inimigo errou o ataque! Você não sofreu dano.%n");
		} else if (golpeAdversario == 3) {
			danoNoJogador = pontosDefesaJogador;
			vidaJogador = 0;
			System.out.printf(
					"O inimigo acertou um ataque crítico! Você sofreu %d de dano e agora possui %d pontos de vida.%n",
					danoNoJogador, vidaJogador);
		} else {
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			pontosDefesaJogador -= danoNoJogador;
			vidaJogador--;
			System.out.printf("O inimigo atacou! Você sofreu %d de dano e agora possui %d pontos de vida.%n",
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
				System.out.println("Você errou seu ataque! O inimigo não sofreu dano algum.");
			} else if (golpeJogador == 20) {
				danoNoAdversario = pontosDefesaAdversario;
				vidaAdversario = 0;
				System.out.println("Você acertou um ataque crítico! {COMPLEMENTO Mensagem do else abaixo}");
				if (vidaAdversario == 0) {
					System.out.println("O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.");
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
						complementoArma = "absorvendo energia do livro com uma mão e liberando com a outra";
					} else {
						arma = "Cajado";
						complementoArma = "com seu cajado, lançando uma bola de fogo";
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

				System.out.printf("“Você atacou %s e causou %d de dano no inimigo!", complementoArma, danoNoAdversario);
			}*/
			combateJogador(armaJogador, modoDeAndar, escolhaMotivacao, classeCombate);
			combateAdversario();

			/*ataqueAdversario();

			if (golpeAdversario == 1) {
				danoNoJogador = 0;
				System.out.println("O inimigo errou o ataque! Você não sofreu dano.");
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
			}*/

			if (vidaJogador == 0) {
				if (escolhaMotivacao.equals("V")) {
					String vinganca;
					vinganca = "Não foi possível concluir sua vingança, e agora resta saber se alguém se vingará por você.";
					escolhaMotivacao = vinganca;
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

					escolhaMotivacao = gloria + mensagemGeneroEscolhido;

				}
				System.out.printf("Você não estava preparado para a força do inimigo. %s%n", escolhaMotivacao);
				System.out.printf("JOGO ENCERRADO%n");
			} else if (vidaJogador > 0 && vidaAdversario > 0) {

				System.out.printf("O que você deseja? %n 1 - Continuar %n 2 - Fugir");
				escolhaSeguimentoJogo = entrada.nextInt();
				if (escolhaSeguimentoJogo == 1) {
					continue;
				} else {
					System.out.printf(
							"O medo invade o seu coração e você sente que ainda não está à altura do desafio. %nVocê se volta para a noite lá fora e corre em direção à segurança.%n");
					System.out.printf("%nJOGO ENCERRADO!");
					break;
				}

			}

			else if (vidaJogador > 0 && vidaAdversario == 0) {
				System.out.println("O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.");
				System.out.printf("O que você deseja? %n 1 - Seguir em frente %n 2 - Desistir");
				escolhaSeguimentoJogo = entrada.nextInt();
				
				if(escolhaSeguimentoJogo == 1) {
					return escolhaSeguimentoJogo;
				} else {
					System.out.println(
							"Você não estava preparado para a força do inimigo, e decide fugir para que possa tentar novamente em uma próxima vez.");
				
					System.out.printf("%n:::::::::::::::::::::  JOGO ENCERRADO  ::::::::::::::::::::::::::");
				}
				
			}
		}
		return escolhaSeguimentoJogo;

		/*if (vidaJogador == 0) {
			if (escolhaMotivacao.equals("V")) {
				String vinganca;
				vinganca = "Não foi possível concluir sua vingança, e agora resta saber se alguém se vingará por você.";
				escolhaMotivacao = vinganca;
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

				escolhaMotivacao = gloria + mensagemGeneroEscolhido;

			}
			System.out.printf("Você não estava preparado para a força do inimigo. %s", escolhaMotivacao);
			System.out.println("JOGO ENCERRADO");
		} else {
			System.out.printf("O que você deseja? %n 1 - Seguir em frente %n 2 - Desistir");
			escolhaSeguimentoJogo = entrada.nextInt();
		}*/

		// :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		/*System.out.printf("O que você deseja fazer? %n1 - Seguir em frente %n2 - Fugir");
		int continua = entrada.nextInt();

		if (continua == 1) {
			System.out.printf(
					"Após derrotar o Armeiro, você percebe que seus equipamentos estão muito danificados, e olha em volta, encarando todas aquelas peças de armaduras resistentes e em ótimo estado.");

			System.out.println("Decidi se usa a armadura ou não ");

		} else {
			System.out.println(
					"Você não estava preparado para a força do inimigo, e decide fugir para que possa tentar novamente em uma próxima vez.");
		}*/

		/*
		 * [jogador escolhe pegar ou não as armaduras novas. Se escolher pegar, o jogo
		 * deve exibir a mensagem: “Você resolve usar os equipamentos do inimigo contra
		 * ele, e trocar algumas peças suas, que estavam danificadas, pelas peças de
		 * armaduras existentes na sala. De armadura nova, você se sente mais protegido
		 * para os desafios à sua frente.” O jogo deve acrescentar +5 pontos de defesa
		 * para o jogador. Se escolher não pegar, o jogo deve exibir a mensagem: “Você
		 * decide que não precisa utilizar nada que venha das mãos do inimigo.”]
		 * 
		 */

		// :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	}

	public void batalha() {
		int vidaJogador = 100;
		int vidaAdversario = 100;
		int escolhaAtaque = 1; // representa que vai seguir no jogo 2- irá fugir
		while (vidaJogador > 0 && escolhaAtaque == 1) { // enquanto o jogador estiver vivo e decidir seguir jogando,
														// faça o combate
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
			//combateFacilPortaDireita(continua, continua, escolhaMotivacao, escolhaMotivacao, continua);

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
