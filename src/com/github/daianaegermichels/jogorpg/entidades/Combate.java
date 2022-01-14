package com.github.daianaegermichels.jogorpg.entidades;

import java.util.Random;
import java.util.Scanner;

import com.github.daianaegermichels.jogorpg.propriedades.combate.ClasseDeCombate;

public class Combate {
	int vidaJogador;
	int pontosDefesaJogador;
	int golpeJogador;
	int ataqueJogador;
	int vidaAdversario;
	int pontosDefesaAdversario;
	int golpeAdversario;
	int ataqueAdversario;
	int armaJogador;//vai depender da arma escolhida de acordo com o personagem;
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
		this.ataqueJogador = 15;
		this.vidaAdversario = 3;
		this.pontosDefesaAdversario = 10;
		this.golpeAdversario = ataqueAdversario();
		this.ataqueAdversario = 5;
		this.armaJogador = 15;//vai depender da arma escolhida de acordo com o personagem;
		this.armaAdversario = 5;
		this.motivacao= 1;
		
		this.danoNoAdversario = ataqueJogador + armaJogador + golpeJogador ;
		this.danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
		
		if(golpeJogador == 1) {
			danoNoAdversario = 0;
			//errou o golpe
		} else if (golpeJogador == 20) {
			danoNoAdversario = pontosDefesaAdversario;
			vidaAdversario = 0;
			//golpe crítico, óbito do adversário, vitória do jogador
		} else {
			danoNoAdversario = ataqueJogador + armaJogador + golpeJogador ;
			pontosDefesaAdversario -= danoNoAdversario;
			vidaAdversario --;
		}
		
		
		if(golpeAdversario == 1) {
			danoNoJogador = 0;
			//errou o golpe
		} else if (golpeAdversario == 3) {
			danoNoJogador = pontosDefesaJogador;
			vidaJogador = 0;
			System.out.printf("O inimigo acertou um ataque crítico! Você sofreu %d de dano e agora possui %d pontos de vida.", danoNoJogador, vidaJogador);
		} else {
			danoNoJogador = ataqueAdversario + armaAdversario + golpeAdversario;
			pontosDefesaJogador -= danoNoJogador;
			vidaJogador --;
			System.out.printf("O inimigo atacou! Você sofreu %d de dano e agora possui %d pontos de vida.", danoNoJogador, vidaJogador);
		}
		
		if(motivacao.equals("vingança")) {
			String vinganca;
			vinganca = "Não foi possível concluir sua vingança, e agora resta saber se alguém se vingará por você.";
			motivacao = vinganca;
		} else {
			String gloria;
			String genero;
			String mensagemGeneroEscolhido;
			if(genero.equals("Feminino")) {
				mensagemGeneroEscolhido = "sua próxima heróina";
			} else {
				mensagemGeneroescolhido = "seu próximo herói";
			}
			gloria = "A glória que buscavas não será sua, e a cidade aguarda por ";
			
			motivacao= gloria + mensagemGeneroEscolhido;
			
		}
		
		if(vidaJogador == 0) {
			System.out.printf("Você não estava preparado para a força do inimigo. %s", motivacao);
			System.out.println("JOGO ENCERRADO");
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
		Scanner entrada = new Scanner(System.in);
		int continua = 1;
		while (continua == 1) {
			batalha();

			System.out.println("Mensagem do dano causado!");
			System.out.printf("O que você deseja fazer? %n1 - Seguir em frente %n2 - Fugir");
			continua = entrada.nextInt();
		}
		;
	}

	/*
	 * if (escolha == atacar && nivel = 1 facil) { atacar(){ sorteaDado(valor);20
	 * pontos de dano se o numero sorteado for 1: erro de golpe rolamentoDado=0; se
	 * o numero sorteado for 2: acertou golpe rolamentoDado=-20pontosDeVida do
	 * inimigo rolamentoDado += sorteaDado.valor ataque += pontosAtaque + ataqueArma
	 * + rolamentoDado; adversario.pontosDeVida -= ataque; } } public void atacar()
	 * { jogador ataca
	 * 
	 * }
	 */
//turno: jogador tem o primeiro turno, começa o ataque, o adversário sempre ataca;
	// jogador pode optar por atacar() ou fugir(string fimDeJogo);
	// ataque += pontosAtaque + ataqueDaArma + rolamentoDeDado
	// pontosDefesaDefensor -= rolamentoDeDado;
	// if(rolamentoDeDado == 1){
	// pontosDefesaDefensor = pontosDefesaDefensor não há desconto, o alvo foi
	// errado, não sofreu dano
	// } else if (rolamentoDeDado == 20){
	// ataque crítico
	// pontosDefesaDefensor = 0; o dano é de 100%, não subtrai pelos pontos de
	// defesa do defensor
	// }

