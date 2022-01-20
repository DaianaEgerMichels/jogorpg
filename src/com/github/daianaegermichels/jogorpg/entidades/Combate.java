package com.github.daianaegermichels.jogorpg.entidades;

import java.util.Random;
import java.util.Scanner;

public class Combate {
	static AdversarioArmeiro adversarioArmeiro = new AdversarioArmeiro();
	static AdversarioAlquimista adversarioAlquimista = new AdversarioAlquimista();
	static AdversarioLider adversarioLider = new AdversarioLider();

	private int vidaJogador;
	private int pontosDefesaJogador;
	private int golpeJogador;
	private int ataqueJogador;
	private int vidaAdversario;
	private int pontosDefesaAdversario;
	private int golpeAdversario;
	private int ataqueAdversario;
	private int armaAdversario;
	private int danoNoAdversario;
	private int danoNoJogador;
	int armaJogador;
	String escolhaMotivacao;
	int modoDeAndar;
	String classeCombate;
	int nivel;
	int escolhaArmaduraNova;
	int escolhaBeberPocao;
	int escolhaAtacarEsperar;

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

	public void golpeJogador(int armaJogador, String escolhaMotivacao, String classeCombate, int nivel) {

		this.armaJogador = armaJogador;
		this.escolhaMotivacao = escolhaMotivacao;
		this.classeCombate = classeCombate;

		golpeJogador = ataqueJogador();

		if (golpeJogador == 1) {
			danoNoAdversario = 0;
			System.out.printf("%nVocê errou seu ataque! O inimigo não sofreu dano algum.");
		} else if (golpeJogador == 20) {
			danoNoAdversario = 50;
			
			if (nivel == 1) {
				vidaAdversario = 0;
			} else if (nivel == 2) {
				vidaAdversario -= 5;
			} else {
				vidaAdversario -= 4;
			}
			
			System.out.printf("%n Você acertou um ataque crítico!");
			
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
			

		} else if (pontosDefesaAdversario > 0 && vidaAdversario > 0) {
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

		} else {
			vidaAdversario = 0;
			System.out.printf("%n O inimigo sem pontos de defesa foi golpeado e morreu!");
		}
	}

	public void golpeAdversario(int nivel) {

		golpeAdversario = ataqueAdversario();

		if (golpeAdversario == 1) {
			danoNoJogador = 0;
			System.out.printf("%nO inimigo errou o ataque! Você não sofreu dano.%n");
		} else if (golpeAdversario == 3) {
			
			if (nivel == 1) {
				vidaJogador -= 2;
			} else if (nivel == 2) {
				vidaJogador -= 4;
			} else {
				vidaJogador -= 6;
			}
			
			setVidaJogador(vidaJogador);
			System.out.printf(
					"%nO inimigo acertou um ataque crítico! Você agora possui %d pontos de vida.%n",
					 vidaJogador);
		} else {
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			if (pontosDefesaJogador > 0) {
				pontosDefesaJogador -= danoNoJogador;
				setPontosDefesaJogador(pontosDefesaJogador);
			} else {
				pontosDefesaJogador = 0;
				setPontosDefesaJogador(pontosDefesaJogador);
			}
			vidaJogador--;
			setVidaJogador(vidaJogador);
			System.out.printf("%nO inimigo atacou! Você sofreu %d de dano e agora possui %d pontos de vida.%n",
					danoNoJogador, vidaJogador);
		}

	}

