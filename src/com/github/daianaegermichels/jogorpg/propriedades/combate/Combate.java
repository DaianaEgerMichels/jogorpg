package com.github.daianaegermichels.jogorpg.propriedades.combate;

import java.util.Random;
import java.util.Scanner;

public class Combate {
	// Scanner entrada = new Scanner(System.in);

	public int classeCombate() {
		ClasseDeCombate escolhaClasse = new ClasseDeCombate();
	}

	public int atacar() {
		Random geradorGolpe = new Random();
		return geradorGolpe.nextInt(20) + 1;
	}

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
		Scanner entrada = new Scanner(System.in);
		int continua = 1;
		while (continua == 1) {
			batalha();

			System.out.println("Mensagem do dano causado!");
			System.out.printf("O que voc� deseja fazer? %n1 - Seguir em frente %n2 - Fugir");
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
//turno: jogador tem o primeiro turno, come�a o ataque, o advers�rio sempre ataca;
	// jogador pode optar por atacar() ou fugir(string fimDeJogo);
	// ataque += pontosAtaque + ataqueDaArma + rolamentoDeDado
	// pontosDefesaDefensor -= rolamentoDeDado;
	// if(rolamentoDeDado == 1){
	// pontosDefesaDefensor = pontosDefesaDefensor n�o h� desconto, o alvo foi
	// errado, n�o sofreu dano
	// } else if (rolamentoDeDado == 20){
	// ataque cr�tico
	// pontosDefesaDefensor = 0; o dano � de 100%, n�o subtrai pelos pontos de
	// defesa do defensor
	// }

	/*
	 * O jogo foi pensado com tr�s n�veis de dificuldade: f�cil, normal e dif�cil.
	 * No n�vel f�cil, todos os inimigos causam 20% a menos de dano no personagem;
	 * enquanto no n�vel dif�cil o personagem causa 10% a menos de dano nos
	 * inimigos. No n�vel normal n�o h� nenhum modificador sobre o ataque de
	 * personagens ou inimigos.
	 */

	/*
	 * 
	 * Quando o inimigo ataca, � realizado o c�lculo do ataque e o jogo deve
	 * atualizar os pontos de vida do jogador, e exibir a mensagem: �O inimigo
	 * atacou! Voc� sofreu X de dano e agora possui Y pontos de vida.� substituindo
	 * X pela quantidade de dano do ataque e Y pela quantidade de pontos de vida
	 * atual do jogador. Se o inimigo errar, a mensagem exibida deve ser �O inimigo
	 * errou o ataque! Voc� n�o sofreu dano.�. Se o inimigo acertar um ataque
	 * cr�tico, a mensagem deve ser: "O inimigo acertou um ataque cr�tico! Voc�
	 * sofreu X de dano e agora possui Y pontos de vida.". Caso o ataque do inimigo
	 * te leve a 0 pontos de vida, voc� morre, e a mensagem exibida deve ser �Voc�
	 * n�o estava preparado para a for�a do inimigo. {COMPLEMENTO DE ACORDO COM A
	 * MOTIVA��O}�, substituindo o conte�do entre chaves de acordo com a motiva��o
	 * do personagem selecionada no in�cio do jogo. VINGAN�A: �N�o foi poss� vel
	 * concluir sua vingan�a, e agora resta saber se algu�m se vingar� por voc�.�
	 * GL�RIA: �A gl�ria que buscavas n�o ser� sua, e a cidade aguarda por seu(sua)
	 * pr�ximo(a) her�i(na).� (o g�nero deve ser alterado para refletir o sexo do
	 * personagem escolhido pelo jogador no in�cio do jogo). O jogo encerra quando o
	 * jogador morre.
	 * 
	 * 
	 * 
	 * Quando � a vez do jogador fazer uma a��o, deve ser perguntado a ele se ele
	 * deseja atacar ou fugir. Se escolher fugir, o jogo deve exibir a mensagem
	 * �Voc� n�o estava preparado para a for�a do inimigo, e decide fugir para que
	 * possa tentar novamente em uma pr�xima vez.�. Se escolher atacar, o jogo deve
	 * realizar o c�lculo do ataque e atualizar os pontos de vida do inimigo. O jogo
	 * deve exibir a mensagem �Voc� atacou {COMPLEMENTO DA ARMA} e causou X de dano
	 * no inimigo!�, substituindo o conte�do entre chaves de acordo com a arma do
	 * personagem. Espada, machado, martelo ou clava: �com sua/seu {ARMA}�.
	 * Arco+flecha ou besta+virote: �com seu/sua {ARMA}, a/o {MUNI��O} atingiu�.
	 * Cajado: �com seu cajado, lan�ando uma bola de fogo�. Livro: �absorvendo
	 * energia do livro com uma m�o e liberando com a outra�. Se o jogador errar, a
	 * mensagem exibida deve ser �Voc� errou seu ataque! O inimigo n�o sofreu dano
	 * algum.�. Se o jogador acertar um ataque cr�tico, a mensagem deve ser: "Voc�
	 * acertou um ataque cr�tico! {COMPLEMENTO}� substituindo o conte�do entre
	 * chaves pela mensagem de ataque normal. Caso o inimigo morra com o seu ataque,
	 * o jogo deve exibir �O inimigo n�o � p�reo para o seu hero�smo, e jaz im�vel
	 * aos seus p�s.�]
	 * 
	 * 
	 * 
	 * 
	 */
}
