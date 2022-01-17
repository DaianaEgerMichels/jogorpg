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
	int armaJogador;
	int armaAdversario;
	int danoNoAdversario;
	int danoNoJogador;
	String escolhaMotivacao;
	int modoDeAndar;
	String classeCombate;
	int nivel;

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

	public void combateJogador(int nivel, int armaJogador, int modoDeAndar, String escolhaMotivacao,
			String classeCombate) {

		this.nivel = nivel;
		this.modoDeAndar = modoDeAndar;
		this.armaJogador = armaJogador;
		this.escolhaMotivacao = escolhaMotivacao;
		this.classeCombate = classeCombate;
		this.vidaJogador = 0;
		this.pontosDefesaJogador = 0;
		this.ataqueJogador = 0;
		this.vidaAdversario = 0;
		this.pontosDefesaAdversario = 0;
		this.danoNoAdversario = 0;
		this.golpeJogador = 0;

		if (nivel == 1) {
			vidaJogador = 5;
			pontosDefesaJogador = 100;
			ataqueJogador = 15;
			vidaAdversario = 3;
			pontosDefesaAdversario = 20;
			danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;

		} else if (nivel == 2) {
			vidaJogador = 5;
			pontosDefesaJogador = 120;
			ataqueJogador = 10;
			vidaAdversario = 4;
			pontosDefesaAdversario = 50;
			danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;

		} else {
			vidaJogador = 4;
			pontosDefesaJogador = 100;
			ataqueJogador = 5;
			vidaAdversario = 3;
			pontosDefesaAdversario = 150;
			int danoNoAdversarioDificil = 15;
			danoNoAdversario = danoNoAdversarioDificil;

		}

		if (modoDeAndar == 1) {
			pontosDefesaJogador -= ataqueFlechas();
		}

		golpeJogador = ataqueJogador();

		if (golpeJogador == 1) {
			danoNoAdversario = 0;
			System.out.println("Você errou seu ataque! O inimigo não sofreu dano algum.");
		} else if (golpeJogador == 20) {
			danoNoAdversario = pontosDefesaAdversario;
			vidaAdversario = 0;
			System.out.printf("%n Você acertou um ataque crítico!");
			if (vidaAdversario == 0) {
				System.out.printf("%n O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.");
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

			System.out.printf("Você atacou %s e causou %d de dano no inimigo! %n", complementoArma, danoNoAdversario);
		}
	}

	public void combateAdversario(int nivel) {
		this.nivel = nivel;
		this.vidaJogador = 0;
		this.pontosDefesaJogador = 0;
		this.ataqueAdversario = 0;
		this.vidaAdversario = 0;
		this.pontosDefesaAdversario = 0;
		this.armaAdversario = 0;
		this.danoNoJogador = 0;
		this.golpeAdversario = 0;
		this.danoNoJogador = 0;

		if (nivel == 1) {
			vidaJogador = 5;
			pontosDefesaJogador = 100;
			ataqueAdversario = 13;
			vidaAdversario = 3;
			pontosDefesaAdversario = 20;
			armaAdversario = 5;
			int danoNoJogadorFacil = 20;
			danoNoJogador = danoNoJogadorFacil;

		} else if (nivel == 2) {
			vidaJogador = 5;
			pontosDefesaJogador = 120;
			ataqueAdversario = 15;
			vidaAdversario = 4;
			pontosDefesaAdversario = 50;
			armaAdversario = 7;
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;

		} else {
			vidaJogador = 4;
			pontosDefesaJogador = 100;
			ataqueAdversario = 17;
			vidaAdversario = 3;
			pontosDefesaAdversario = 100;
			armaAdversario = 5;
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;

		}

		golpeAdversario = ataqueAdversario();

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
	public int batalhaPortaDireita(int escolhaSeguimentoJogo) {
		Scanner entrada = new Scanner(System.in);

		while (vidaJogador > 0 && escolhaSeguimentoJogo == 1) {

			combateJogador(nivel, armaJogador, modoDeAndar, escolhaMotivacao, classeCombate);
			combateAdversario(nivel);

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
				System.out.printf("%nVocê não estava preparado para a força do inimigo. %s%n", escolhaMotivacao);
				System.out.printf("%nJOGO ENCERRADO!");
				return escolhaSeguimentoJogo = 0;
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

				switch (escolhaSeguimentoJogo) {
				case 1:
					return escolhaSeguimentoJogo;
				case 2:
					System.out.printf(
							"%n Você não estava preparado para a força do inimigo, e decide fugir para que possa%n tentar novamente em uma próxima vez.");

					System.out.printf("%n:::::::::::::::::::::  JOGO ENCERRADO  ::::::::::::::::::::::::::");
					break;
				default:
					System.out.printf("%n Entrada Inválida!");
					System.out.printf("O que você deseja? %n 1 - Seguir em frente %n 2 - Desistir");
					escolhaSeguimentoJogo = entrada.nextInt();
					break;
				}

			}
		}
		return escolhaSeguimentoJogo;

	}
	
	
	
	public void golpeJogador( int armaJogador, int modoDeAndar, String escolhaMotivacao,
			String classeCombate) {

		this.modoDeAndar = modoDeAndar;
		this.armaJogador = armaJogador;
		this.escolhaMotivacao = escolhaMotivacao;
		this.classeCombate = classeCombate;
		

		if (modoDeAndar == 1) {
			pontosDefesaJogador -= ataqueFlechas();
		}

		golpeJogador = ataqueJogador();

		if (golpeJogador == 1) {
			danoNoAdversario = 0;
			System.out.printf("%nVocê errou seu ataque! O inimigo não sofreu dano algum.");
		} else if (golpeJogador == 20) {
			danoNoAdversario = pontosDefesaAdversario;
			vidaAdversario = 0;
			System.out.printf("%n Você acertou um ataque crítico!");
			if (vidaAdversario == 0) {
				System.out.printf("%n O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.");
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

			System.out.printf("%nVocê atacou %s e causou %d de dano no inimigo! %n", complementoArma, danoNoAdversario);
		}
	}
	
	
	public void golpeAdversario() {
		
		golpeAdversario = ataqueAdversario();

		if (golpeAdversario == 1) {
			danoNoJogador = 0;
			System.out.printf("%nO inimigo errou o ataque! Você não sofreu dano.%n");
		} else if (golpeAdversario == 3) {
			danoNoJogador = pontosDefesaJogador;
			vidaJogador = 0;
			System.out.printf(
					"%nO inimigo acertou um ataque crítico! Você sofreu %d de dano e agora possui %d pontos de vida.%n",
					danoNoJogador, vidaJogador);
		} else {
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			pontosDefesaJogador -= danoNoJogador;
			vidaJogador--;
			System.out.printf("%nO inimigo atacou! Você sofreu %d de dano e agora possui %d pontos de vida.%n",
					danoNoJogador, vidaJogador);
		}

	}
	
	
	@SuppressWarnings("resource")
	public int combatePortaDireita(int escolhaSeguimentoJogo, int nivel, int armaJogador, int modoDeAndar, String escolhaMotivacao,
			String classeCombate) {
		Scanner entrada = new Scanner(System.in);
		
		this.nivel = nivel;
		this.vidaJogador = 0;
		this.pontosDefesaJogador = 0;
		this.ataqueAdversario = 0;
		this.vidaAdversario = 0;
		this.pontosDefesaAdversario = 0;
		this.armaAdversario = 0;
		this.danoNoJogador = 0;
		this.golpeAdversario = 0;
		this.ataqueJogador = 0;
		this.danoNoAdversario = 0;
		this.golpeJogador = 0;
		
		
		
		if (nivel == 1) {
			vidaJogador = 5;
			pontosDefesaJogador = 100;
			ataqueJogador = 15;
			ataqueAdversario = 13;
			vidaAdversario = 3;
			pontosDefesaAdversario = 20;
			armaAdversario = 5;
			danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;
			int danoNoJogadorFacil = 20;
			danoNoJogador = danoNoJogadorFacil;

		} else if (nivel == 2) {
			vidaJogador = 5;
			pontosDefesaJogador = 120;
			ataqueJogador = 10;
			ataqueAdversario = 15;
			vidaAdversario = 4;
			pontosDefesaAdversario = 50;
			armaAdversario = 7;
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;

		} else {
			vidaJogador = 4;
			pontosDefesaJogador = 100;
			ataqueJogador = 5;
			ataqueAdversario = 17;
			vidaAdversario = 3;
			pontosDefesaAdversario = 100;
			armaAdversario = 5;
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			int danoNoAdversarioDificil = 15;
			danoNoAdversario = danoNoAdversarioDificil;

		}

		while (vidaJogador > 0 && escolhaSeguimentoJogo == 1) {

			golpeJogador(armaJogador, modoDeAndar, escolhaMotivacao, classeCombate);
			golpeAdversario();

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
				System.out.printf("%nJOGO ENCERRADO");
				return escolhaSeguimentoJogo = 0;
			} else if (vidaJogador > 0 && vidaAdversario > 0) {

				System.out.printf("O que você deseja? %n 1 - Continuar %n 2 - Fugir");
				escolhaSeguimentoJogo = entrada.nextInt();
				if (escolhaSeguimentoJogo == 1) {
					continue;
				} else {
					System.out.printf(
							"%nO medo invade o seu coração e você sente que ainda não está à altura do desafio. %nVocê se volta para a noite lá fora e corre em direção à segurança.%n");
					System.out.printf("%nJOGO ENCERRADO!");
					break;
				}

			}

			else if (vidaJogador > 0 && vidaAdversario == 0) {
				System.out.printf("%nO inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.");
				System.out.printf("%nO que você deseja? %n 1 - Seguir em frente %n 2 - Desistir");
				escolhaSeguimentoJogo = entrada.nextInt();

				switch (escolhaSeguimentoJogo) {
				case 1:
					return escolhaSeguimentoJogo;
				case 2:
					System.out.printf(
							"%n Você não estava preparado para a força do inimigo, e decide fugir para que possa%n tentar novamente em uma próxima vez.");

					System.out.printf("%n:::::::::::::::::::::  JOGO ENCERRADO  ::::::::::::::::::::::::::");
					break;
				default:
					System.out.printf("%n Entrada Inválida!");
					System.out.printf("O que você deseja? %n 1 - Seguir em frente %n 2 - Desistir");
					escolhaSeguimentoJogo = entrada.nextInt();
					break;
				}

			}
		}
		return escolhaSeguimentoJogo;

	}

	@SuppressWarnings("resource")
	public int combater(int escolhaSeguimentoJogo) {
		Scanner entrada = new Scanner(System.in);
		// this.modoDeAndar = 0; // se modo de andar for 1 - jogador perde de 1 a 10
		// pontos pontosDefesaJogador -
		// ataqueFlechas();
		// this.vidaJogador = 5;
		// this.pontosDefesaJogador = 100;
		// this.golpeJogador = ataqueJogador();
		// this.ataqueJogador = 15; // somado com arma e golpe tem que dar 10% da defesa
		// do Adversario no nivel
		// dificil
		// this.vidaAdversario = 3;
		// this.pontosDefesaAdversario = 20;// vai para 50 nivel dificil
		// this.golpeAdversario = ataqueAdversario();
		// this.ataqueAdversario = 13;
		// this.armaJogador = 15;// vai depender da arma escolhida de acordo com o
		// personagem;
		// this.armaAdversario = 5;
		// this.escolhaMotivacao = "";
		// this.classeCombate = "";

		// this.danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;
		// this.danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;

		while (vidaJogador > 0 && escolhaSeguimentoJogo == 1) {
			/*
			 * if (modoDeAndar == 1) { pontosDefesaJogador -= ataqueFlechas(); } else {
			 * return pontosDefesaJogador; }
			 * 
			 * ataqueJogador();
			 * 
			 * if (golpeJogador == 1) { danoNoAdversario = 0;
			 * System.out.println("Você errou seu ataque! O inimigo não sofreu dano algum."
			 * ); } else if (golpeJogador == 20) { danoNoAdversario =
			 * pontosDefesaAdversario; vidaAdversario = 0; System.out.
			 * println("Você acertou um ataque crítico! {COMPLEMENTO Mensagem do else abaixo}"
			 * ); if (vidaAdversario == 0) { System.out.
			 * println("O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés."
			 * ); } } else { danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;
			 * pontosDefesaAdversario -= danoNoAdversario; vidaAdversario--; String
			 * complementoArma = ""; String arma = ""; if (classeCombate.equals("G")) { if
			 * (armaJogador == 3) { arma = "Martelo"; } else if (armaJogador == 7) { arma =
			 * "Machado"; } else if (armaJogador == 5) { arma = "Espada"; } else { arma =
			 * "Clava"; } complementoArma = "com sua/seu " + arma; } else if
			 * (classeCombate.equals("M")) { if (armaJogador == 5) { arma = "Livro";
			 * complementoArma =
			 * "absorvendo energia do livro com uma mão e liberando com a outra"; } else {
			 * arma = "Cajado"; complementoArma =
			 * "com seu cajado, lançando uma bola de fogo"; } } else if
			 * (classeCombate.equals("C")) { if (armaJogador == 7) { arma = "Arco e Flecha";
			 * complementoArma = "com seu Arco, a Flecha atingiu"; } else { arma =
			 * "Besta e Virote"; complementoArma = "com sua Besta, o Virote atingiu"; } }
			 * 
			 * System.out.printf("“Você atacou %s e causou %d de dano no inimigo!",
			 * complementoArma, danoNoAdversario); }
			 */
			combateJogador(nivel, armaJogador, modoDeAndar, escolhaMotivacao, classeCombate);
			combateAdversario(nivel);

			/*
			 * ataqueAdversario();
			 * 
			 * if (golpeAdversario == 1) { danoNoJogador = 0;
			 * System.out.println("O inimigo errou o ataque! Você não sofreu dano."); } else
			 * if (golpeAdversario == 3) { danoNoJogador = pontosDefesaJogador; vidaJogador
			 * = 0; System.out.printf(
			 * "O inimigo acertou um ataque crítico! Você sofreu %d de dano e agora possui %d pontos de vida."
			 * , danoNoJogador, vidaJogador); } else { danoNoJogador = ataqueAdversario +
			 * armaAdversario + golpeAdversario; pontosDefesaJogador -= danoNoJogador;
			 * vidaJogador--; System.out.
			 * printf("O inimigo atacou! Você sofreu %d de dano e agora possui %d pontos de vida."
			 * , danoNoJogador, vidaJogador); }
			 */

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
				System.out.printf("%nJOGO ENCERRADO");
				return escolhaSeguimentoJogo = 0;
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

				switch (escolhaSeguimentoJogo) {
				case 1:
					return escolhaSeguimentoJogo;
				case 2:
					System.out.printf(
							"%n Você não estava preparado para a força do inimigo, e decide fugir para que possa%n tentar novamente em uma próxima vez.");

					System.out.printf("%n:::::::::::::::::::::  JOGO ENCERRADO  ::::::::::::::::::::::::::");
					break;
				default:
					System.out.printf("%n Entrada Inválida!");
					System.out.printf("O que você deseja? %n 1 - Seguir em frente %n 2 - Desistir");
					escolhaSeguimentoJogo = entrada.nextInt();
					break;
				}

			}
		}
		return escolhaSeguimentoJogo;
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
}