	@SuppressWarnings("resource")
	public int combatePortaDireita(int escolhaSeguimentoJogo, int nivel, int armaJogador, int modoDeAndar,
			String escolhaMotivacao, String classeCombate) {
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
			setVidaJogador(vidaJogador);
			pontosDefesaJogador = 100;
			setPontosDefesaJogador(pontosDefesaJogador);
			ataqueJogador = 15;
			ataqueAdversario = adversarioArmeiro.getAtaqueAdversario();
			vidaAdversario = adversarioArmeiro.getVidaAdversario();
			pontosDefesaAdversario = adversarioArmeiro.getPontosDefesaAdversario();
			armaAdversario = adversarioArmeiro.getArmaAdversario();
			danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;
			int danoNoJogadorFacil = 20;
			danoNoJogador = danoNoJogadorFacil;

		} else if (nivel == 2) {
			vidaJogador = 15;
			setVidaJogador(vidaJogador);
			pontosDefesaJogador = 150;
			setPontosDefesaJogador(pontosDefesaJogador);
			ataqueJogador = 14;
			ataqueAdversario = 15;
			adversarioArmeiro.setAtaqueAdversario(ataqueAdversario);
			vidaAdversario = 6;
			adversarioArmeiro.setVidaAdversario(vidaAdversario);
			pontosDefesaAdversario = 120;
			adversarioArmeiro.setPontosDefesaAdversario(pontosDefesaAdversario);
			armaAdversario = 7;
			adversarioArmeiro.setArmaAdversario(armaAdversario);
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;

		} else {
			vidaJogador = 15;
			setVidaJogador(vidaJogador);
			pontosDefesaJogador = 180;
			setPontosDefesaJogador(pontosDefesaJogador);
			ataqueJogador = 13;
			ataqueAdversario = 17;
			adversarioArmeiro.setAtaqueAdversario(ataqueAdversario);
			vidaAdversario = 8;
			adversarioArmeiro.setVidaAdversario(vidaAdversario);
			pontosDefesaAdversario = 170;
			adversarioArmeiro.setPontosDefesaAdversario(pontosDefesaAdversario);
			armaAdversario = 10;
			adversarioArmeiro.setArmaAdversario(armaAdversario);
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			int danoNoAdversarioDificil = 15;
			danoNoAdversario = danoNoAdversarioDificil;

		}

		if (modoDeAndar == 1) {
			pontosDefesaJogador -= ataqueFlechas();
			setPontosDefesaJogador(pontosDefesaJogador);
		}

		while (vidaJogador > 0 && vidaAdversario > 0) {

			if (getVidaJogador() > 0) {
				golpeJogador(armaJogador, escolhaMotivacao, classeCombate, nivel);
			}
			adversarioArmeiro.setVidaAdversario(vidaAdversario);
			if (adversarioArmeiro.getVidaAdversario() > 0) {
				golpeAdversario(nivel);
			}
			;
			setVidaJogador(vidaJogador);

			if (vidaJogador > 0) {
				System.out.printf("O que você deseja? %n 1 - Continuar %n 2 - Fugir");
				escolhaSeguimentoJogo = entrada.nextInt();
				if (escolhaSeguimentoJogo == 1) {
					continue;
				} else {
					System.out.printf(
							"%nO medo invade o seu coração e você sente que ainda não está à altura do desafio. %nVocê se volta para a noite lá fora e corre em direção à segurança.%n");
					return escolhaSeguimentoJogo = 2;
				}
			} else {
				return escolhaSeguimentoJogo = 0;
			}
		}