	/*
	 * O jogo foi pensado com três níveis de dificuldade: fácil, normal e difícil.
	 * No nível fácil, todos os inimigos causam 20% a menos de dano no personagem;
	 * enquanto no nível difícil o personagem causa 10% a menos de dano nos
	 * inimigos. No nível normal não há nenhum modificador sobre o ataque de
	 * personagens ou inimigos.
	 */

	/*
	 * 
	 * Quando o inimigo ataca, é realizado o cálculo do ataque e o jogo deve
	 * atualizar os pontos de vida do jogador, e exibir a mensagem: “O inimigo
	 * atacou! Você sofreu X de dano e agora possui Y pontos de vida.” substituindo
	 * X pela quantidade de dano do ataque e Y pela quantidade de pontos de vida
	 * atual do jogador. Se o inimigo errar, a mensagem exibida deve ser “O inimigo
	 * errou o ataque! Você não sofreu dano.”. Se o inimigo acertar um ataque
	 * crítico, a mensagem deve ser: "O inimigo acertou um ataque crítico! Você
	 * sofreu X de dano e agora possui Y pontos de vida.". Caso o ataque do inimigo
	 * te leve a 0 pontos de vida, você morre, e a mensagem exibida deve ser “Você
	 * não estava preparado para a força do inimigo. {COMPLEMENTO DE ACORDO COM A
	 * MOTIVAÇÃO}”, substituindo o conteúdo entre chaves de acordo com a motivação
	 * do personagem selecionada no início do jogo. VINGANÇA: “Não foi possí vel
	 * concluir sua vingança, e agora resta saber se alguém se vingará por você.”
	 * GLÓRIA: “A glória que buscavas não será sua, e a cidade aguarda por seu(sua)
	 * próximo(a) herói(na).” (o gênero deve ser alterado para refletir o sexo do
	 * personagem escolhido pelo jogador no início do jogo). O jogo encerra quando o
	 * jogador morre.
	 * 
	 * 
	 * 
	 * Quando é a vez do jogador fazer uma ação, deve ser perguntado a ele se ele
	 * deseja atacar ou fugir. Se escolher fugir, o jogo deve exibir a mensagem
	 * “Você não estava preparado para a força do inimigo, e decide fugir para que
	 * possa tentar novamente em uma próxima vez.”. Se escolher atacar, o jogo deve
	 * realizar o cálculo do ataque e atualizar os pontos de vida do inimigo. O jogo
	 * deve exibir a mensagem “Você atacou {COMPLEMENTO DA ARMA} e causou X de dano
	 * no inimigo!”, substituindo o conteúdo entre chaves de acordo com a arma do
	 * personagem. Espada, machado, martelo ou clava: “com sua/seu {ARMA}”.
	 * Arco+flecha ou besta+virote: “com seu/sua {ARMA}, a/o {MUNIÇÃO} atingiu”.
	 * Cajado: “com seu cajado, lançando uma bola de fogo”. Livro: “absorvendo
	 * energia do livro com uma mão e liberando com a outra”. Se o jogador errar, a
	 * mensagem exibida deve ser “Você errou seu ataque! O inimigo não sofreu dano
	 * algum.”. Se o jogador acertar um ataque crítico, a mensagem deve ser: "Você
	 * acertou um ataque crítico! {COMPLEMENTO}” substituindo o conteúdo entre
	 * chaves pela mensagem de ataque normal. Caso o inimigo morra com o seu ataque,
	 * o jogo deve exibir “O inimigo não é páreo para o seu heroísmo, e jaz imóvel
	 * aos seus pés.”]
	 * 
	 * 
	 * 
	 * 
	 */
}
