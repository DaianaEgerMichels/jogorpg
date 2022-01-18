package com.github.daianaegermichels.jogorpg.entidades;

import java.util.Random;
import java.util.Scanner;

public class Combate {
	private int vidaJogador;
	private int pontosDefesaJogador;
	private int golpeJogador;
	private int ataqueJogador;
	private int vidaAdversario;
	private int pontosDefesaAdversario;
	private int golpeAdversario;
	private int ataqueAdversario;
	private int armaJogador;
	private int armaAdversario;
	private int danoNoAdversario;
	private int danoNoJogador;
	String escolhaMotivacao;
	private int modoDeAndar;
	private String classeCombate;
	private int nivel;
	private int escolhaArmaduraNova;
	private int escolhaBeberPocao;
	private int escolhaAtacarEsperar;
	

	public int getVidaJogador() {
		return vidaJogador;
	}

	public void setVidaJogador(int vidaJogador) {
		this.vidaJogador = vidaJogador;
	}

	public int getPontosDefesaJogador() {
		return pontosDefesaJogador;
	}

	public void setPontosDefesaJogador(int pontosDefesaJogador) {
		this.pontosDefesaJogador = pontosDefesaJogador;
	}


	public Combate() {

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
	
	
	public void golpeJogador( int armaJogador, String escolhaMotivacao,
			String classeCombate) {

		
		this.armaJogador = armaJogador;
		this.escolhaMotivacao = escolhaMotivacao;
		this.classeCombate = classeCombate;
		

		golpeJogador = ataqueJogador();

		if (golpeJogador == 1) {
			danoNoAdversario = 0;
			System.out.printf("%nVoc� errou seu ataque! O inimigo n�o sofreu dano algum.");
		} else if (golpeJogador == 20) {
			pontosDefesaAdversario = 0;
			vidaAdversario = 0;
			System.out.printf("%n Voc� acertou um ataque cr�tico!");
			//if (vidaAdversario == 0) {
				//System.out.printf("%n O inimigo n�o � p�reo para o seu hero�smo, e jaz im�vel aos seus p�s.");
			//}
			
		} else {
			danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;
			if(pontosDefesaAdversario > 0) {
				pontosDefesaAdversario -= danoNoAdversario;
			}
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

			System.out.printf("%nVoc� atacou %s e causou %d de dano no inimigo! %n", complementoArma, danoNoAdversario);
			
		}
	}
	
	
	public void golpeAdversario() {
		
		golpeAdversario = ataqueAdversario();

		if (golpeAdversario == 1) {
			danoNoJogador = 0;
			System.out.printf("%nO inimigo errou o ataque! Voc� n�o sofreu dano.%n");
		} else if (golpeAdversario == 3) {
			danoNoJogador = pontosDefesaJogador;
			vidaJogador = 0;
			setPontosDefesaJogador(0);
			setVidaJogador(vidaJogador);
			System.out.printf(
					"%nO inimigo acertou um ataque cr�tico! Voc� sofreu %d de dano e agora possui %d pontos de vida.%n",
					danoNoJogador, vidaJogador);
		} else {
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			if(pontosDefesaJogador > 0) {
				pontosDefesaJogador -= danoNoJogador;
				setPontosDefesaJogador(pontosDefesaJogador);
			} else {
				pontosDefesaJogador = 0;
				setPontosDefesaJogador(pontosDefesaJogador);
			}
			vidaJogador--;
			setVidaJogador(vidaJogador);
			System.out.printf("%nO inimigo atacou! Voc� sofreu %d de dano e agora possui %d pontos de vida.%n",
					danoNoJogador, vidaJogador);
		}

	}
	
	
	@SuppressWarnings("resource")
	public int combatePortaDireita(int escolhaSeguimentoJogo, int nivel, int armaJogador, int modoDeAndar, String escolhaMotivacao,
			String classeCombate) {
		Scanner entrada = new Scanner(System.in);
		
		this.nivel = nivel;
		this.modoDeAndar = modoDeAndar;
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
			vidaJogador = 10;
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
			vidaJogador = 12;
			pontosDefesaJogador = 120;
			ataqueJogador = 15;
			ataqueAdversario = 15;
			vidaAdversario = 6;
			pontosDefesaAdversario = 60;
			armaAdversario = 7;
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;

		} else {
			vidaJogador = 12;
			pontosDefesaJogador = 110;
			ataqueJogador = 15;
			ataqueAdversario = 17;
			vidaAdversario = 8;
			pontosDefesaAdversario = 100;
			armaAdversario = 10;
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			int danoNoAdversarioDificil = 15;
			danoNoAdversario = danoNoAdversarioDificil;

		}
		
		if (modoDeAndar == 1) {
			pontosDefesaJogador -= ataqueFlechas();
			setPontosDefesaJogador(pontosDefesaJogador);
		}

		while (vidaJogador > 0 && escolhaSeguimentoJogo == 1) {

			golpeJogador(armaJogador, escolhaMotivacao, classeCombate);
			golpeAdversario();

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
				System.out.printf("%nJOGO ENCERRADO");
				//return escolhaSeguimentoJogo = 0;
			} else if (vidaJogador > 0 && vidaAdversario > 0) {

				System.out.printf("O que voc� deseja? %n 1 - Continuar %n 2 - Fugir");
				escolhaSeguimentoJogo = entrada.nextInt();
				if (escolhaSeguimentoJogo == 1) {
					continue;
				} else {
					System.out.printf(
							"%nO medo invade o seu cora��o e voc� sente que ainda n�o est� � altura do desafio. %nVoc� se volta para a noite l� fora e corre em dire��o � seguran�a.%n");
					System.out.printf("%nJOGO ENCERRADO!");
					break;
				}

			}

			else if (vidaJogador > 0 && vidaAdversario == 0) {
				System.out.printf("%nO inimigo n�o � p�reo para o seu hero�smo, e jaz im�vel aos seus p�s.");
				System.out.printf("%nO que voc� deseja? %n 1 - Seguir em frente %n 2 - Desistir");
				escolhaSeguimentoJogo = entrada.nextInt();

				switch (escolhaSeguimentoJogo) {
				case 1:
					return escolhaSeguimentoJogo;
				case 2:
					System.out.printf(
							"%n Voc� n�o estava preparado para a for�a do inimigo, e decide fugir para que possa%n tentar novamente em uma pr�xima vez.");

					System.out.printf("%n:::::::::::::::::::::  JOGO ENCERRADO  ::::::::::::::::::::::::::");
					break;
				default:
					System.out.printf("%n Entrada Inv�lida!");
					System.out.printf("O que voc� deseja? %n 1 - Seguir em frente %n 2 - Desistir");
					escolhaSeguimentoJogo = entrada.nextInt();
					break;
				}

			}
		}
		return escolhaSeguimentoJogo;

	}
	
	
	@SuppressWarnings("resource")
	public int combatePortaEsquerda(int escolhaSeguimentoJogo, int nivel, int armaJogador, String escolhaMotivacao,
			String classeCombate, int escolhaArmaduraNova) {
		Scanner entrada = new Scanner(System.in);
		
		this.nivel = nivel;
		vidaJogador = getVidaJogador();
		pontosDefesaJogador = getPontosDefesaJogador();
		this.ataqueAdversario = 0;
		this.vidaAdversario = 0;
		this.pontosDefesaAdversario = 0;
		this.armaAdversario = 0;
		this.danoNoJogador = 0;
		this.golpeAdversario = 0;
		this.ataqueJogador = 0;
		this.danoNoAdversario = 0;
		this.golpeJogador = 0;
		this.escolhaArmaduraNova = escolhaArmaduraNova;
		
		
		
		if (nivel == 1) {
			
			ataqueJogador = 15;
			ataqueAdversario = 13;
			vidaAdversario = 3;
			pontosDefesaAdversario = 20;
			armaAdversario = 5;
			danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;
			int danoNoJogadorFacil = 20;
			danoNoJogador = danoNoJogadorFacil;

		} else if (nivel == 2) {
			
			ataqueJogador = 15;
			ataqueAdversario = 15;
			vidaAdversario = 6;
			pontosDefesaAdversario = 60;
			armaAdversario = 7;
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;

		} else {
			
			ataqueJogador = 15;
			ataqueAdversario = 17;
			vidaAdversario = 8;
			pontosDefesaAdversario = 100;
			armaAdversario = 10;
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			int danoNoAdversarioDificil = 15;
			danoNoAdversario = danoNoAdversarioDificil;

		}

		while (vidaJogador > 0 && escolhaSeguimentoJogo == 1) {
			
			if(escolhaArmaduraNova == 1) {
				pontosDefesaJogador += 5;
				setPontosDefesaJogador(pontosDefesaJogador);
			}

			golpeJogador(armaJogador, escolhaMotivacao, classeCombate);
			golpeAdversario();

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
				System.out.printf("%nJOGO ENCERRADO");
				return escolhaSeguimentoJogo = 0;
			} else if (vidaJogador > 0 && vidaAdversario > 0) {

				System.out.printf("O que voc� deseja? %n 1 - Continuar %n 2 - Fugir");
				escolhaSeguimentoJogo = entrada.nextInt();
				if (escolhaSeguimentoJogo == 1) {
					continue;
				} else {
					System.out.printf(
							"%nO medo invade o seu cora��o e voc� sente que ainda n�o est� � altura do desafio. %nVoc� se volta para a noite l� fora e corre em dire��o � seguran�a.%n");
					System.out.printf("%nJOGO ENCERRADO!");
					break;
				}

			}

			else if (vidaJogador > 0 && vidaAdversario == 0) {
				System.out.printf("%nO inimigo n�o � p�reo para o seu hero�smo, e jaz im�vel aos seus p�s.");
				System.out.printf("%nO que voc� deseja? %n 1 - Seguir em frente %n 2 - Desistir");
				escolhaSeguimentoJogo = entrada.nextInt();

				switch (escolhaSeguimentoJogo) {
				case 1:
					return escolhaSeguimentoJogo;
				case 2:
					System.out.printf(
							"%n Voc� n�o estava preparado para a for�a do inimigo, e decide fugir para que possa%n tentar novamente em uma pr�xima vez.");

					System.out.printf("%n:::::::::::::::::::::  JOGO ENCERRADO  ::::::::::::::::::::::::::");
					break;
				default:
					System.out.printf("%n Entrada Inv�lida!");
					System.out.printf("O que voc� deseja? %n 1 - Seguir em frente %n 2 - Desistir");
					escolhaSeguimentoJogo = entrada.nextInt();
					break;
				}

			}
		}
		return escolhaSeguimentoJogo;

	}
	
	@SuppressWarnings("resource")
	public int combatePortaFinal(int escolhaSeguimentoJogo, int nivel, int armaJogador, String escolhaMotivacao,
			String classeCombate, int escolhaBeberPocao, int escolhaAtacarEsperar) {
		Scanner entrada = new Scanner(System.in);
		
		this.nivel = nivel;
		
		pontosDefesaJogador = getPontosDefesaJogador();
		this.ataqueAdversario = 0;
		this.vidaAdversario = 0;
		this.pontosDefesaAdversario = 0;
		this.armaAdversario = 0;
		this.danoNoJogador = 0;
		this.golpeAdversario = 0;
		this.ataqueJogador = 0;
		this.danoNoAdversario = 0;
		this.golpeJogador = 0;
		this.escolhaBeberPocao = escolhaBeberPocao;
		this.escolhaAtacarEsperar = escolhaAtacarEsperar;
		
		
		
		if (nivel == 1) {
			
			ataqueJogador = 15;
			ataqueAdversario = 13;
			vidaAdversario = 3;
			pontosDefesaAdversario = 20;
			armaAdversario = 5;
			danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;
			int danoNoJogadorFacil = 20;
			danoNoJogador = danoNoJogadorFacil;

		} else if (nivel == 2) {
			
			ataqueJogador = 15;
			ataqueAdversario = 15;
			vidaAdversario = 6;
			pontosDefesaAdversario = 60;
			armaAdversario = 7;
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;

		} else {
			
			ataqueJogador = 15;
			ataqueAdversario = 17;
			vidaAdversario = 8;
			pontosDefesaAdversario = 100;
			armaAdversario = 10;
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			int danoNoAdversarioDificil = 15;
			danoNoAdversario = danoNoAdversarioDificil;

		}
		
		
		if(escolhaBeberPocao == 1 && nivel == 1) {
			vidaJogador = 10;
		} else if (escolhaBeberPocao == 1 && nivel == 2) {
			vidaJogador = 12;
		}else if (escolhaBeberPocao == 1 && nivel == 3) {
			vidaJogador = 12;
		}else if (escolhaBeberPocao == 2) {
			vidaJogador = getVidaJogador();
		}
		

		while (vidaJogador > 0 && escolhaSeguimentoJogo == 1) {
			
			if(escolhaArmaduraNova == 1) {
				pontosDefesaJogador += 5;
				setPontosDefesaJogador(pontosDefesaJogador);
			}

			
			if(escolhaAtacarEsperar == 1) {
				golpeJogador(armaJogador, escolhaMotivacao, classeCombate);
				golpeAdversario();	
			} else {
				golpeAdversario();
				golpeJogador(armaJogador, escolhaMotivacao, classeCombate);
			}
				
			

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
				System.out.printf("%nJOGO ENCERRADO");
				return escolhaSeguimentoJogo = 0;
			} else if (vidaJogador > 0 && vidaAdversario > 0) {

				System.out.printf("O que voc� deseja? %n 1 - Continuar %n 2 - Fugir");
				escolhaSeguimentoJogo = entrada.nextInt();
				if (escolhaSeguimentoJogo == 1) {
					continue;
				} else {
					System.out.printf(
							"%nO medo invade o seu cora��o e voc� sente que ainda n�o est� � altura do desafio. %nVoc� se volta para a noite l� fora e corre em dire��o � seguran�a.%n");
					System.out.printf("%nJOGO ENCERRADO!");
					break;
				}

			}

			else if (vidaJogador > 0 && vidaAdversario == 0) {
				System.out.printf("%nO inimigo n�o � p�reo para o seu hero�smo, e jaz im�vel aos seus p�s.");
				System.out.printf("%nVIT�RIA DO JOGADOR");
				escolhaSeguimentoJogo = 1;
				return escolhaSeguimentoJogo;
			}
		}
		return escolhaSeguimentoJogo;

	}
}