		if (vidaJogador > 0 && vidaAdversario == 0) {
			System.out.printf("%nO inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.");
			System.out.printf("%nO que você deseja? %n 1 - Seguir em frente %n 2 - Desistir");
			escolhaSeguimentoJogo = entrada.nextInt();

			switch (escolhaSeguimentoJogo) {
			case 1:
				return escolhaSeguimentoJogo = 1;
			case 2:
				return escolhaSeguimentoJogo = 2;
			default:
				System.out.printf("%n Entrada Inválida!");
				return escolhaSeguimentoJogo = 0;
			}

		} else if (vidaJogador <= 0 && vidaAdversario > 0) {
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
			System.out.printf("%nFim de jogo para você!");
			return escolhaSeguimentoJogo = 0;
		} else {
			return escolhaSeguimentoJogo = 0;
		}

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
			ataqueAdversario = adversarioAlquimista.getAtaqueAdversario();
			vidaAdversario = adversarioAlquimista.getVidaAdversario();
			pontosDefesaAdversario = adversarioAlquimista.getPontosDefesaAdversario();
			armaAdversario = adversarioAlquimista.getArmaAdversario();
			danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;
			int danoNoJogadorFacil = 20;
			danoNoJogador = danoNoJogadorFacil;

		} else if (nivel == 2) {

			ataqueJogador = 15;
			ataqueAdversario = 17;
			adversarioAlquimista.setAtaqueAdversario(ataqueAdversario);
			vidaAdversario = 7;
			adversarioAlquimista.setVidaAdversario(vidaAdversario);
			pontosDefesaAdversario = 170;
			adversarioAlquimista.setPontosDefesaAdversario(pontosDefesaAdversario);
			armaAdversario = 8;
			adversarioAlquimista.setArmaAdversario(armaAdversario);
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;

		} else {

			ataqueJogador = 15;
			ataqueAdversario = 19;
			adversarioAlquimista.setAtaqueAdversario(ataqueAdversario);
			vidaAdversario = 9;
			adversarioAlquimista.setVidaAdversario(vidaAdversario);
			pontosDefesaAdversario = 190;
			adversarioAlquimista.setPontosDefesaAdversario(pontosDefesaAdversario);
			armaAdversario = 10;
			adversarioAlquimista.setArmaAdversario(armaAdversario);
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			int danoNoAdversarioDificil = 15;
			danoNoAdversario = danoNoAdversarioDificil;

		}

		if (escolhaArmaduraNova == 1) {
			pontosDefesaJogador += 5;
			setPontosDefesaJogador(pontosDefesaJogador);
		}

		while (vidaJogador > 0 && vidaAdversario > 0) {

			if (getVidaJogador() > 0) {
				golpeJogador(armaJogador, escolhaMotivacao, classeCombate, nivel);
			}
			adversarioAlquimista.setVidaAdversario(vidaAdversario);
			if (adversarioAlquimista.getVidaAdversario() > 0) {
				golpeAdversario(nivel);
			} else {
				System.out.println("Inimigo Derrotado!");
			}
			;
			setVidaJogador(vidaJogador);

			if (vidaJogador > 0) {
				System.out.printf("O que você deseja? %n 1 - Continuar %n 2 - Fugir");
				escolhaSeguimentoJogo = entrada.nextInt();
				if (escolhaSeguimentoJogo == 1) {
					continue;
				} else {
					System.out.printf(
							"%nO medo invade o seu coração e você sente que ainda não está à altura do desafio. %nVocê se volta para a noite lá fora e corre em direção à segurança.%n");
					System.out.printf("%nJOGO ENCERRADO!");
					return escolhaSeguimentoJogo = 2;
				}
			}
		}

		 if (vidaJogador > 0 && vidaAdversario <= 0) {
			System.out.printf("%nO inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.");
			System.out.printf("%nO que você deseja? %n 1 - Seguir em frente %n 2 - Desistir");
			escolhaSeguimentoJogo = entrada.nextInt();

			switch (escolhaSeguimentoJogo) {
			case 1:
				return escolhaSeguimentoJogo = 1;
			case 2:
				return escolhaSeguimentoJogo = 2;
			default:
				System.out.printf("%n Entrada Inválida!");
				return escolhaSeguimentoJogo = 0;
			}

		}

		else if (vidaJogador <= 0 && vidaAdversario > 0) {
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
			System.out.printf("%nFim de jogo para você!");
			return escolhaSeguimentoJogo = 0;
		} else {
			return escolhaSeguimentoJogo = 0;
		}

	}

	@SuppressWarnings("resource")
	public int combatePortaFinal(int escolhaSeguimentoJogo, int nivel, int armaJogador, String escolhaMotivacao,
			String classeCombate, int escolhaBeberPocao, int escolhaAtacarEsperar) {
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
		this.escolhaBeberPocao = escolhaBeberPocao;
		this.escolhaAtacarEsperar = escolhaAtacarEsperar;

		if (nivel == 1) {

			ataqueJogador = 15;
			ataqueAdversario = adversarioLider.getAtaqueAdversario();
			vidaAdversario = adversarioLider.getVidaAdversario();
			pontosDefesaAdversario = adversarioLider.getPontosDefesaAdversario();
			armaAdversario = adversarioLider.getArmaAdversario();
			danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;
			int danoNoJogadorFacil = 20;
			danoNoJogador = danoNoJogadorFacil;

		} else if (nivel == 2) {

			ataqueJogador = 15;
			ataqueAdversario = 18;
			adversarioLider.setAtaqueAdversario(ataqueAdversario);
			vidaAdversario = 7;
			adversarioLider.setVidaAdversario(vidaAdversario);
			pontosDefesaAdversario = 190;
			adversarioLider.setPontosDefesaAdversario(pontosDefesaAdversario);
			armaAdversario = 12;
			adversarioLider.setArmaAdversario(armaAdversario);
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			danoNoAdversario = ataqueJogador + armaJogador + golpeJogador;

		} else {

			ataqueJogador = 15;
			ataqueAdversario = 20;
			adversarioLider.setAtaqueAdversario(ataqueAdversario);
			vidaAdversario = 8;
			adversarioLider.setVidaAdversario(vidaAdversario);
			pontosDefesaAdversario = 220;
			adversarioLider.setPontosDefesaAdversario(pontosDefesaAdversario);
			armaAdversario = 13;
			adversarioLider.setArmaAdversario(armaAdversario);
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			int danoNoAdversarioDificil = 15;
			danoNoAdversario = danoNoAdversarioDificil;

		}

		if (escolhaBeberPocao == 1 && nivel == 1) {
			vidaJogador = 10;
			setVidaJogador(vidaJogador);
		} else if (escolhaBeberPocao == 1 && nivel == 2) {
			vidaJogador = 15;
			setVidaJogador(vidaJogador);
		} else if (escolhaBeberPocao == 1 && nivel == 3) {
			vidaJogador = 15;
			setVidaJogador(vidaJogador);
		} else if (escolhaBeberPocao == 2) {
			vidaJogador = getVidaJogador();
		}

		while (vidaJogador > 0 && vidaAdversario > 0) {

			if (vidaJogador > 0 && vidaAdversario > 0) {
				if (escolhaAtacarEsperar == 1) {
					golpeJogador(armaJogador, escolhaMotivacao, classeCombate, nivel);
					adversarioLider.setVidaAdversario(vidaAdversario);
					if (adversarioLider.getVidaAdversario() > 0) {
						golpeAdversario(nivel);
					} else {
						System.out.println("Inimigo Derrotado!");
					}
					;
					setVidaJogador(vidaJogador);

				} else if (escolhaAtacarEsperar == 2) {
					if (adversarioLider.getVidaAdversario() > 0) {
						golpeAdversario(nivel);
					} else {
						System.out.println("inimigo Derrotado!");
					}
					;
					setVidaJogador(vidaJogador);
					golpeJogador(armaJogador, escolhaMotivacao, classeCombate, nivel);
					adversarioLider.setVidaAdversario(vidaAdversario);
				}

				System.out.printf("O que você deseja? %n 1 - Continuar %n 2 - Fugir");
				escolhaSeguimentoJogo = entrada.nextInt();
				if (escolhaSeguimentoJogo == 1) {
					System.out.println("Novo round!");
					continue;
				} else {
					System.out.printf(
							"%nO medo invade o seu coração e você sente que ainda não está à altura do desafio. %nVocê se volta para a noite lá fora e corre em direção à segurança.%n");
					System.out.printf("%nJOGO ENCERRADO!");
					return escolhaSeguimentoJogo = 2;
				}

			} else if (vidaJogador > 0 && vidaAdversario <= 0) {
				System.out.printf("%nO inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.");
				System.out.printf("%nVITÓRIA DO JOGADOR");
				return escolhaSeguimentoJogo = 1;
			} else if (vidaJogador <= 0 && vidaAdversario > 0) {
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
				return escolhaSeguimentoJogo = 0;
			} else {
				return escolhaSeguimentoJogo = 0;
			}

		}
		return escolhaSeguimentoJogo;

	}
}
