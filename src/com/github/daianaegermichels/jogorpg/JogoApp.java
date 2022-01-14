package com.github.daianaegermichels.jogorpg;

import java.util.Scanner;

import com.github.daianaegermichels.jogorpg.entidades.Jogador;

public class JogoApp {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.printf("Iniciar o jogo:%n 1 - Sim %n 2 - N�o");
		int inicio = entrada.nextInt();
		// while (inicio != 0) {
		if (inicio == 1) {
			System.out.println("Seja Bem-Vindo(a) a BATALHA FINAL!");

			System.out.printf("Escolha um n�vel de jogo: %n 1 - F�cil  %n 2 - Normal %n 3 - Dif�cil");
			int nivel = entrada.nextInt();

			switch (nivel) {
			case 1:
				System.out.printf("Voc� escolheu o n�vel f�cil, correto? %n1 - Sim %n2 - N�o, alterar.");
				int confirmacao = entrada.nextInt();
				if (confirmacao == 1) {
					nivel = 1;
				} else {
					System.out.printf("Escolha um n�vel de jogo: %n 1 - F�cil  %n 2 - Normal %n 3 - Dif�cil");
					nivel = entrada.nextInt();
				}
				break;
			case 2:
				System.out.printf("Voc� escolheu o n�vel normal, correto? %n1 - Sim %n2 - N�o, alterar.");
				confirmacao = entrada.nextInt();
				if (confirmacao == 1) {
					nivel = 2;
				} else {
					System.out.printf("Escolha um n�vel de jogo: %n 1 - F�cil  %n 2 - Normal %n 3 - Dif�cil");
					nivel = entrada.nextInt();
				}
				break;
			case 3:
				System.out.printf("Voc� escolheu o n�vel dif�cil, correto? %n1 - Sim %n2 - N�o, alterar.");
				confirmacao = entrada.nextInt();
				if (confirmacao == 1) {
					nivel = 3;
				} else {
					System.out.printf("Escolha um n�vel de jogo: %n 1 - F�cil  %n 2 - Normal %n 3 - Dif�cil");
					nivel = entrada.nextInt();
				}
				break;
			default:
				while (nivel != 1 && nivel != 2 && nivel != 3) {
					System.out.println("Entrada inv�lida!");
					System.out.printf("Escolha um n�vel de jogo: %n 1 - F�cil  %n 2 - Normal %n 3 - Dif�cil");
					nivel = entrada.nextInt();
				}
				break;
			}

			System.out.println(entrada.nextLine());
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.println("De um nome ao seu avatar");
			String nome = entrada.nextLine().toUpperCase();
			if (nome.length() > 0) {
				System.out.printf("O nome do seu avatar ser� %s, confirmar? %n1 - Sim %n2 - N�o, alterar", nome);
				int confirmacaoNome = entrada.nextInt();
				if (confirmacaoNome == 1) {
					System.out.printf("Nome do Avatar: %s ", nome);
				} else {
					System.out.println("Altere o nome do seu avatar");
					nome = entrada.nextLine();
				}
			}

			System.out.println(entrada.nextLine());
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.printf("Escolha um sexo para o seu avatar: %n 1 - Feminino %n 2 - Masculino ");
			int sexoAvatar = entrada.nextInt();
			if (sexoAvatar == 1) {
				System.out.printf("O seu avatar ser� do sexo FEMININO, confirmar? %n1 - Sim %n2 - N�o, alterar");
				int confirmacaoSexo = entrada.nextInt();
				if (confirmacaoSexo == 1) {
					System.out.println("Sexo do Avatar: FEMININO ");
				} else {
					System.out.println("Altere o sexo do seu avatar");
					System.out.printf("Escolha um sexo para o seu avatar: %n 1 - Feminino %n 2 - Masculino ");
					sexoAvatar = entrada.nextInt();
				}
			} else {
				System.out.printf("O seu avatar ser� do sexo MASCULINO, confirmar? %n1 - Sim %n2 - N�o, alterar");
				int confirmacaoSexo = entrada.nextInt();
				if (confirmacaoSexo == 1) {
					System.out.println("Sexo do Avatar: MASCULINO ");
				} else {
					System.out.println("Altere o sexo do seu avatar");
					System.out.printf("Escolha um sexo para o seu avatar: %n 1 - Feminino %n 2 - Masculino ");
					sexoAvatar = entrada.nextInt();
				}
			}

			System.out.println(entrada.nextLine());
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.printf("Escolha uma classe de combate: %n G - Guerreiro %n M - Mago %n C - Ca�ador");
			String classeCombate = entrada.nextLine().toUpperCase();
			if (classeCombate.equals("G")) {
				System.out.println("Voc� escolheu a classe Guerreiro, confirmar? 1 - Sim  2 - N�o");
				int confirmacaoClasse = entrada.nextInt();
				if (confirmacaoClasse == 1) {
					System.out.println("Classe de combate: GUERREIRO ");
				} else {
					System.out.println("Altere a classe de combate do seu avatar");
					System.out.printf("Escolha uma classe de combate: %n G - Guerreiro %n M - Mago %n C - Ca�ador");
					classeCombate = entrada.nextLine();
				}
			} else if (classeCombate.equals("M")) {
				System.out.println("Voc� escolheu a classe Mago, confirmar? 1 - Sim  2 - N�o");
				int confirmacaoClasse = entrada.nextInt();
				if (confirmacaoClasse == 1) {
					System.out.println("Classe de combate: MAGO ");
				} else {
					System.out.println("Altere a classe de combate do seu avatar");
					System.out.printf("Escolha uma classe de combate: %n G - Guerreiro %n M - Mago %n C - Ca�ador");
					classeCombate = entrada.nextLine();
				}
			} else if (classeCombate.equals("C")) {
				System.out.println("Voc� escolheu a classe Ca�ador, confirmar? 1 - Sim  2 - N�o");
				int confirmacaoClasse = entrada.nextInt();
				if (confirmacaoClasse == 1) {
					System.out.println("Classe de combate: CA�ADOR ");
				} else {
					System.out.println("Altere a classe de combate do seu avatar");
					System.out.printf("Escolha uma classe de combate: %n G - Guerreiro %n M - Mago %n C - Ca�ador");
					classeCombate = entrada.nextLine();
				}
			} else {
				System.out.println("Classe de combate inv�lida!");
				System.out.printf("Escolha uma classe de combate: %n G - Guerreiro %n M - Mago %n C - Ca�ador");
				classeCombate = entrada.nextLine();
			}

			System.out.println(entrada.nextLine());
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.println("Escolha do armamento: ");
			String armas = "";
			if (classeCombate.equals("G")) {
				armas = "martelo, espada, cajado";

			}
			System.out.println(armas);

			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.printf(
					"A noite se aproxima, a lua j� surge no c�u, estrelas v�o se acendendo, e sob a luz do crep�sculo voc� est� prestes a entrar na fase final da sua miss�o."
							+ "%nVoc� olha para o portal � sua frente, e sabe que a partir desse ponto, sua vida mudar� para sempre. "
							+ "%n%nMem�rias do caminho percorrido para chegar at� aqui invadem sua mente. "
							+ "%nVoc� se lembra de todos os inimigos j� derrotados para alcan�ar o covil do l�der maligno. "
							+ "%nOlha para seu equipamento de combate, j� danificado e desgastado depois de tantas lutas. "
							+ "%nVoc� est� a um passo de encerrar para sempre esse mal."
							+ "%n%nBuscando uma inje��o de �nimo, voc� se for�a a lembrar o que te trouxe at� aqui.");
			System.out.printf("Escolha da motiva��o: %n 1 - VINGAN�A %n 2 - GL�RIA ");
			int escolhaMotivacao = entrada.nextInt();
			switch (escolhaMotivacao) {
			case 1:
				System.out.printf(
						"Imagens daquela noite tr�gica invadem sua mente. %nVoc� nem precisa se esfor�ar para lembrar, pois essas mem�rias est�o sempre presentes, %nmesmo que de pano de fundo, quando voc� tem outros pensamentos em foco, elas nunca o deixaram. %nElas s�o o combust�vel que te fizeram chegar at� aqui. %nE voc� sabe que n�o ir� desistir at� ter vingado a morte daqueles que foram - e pra sempre ser�o - sua fonte de amor e desejo de continuar vivo. %nO maldito l�der finalmente pagar� por tanto mal causado na vida de tantos (e principalmente na sua).");
				break;
			case 2:
				System.out.printf(
						"Voc� j� consegue visualizar na sua mente o povo da cidade te recebendo de bra�os abertos, %nbardos criando can��es sobre seus feitos her�icos, nobres te presenteando com j�ias e diversas riquezas, %ntaberneiros se recusando a cobrar por suas bebedeiras e comilan�as. %nDesde j�, voc� sente o amor do p�blico, te louvando a cada passo que d� pelas ruas, depois de %ndestruir o vil�o que tanto assombrou a paz de todos. Por�m, voc� sabe que ainda falta o �ltimo ato dessa hist�ria. %nVoc� se concentra na miss�o. A gl�ria o aguarda, mas n�o antes da �ltima batalha.");
				break;
			default:
				System.out.println("Escolha inv�lida, tente novamente");
				System.out.printf("Escolha da motiva��o: %n 1 - VINGAN�A %n 2 - GL�RIA ");
				escolhaMotivacao = entrada.nextInt();
				break;
			}

			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.printf(
					"Inspirado pelo motivo que te trouxe at� aqui, voc� sente seu cora��o ardendo em chamas, suas m�os formigarem em volta da sua arma. Voc� a segura com firmeza. Seu foco est� renovado. Voc� avan�a pelo portal.%n"
							+ "%n"
							+ "A escurid�o te envolve. Uma ilumina��o muito fraca entra pelo portal �s suas costas. � sua frente, s� � poss�vel perceber que voc� se encontra em um corredor extenso. Voc� s� pode ir � frente, ou desistir.%n");
			System.out.printf("O que voc� deseja? %n 1 - Seguir em frente %n 2 - Desistir");
			int escolhaSeguimentoJogo = entrada.nextInt();
			switch (escolhaSeguimentoJogo) {
			case 1:
				System.out.printf(
						"Voc� caminha, atento a todos os seus sentidos, por v�rios metros, %nat� visualizar a frente uma fonte de luz, que voc� imagina ser a chama de uma tocha, %nvindo de dentro de uma porta aberta.");

				break;
			case 2:
				System.out.printf(
						"O medo invade o seu cora��o e voc� sente que ainda n�o est� � altura do desafio. %nVoc� se volta para a noite l� fora e corre em dire��o � seguran�a.%n");
				System.out.println("JOGO ENCERRADO!");
				entrada.close();
				break;
			default:
				System.out.println("Escolha inv�lida, tente novamente");
				System.out.printf("O que voc� deseja? %n 1 - Seguir em frente %n 2 - Desistir");
				escolhaSeguimentoJogo = entrada.nextInt();
			}

			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.printf(
					"Voc� se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha, %ne pondera sobre como passar pela porta.");
			System.out.printf("1 - Andando cuidadosamente %n2 - Correndo %n3 - Saltando");
			int modoDeAndar = entrada.nextInt();
			switch (modoDeAndar) {
			case 1:
				System.out.printf(
						"Voc� toma cuidado e vai caminhando vagarosamente em dire��o � luz. Quando voc� pisa exatamente embaixo da porta, voc� sente o ch�o ceder levemente, como se tivesse pisado em uma pedra solta. Voc� ouve um ru�do de mecanismos se movimentando, e uma escotilha se abre no teto atr�s de voc�, no corredor. Flechas voam da escotilha em sua dire��o, e voc� salta para dentro da sala, por�m uma delas te acerta na perna.");
				// [toma dano utilizando mecanismo de ataque descrito abaixo, por�m o rolamento
				// de dados � s� de 1-10]
				break;
			case 2:
				System.out.printf(
						"Voc� respira fundo e desata a correr em dire��o � sala. Quando passa pela porta, sente que pisou em uma pedra solta, mas n�o d� muita import�ncia e segue para dentro da sala, olhando ao redor � procura de inimigos. N�o tem ningu�m, mas voc� ouve sons de flechas batendo na pedra atr�s de voc�, e quando se vira, v� v�rias flechas no ch�o. Espiando pela porta, voc� entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto, mas por sorte voc� entrou correndo e conseguiu escapar desse ataque surpresa.");
				break;
			case 3:
				System.out.printf("Voc� se concentra e pula em dire��o � luz, saltando de antes da porta at� o interior da sala.");
				break;

			default:
				System.out.println("Escolha inv�lida, tente novamente");
				System.out.printf("1 - Andando cuidadosamente %n2 - Correndo %n3 - Saltando");
				modoDeAndar = entrada.nextInt();
			}

			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.println(
					"Voc� se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede. Uma delas foi aquela pela qual voc� entrou, que estava aberta, e as outras tr�s est�o fechadas. A porta � sua frente � a maior das quatro, com inscri��es em seu entorno em uma l�ngua que voc� n�o sabe ler, mas reconhece como sendo a l�ngua antiga utilizada pelo inimigo. Voc� se aproxima da porta e percebe que ela est� trancada por duas fechaduras douradas, e voc� entende que precisar� primeiro derrotar o que estiver nas outras duas portas laterais, antes de conseguir enfrentar o l�der.\r\n"
							+ "\r\n" + "Voc� se dirige para a porta � direita.\r\n" + "");
			
			System.out.println("::::::::::::::::::::::::::::::::::PORTA DIREITA:::::::::::::::::::::::::::::::::::::::");
			System.out.printf("Voc� se aproxima, tentando ouvir o que acontece porta adentro, mas n�o escuta nada. Segura com mais for�a sua arma com uma m�o, enquanto empurra a porta com a outra. Ao entrar, voc� se depara com uma sala espa�osa, com v�rios equipamentos de batalha pendurados nas paredes e dispostos em arm�rios e mesas. Voc� imagina que este seja o arsenal do inimigo, onde est�o guardados os equipamentos que seus soldados utilizam quando saem para espalhar o terror nas cidades e vilas da regi�o.\r\n"
					+ "\r\n"
					+ "Enquanto seu olhar percorre a sala, voc� ouve a porta se fechando e gira rapidamente para olhar para tr�s. Ali, de p� entre voc� e a porta fechada, bloqueando o caminho do seu destino, est� um dos capit�es do inimigo. Um orque horrendo, de armadura, capacete e espada em punho, em posi��o de combate. Ele avan�a em sua dire��o.\r\n"
					+ "");
			
			
			System.out.println("Loop de combate");
			
			
			//caso ven�a o combate e queira continuar: contiunua...
			
			System.out.printf("Ap�s derrotar o Armeiro, voc� percebe que seus equipamentos est�o muito danificados, e olha em volta, encarando todas aquelas pe�as de armaduras resistentes e em �timo estado.");
			
			System.out.println("Decidi se usa a armadura ou n�o ");
			
			/*
			 * [jogador escolhe pegar ou n�o as armaduras novas.
Se escolher pegar, o jogo deve exibir a mensagem: �Voc� resolve usar os equipamentos do inimigo contra ele, e trocar algumas pe�as suas, que estavam danificadas, pelas pe�as de armaduras existentes na sala. De armadura nova, voc� se sente mais protegido para os desafios � sua frente.� O jogo deve acrescentar +5 pontos de defesa para o jogador.
Se escolher n�o pegar, o jogo deve exibir a mensagem: �Voc� decide que n�o precisa utilizar nada que venha das m�os do inimigo.�]

			 * */
			
			System.out.printf("Em uma mesa, voc� encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras da porta do l�der inimigo. Voc� pega a chave e guarda numa pequena bolsa que leva presa ao cinto.");
			
			
			System.out.println("::::::::::::::::::::::::::::::::::PORTA ESQUERDA:::::::::::::::::::::::::::::::::::::::");
			System.out.printf("Voc� retorna � sala anterior e se dirige � porta da esquerda. Voc� se aproxima, tentando ouvir o que acontece porta adentro, mas n�o escuta nada. Segura com mais for�a sua arma com uma m�o, enquanto empurra a porta com a outra. Ao entrar, voc� se depara com uma sala parecida com a do arsenal, mas em vez de armaduras, existem v�rios potes e garrafas de vidro com conte�dos misteriosos e de cores diversas, e voc� entende que o capit�o que vive ali, realiza experimentos com diversos ingredientes, criando po��es utilizadas pelos soldados para aterrorizar a regi�o.\r\n"
					+ "No fundo da sala, olhando em sua dire��o, est� outro dos capit�es do inimigo. Um orque horrendo, de armadura, cajado em punho, em posi��o de combate. Ele avan�a em sua dire��o.\r\n"
					+ "");
			
			System.out.println("Loop de combate");
			
			
			//caso ven�a o combate e queira continuar: continua...
			
			System.out.printf("Ap�s derrotar o Alquimista, voc� olha em volta, tentando reconhecer alguma po��o do estoque do inimigo. Em uma mesa, voc� reconhece uma pequena garrafa de vidro contendo um l�quido levemente rosado, pega a garrafa e pondera se deve beber um gole.");
			
			/*
			 * [jogador escolhe entre beber ou n�o. Se beber, o jogo exibe a mensagem: �Voc� se sente revigorado para seguir adiante!� e recupera 100% dos pontos de vida do jogador. Se n�o beber, o jogo exibe a mensagem: �Voc� fica receoso de beber algo produzido pelo inimigo�.]
			 * */
			
			System.out.printf("abre a outra fechadura da porta do l�der inimigo. Voc� pega a chave e guarda na pequena bolsa que leva presa ao cinto.\r\n"
					+ "\r\n"
					+ "De volta � sala das portas, voc� se dirige � porta final. Coloca as chaves nas fechaduras, e a porta se abre. Seu cora��o acelera, mem�rias de toda a sua vida passam pela sua mente, e voc� percebe que est� muito pr�ximo do seu objetivo final. Segura sua arma com mais firmeza, foca no combate que voc� sabe que ir� se seguir, e adentra a porta.\r\n"
					+ "\r\n"
					+ "L� dentro, voc� v� o l�der sentado em uma poltrona dourada, com duas fogueiras de cada lado, e prisioneiros acorrentados �s paredes.\r\n"
					+ "\r\n"
					+ "Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de l�mina dupla.\r\n"
					+ "");
			
			System.out.println("::::::::::::::::::::::::::::::::::PORTA FINAL:::::::::::::::::::::::::::::::::::::::");
			System.out.println("Jogador decidi se Ataca ou Espera");
			System.out.println("Loop de combate");
			
			//caso ven�a: VIT�RIAAAAA
			
			
			System.out.println("Voc� conseguiu!");
			
			System.out.println("Mensagem de acordo com a MOTIVA��O");
			
			//VINGAN�A
			System.out.printf("Voc� obteve sua vingan�a. Voc� se ajoelha e cai no choro, invadido por uma sensa��o de al�vio e felicidade. Voc� se vingou, tudo que sempre quis, est� feito. Agora voc� pode seguir sua vida.");
			
			//GL�RIA
			System.out.printf("O �xtase em que voc� se encontra n�o cabe dentro de si. Voc� se ajoelha e grita de alegria. A gl�ria o aguarda, voc� a conquistou.");

			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			
			System.out.println("Voc� se levanta, olha para os prisioneiros, vai de um em um e os liberta, e todos voc�s saem em dire��o � noite, retornando � cidade. Seu dever est� cumprido.");
			
			System.out.println("JOGO ENCERRADO!");
			
			
		} else if (inicio == 2) {
			System.out.println("Jogo encerrado!");
			entrada.close();
		} else {
			System.out.println("Entrada inv�lida! Tente novamente");
			System.out.printf("Iniciar o jogo:%n 1 - Sim %n 2 - N�o");
			inicio = entrada.nextInt();
		}
		// }

		entrada.close();
	}
}
