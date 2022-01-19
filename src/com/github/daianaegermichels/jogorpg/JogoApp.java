package com.github.daianaegermichels.jogorpg;

import java.util.Scanner;

import com.github.daianaegermichels.jogorpg.entidades.Cacador;
import com.github.daianaegermichels.jogorpg.entidades.Combate;
import com.github.daianaegermichels.jogorpg.entidades.Guerreiro;
import com.github.daianaegermichels.jogorpg.entidades.Jogador;
import com.github.daianaegermichels.jogorpg.entidades.Mago;

public class JogoApp {
	static Scanner entrada = new Scanner(System.in);
	static Combate combate = new Combate();
	static Jogador jogador = new Jogador();

	public static void main(String[] args) {

		int inicio;
		do {
			System.out.printf("Iniciar o jogo:%n 1 - Sim %n 2 - N�o");
			inicio = entrada.nextInt();
			// while (inicio != 0) {

			if (inicio == 1) {
				System.out.println("Seja Bem-Vindo(a) a BATALHA FINAL!");

				int nivel;
				do {
					System.out.printf("Escolha um n�vel de jogo: %n 1 - F�cil  %n 2 - Normal %n 3 - Dif�cil");
					nivel = entrada.nextInt();
					int confirmacao = 0;
					do {
						switch (nivel) {
						case 1:
							System.out.printf("Voc� escolheu o n�vel f�cil, correto? %n1 - Sim %n2 - N�o, alterar.");
							confirmacao = entrada.nextInt();
							if (confirmacao == 1) {
								nivel = 1;
								break;
							} else {
								System.out
										.printf("Escolha um n�vel de jogo: %n 1 - F�cil  %n 2 - Normal %n 3 - Dif�cil");
								nivel = entrada.nextInt();
							}
							break;
						case 2:
							System.out.printf("Voc� escolheu o n�vel normal, correto? %n1 - Sim %n2 - N�o, alterar.");
							confirmacao = entrada.nextInt();
							if (confirmacao == 1) {
								nivel = 2;
								break;
							} else {
								System.out
										.printf("Escolha um n�vel de jogo: %n 1 - F�cil  %n 2 - Normal %n 3 - Dif�cil");
								nivel = entrada.nextInt();
							}
							break;
						case 3:
							System.out.printf("Voc� escolheu o n�vel dif�cil, correto? %n1 - Sim %n2 - N�o, alterar.");
							confirmacao = entrada.nextInt();
							if (confirmacao == 1) {
								nivel = 3;
								break;
							} else {
								System.out
										.printf("Escolha um n�vel de jogo: %n 1 - F�cil  %n 2 - Normal %n 3 - Dif�cil");
								nivel = entrada.nextInt();
							}
							break;
						default:

							System.out.println("Entrada inv�lida!");

						}
					} while (confirmacao != 1);

				} while (nivel != 1 && nivel != 2 && nivel != 3);

				System.out.println(entrada.nextLine());
				System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

				String nomeAvatar;

				do {
					System.out.println("De um nome ao seu avatar");

					nomeAvatar = entrada.nextLine().toUpperCase();

					if (nomeAvatar.length() > 0) {
						int confirmacaoNome;
						do {
							System.out.printf("%nO nome do seu avatar ser� %s, confirmar? %n1 - Sim %n2 - N�o",
									nomeAvatar);
							confirmacaoNome = entrada.nextInt();

							if (confirmacaoNome == 1) {
								jogador.setNome(nomeAvatar);
								System.out.printf("Nome do Avatar: %s ", jogador.getNome());
							} else if (confirmacaoNome == 2) {
								entrada.nextLine();
								System.out.println("Altere o nome do seu avatar");
								nomeAvatar = entrada.nextLine().toUpperCase();
								jogador.setNome(nomeAvatar);
								System.out.printf("Nome do Avatar: %s ", jogador.getNome());

							} else {
								System.out.printf("%nEntrada inv�lida!%n");
							}
						} while (confirmacaoNome != 1 && confirmacaoNome != 2);
					}
				} while (nomeAvatar.length() == 0);

				System.out.println(entrada.nextLine());
				System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

				int sexoAvatar;
				do {
					System.out.printf("%nEscolha um sexo para o seu avatar: %n 1 - Feminino %n 2 - Masculino ");
					sexoAvatar = entrada.nextInt();
					int confirmacaoSexo;

					if (sexoAvatar == 1) {
						do {
							System.out.printf(
									"O seu avatar ser� do sexo FEMININO, confirmar? %n1 - Sim %n2 - N�o, alterar");
							confirmacaoSexo = entrada.nextInt();
							if (confirmacaoSexo == 1) {
								System.out.println("Sexo do Avatar: FEMININO ");
								jogador.setSexo(sexoAvatar);
							} else {
								System.out.println("Altere o sexo do seu avatar");
								System.out.printf(
										"%nEscolha um sexo para o seu avatar: %n 1 - Feminino %n 2 - Masculino ");
								sexoAvatar = entrada.nextInt();
							}
						} while (confirmacaoSexo != 1 && confirmacaoSexo != 2);
					} else {
						do {
							System.out.printf(
									"O seu avatar ser� do sexo MASCULINO, confirmar? %n1 - Sim %n2 - N�o, alterar");
							confirmacaoSexo = entrada.nextInt();
							if (confirmacaoSexo == 1) {
								System.out.println("Sexo do Avatar: MASCULINO ");
								jogador.setSexo(sexoAvatar);
							} else {
								System.out.println("Altere o sexo do seu avatar");
								System.out.printf(
										"%nEscolha um sexo para o seu avatar: %n 1 - Feminino %n 2 - Masculino ");
								sexoAvatar = entrada.nextInt();
							}
						} while (confirmacaoSexo != 1 && confirmacaoSexo != 2);
					}
				} while (sexoAvatar != 1 && sexoAvatar != 2);

				System.out.println(entrada.nextLine());
				int arma;
				int armaJogador = 0;
				System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
				String classeCombate;
				int confirmacaoClasse;
				do {
					System.out.printf("%nEscolha uma classe de combate: %n G - Guerreiro %n M - Mago %n C - Ca�ador");
					classeCombate = entrada.nextLine().toUpperCase();
					if (classeCombate.equals("G")) {
						do {
							System.out.println("Voc� escolheu a classe Guerreiro, confirmar? 1 - Sim  2 - N�o");
							confirmacaoClasse = entrada.nextInt();
							if (confirmacaoClasse == 1) {
								System.out.println("Classe de combate: GUERREIRO ");
								Guerreiro guerreiro = new Guerreiro(nomeAvatar, sexoAvatar);
								System.out.printf(
										"%nEscolha uma arma para o combate: %n1 - Martelo %n2 - Machado %n3 - Espada %n4 - Clava");
								arma = entrada.nextInt();
								armaJogador = guerreiro.setArma(arma);
								System.out.println(armaJogador);
							} else {
								System.out.println("Altere a classe de combate do seu avatar");
								System.out.printf(
										"%nEscolha uma classe de combate: %n G - Guerreiro %n M - Mago %n C - Ca�ador");
								classeCombate = entrada.nextLine();
							}
						} while (confirmacaoClasse != 1 && confirmacaoClasse != 2);
					} else if (classeCombate.equals("M")) {
						do {
							System.out.println("Voc� escolheu a classe Mago, confirmar? 1 - Sim  2 - N�o");
							confirmacaoClasse = entrada.nextInt();
							if (confirmacaoClasse == 1) {
								System.out.println("Classe de combate: MAGO ");
								Mago mago = new Mago(nomeAvatar, sexoAvatar);
								System.out.printf("%nEscolha uma arma para o combate: %n1 - Livro %n2 - Cajado");
								arma = entrada.nextInt();
								armaJogador = mago.setArma(arma);
								System.out.println(armaJogador);
							} else {
								System.out.println("Altere a classe de combate do seu avatar");
								System.out.printf(
										"%nEscolha uma classe de combate: %n G - Guerreiro %n M - Mago %n C - Ca�ador");
								classeCombate = entrada.nextLine();
							}
						} while (confirmacaoClasse != 1 && confirmacaoClasse != 2);
					} else if (classeCombate.equals("C")) {
						do {
							System.out.println("Voc� escolheu a classe Ca�ador, confirmar? 1 - Sim  2 - N�o");
							confirmacaoClasse = entrada.nextInt();
							if (confirmacaoClasse == 1) {
								System.out.println("Classe de combate: CA�ADOR ");
								Cacador cacador = new Cacador(nomeAvatar, sexoAvatar);
								System.out.printf(
										"%nEscolha uma arma para o combate: %n1 - Arco e Flecha %n2 - Besta e Virote");
								arma = entrada.nextInt();
								armaJogador = cacador.setArma(arma);
								System.out.println(armaJogador);
							} else {
								System.out.printf("%nAltere a classe de combate do seu avatar");
								System.out.printf(
										"%nEscolha uma classe de combate: %n G - Guerreiro %n M - Mago %n C - Ca�ador");
								classeCombate = entrada.nextLine();
							}
						} while (confirmacaoClasse != 1 && confirmacaoClasse != 2);
					} else {
						System.out.printf("%nClasse de combate inv�lida!");
						// System.out
						// .printf("%nEscolha uma classe de combate: %n G - Guerreiro %n M - Mago %n C -
						// Ca�ador");
						// classeCombate = entrada.nextLine();
					}
				} while (!classeCombate.equals("G") && !classeCombate.equals("M") && !classeCombate.equals("C"));

				System.out.println(entrada.nextLine());

				System.out.printf("%n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::%n");
				System.out.printf(
						"%nA noite se aproxima, a lua j� surge no c�u, estrelas v�o se acendendo, e sob a luz do crep�sculo voc� est� prestes a entrar na fase final da sua miss�o."
								+ "%nVoc� olha para o portal � sua frente, e sabe que a partir desse ponto, sua vida mudar� para sempre. "
								+ "%n%nMem�rias do caminho percorrido para chegar at� aqui invadem sua mente. "
								+ "%nVoc� se lembra de todos os inimigos j� derrotados para alcan�ar o covil do l�der maligno. "
								+ "%nOlha para seu equipamento de combate, j� danificado e desgastado depois de tantas lutas. "
								+ "%nVoc� est� a um passo de encerrar para sempre esse mal."
								+ "%n%nBuscando uma inje��o de �nimo, voc� se for�a a lembrar o que te trouxe at� aqui.");
				System.out.printf("%n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::%n");

				String escolhaMotivacao;

				do {
					System.out.printf(
							"%nEscolha sua motiva��o para invadir a caverna do inimigo e derrot�-lo: %n V - VINGAN�A %n G - GL�RIA ");
					escolhaMotivacao = entrada.nextLine().toUpperCase();
					switch (escolhaMotivacao) {
					case "V":
						System.out.printf(
								"Imagens daquela noite tr�gica invadem sua mente. %nVoc� nem precisa se esfor�ar para lembrar, pois essas mem�rias est�o sempre presentes, %nmesmo que de pano de fundo, quando voc� tem outros pensamentos em foco, elas nunca o deixaram. %nElas s�o o combust�vel que te fizeram chegar at� aqui. %nE voc� sabe que n�o ir� desistir at� ter vingado a morte daqueles que foram - e pra sempre ser�o - sua fonte de amor e desejo de continuar vivo. %nO maldito l�der finalmente pagar� por tanto mal causado na vida de tantos (e principalmente na sua).");
						break;
					case "G":
						System.out.printf(
								"Voc� j� consegue visualizar na sua mente o povo da cidade te recebendo de bra�os abertos, %nbardos criando can��es sobre seus feitos her�icos, nobres te presenteando com j�ias e diversas riquezas, %ntaberneiros se recusando a cobrar por suas bebedeiras e comilan�as. %nDesde j�, voc� sente o amor do p�blico, te louvando a cada passo que d� pelas ruas, depois de %ndestruir o vil�o que tanto assombrou a paz de todos. Por�m, voc� sabe que ainda falta o �ltimo ato dessa hist�ria. %nVoc� se concentra na miss�o. A gl�ria o aguarda, mas n�o antes da �ltima batalha.");
						break;
					default:
						System.out.println("Escolha inv�lida, tente novamente");
						// System.out.printf("Escolha da motiva��o: %n V - VINGAN�A %n G - GL�RIA ");
						// escolhaMotivacao = entrada.nextLine().toUpperCase();

					}
				} while (!escolhaMotivacao.equals("V") && !escolhaMotivacao.equals("G"));

				System.out.printf("%n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::%n");

				System.out.printf(
						"%nInspirado pelo motivo que te trouxe at� aqui, voc� sente seu cora��o ardendo em chamas, suas m�os formigarem em volta da sua arma. Voc� a segura com firmeza. Seu foco est� renovado. Voc� avan�a pelo portal.%n"
								+ "%n"
								+ "A escurid�o te envolve. Uma ilumina��o muito fraca entra pelo portal �s suas costas. � sua frente, s� � poss�vel perceber que voc� se encontra em um corredor extenso. Voc� s� pode ir � frente, ou desistir.%n");

				System.out.printf("%n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::%n");

				int escolhaSeguimentoJogo;
				do {
					System.out.printf("%nO que voc� deseja? %n 1 - Seguir em frente %n 2 - Desistir");
					escolhaSeguimentoJogo = entrada.nextInt();
					switch (escolhaSeguimentoJogo) {
					case 1:
						System.out.printf(
								"Voc� caminha, atento a todos os seus sentidos, por v�rios metros, %nat� visualizar a frente uma fonte de luz, que voc� imagina ser a chama de uma tocha, %nvindo de dentro de uma porta aberta.");

						break;
					case 2:
						System.out.printf(
								"O medo invade o seu cora��o e voc� sente que ainda n�o est� � altura do desafio. %nVoc� se volta para a noite l� fora e corre em dire��o � seguran�a.%n");
						System.out.printf("%nJOGO ENCERRADO!");
						entrada.close();
						break;
					default:
						System.out.printf("%nEscolha inv�lida, tente novamente");
						// System.out.printf("O que voc� deseja? %n 1 - Seguir em frente %n 2 -
						// Desistir");
						// escolhaSeguimentoJogo = entrada.nextInt();
					}
				} while (escolhaSeguimentoJogo != 1 && escolhaSeguimentoJogo != 2);

				System.out.printf("%n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::%n");
				System.out.printf(
						"%nVoc� se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha, %ne pondera sobre como passar pela porta.");

				int modoDeAndar;
				do {
					System.out.printf("%n1 - Andando cuidadosamente %n2 - Correndo %n3 - Saltando");
					modoDeAndar = entrada.nextInt();
					switch (modoDeAndar) {
					case 1:
						System.out.printf(
								"%nVoc� toma cuidado e vai caminhando vagarosamente em dire��o � luz. %nQuando voc� pisa exatamente embaixo da porta, voc� sente o ch�o ceder levemente, como se tivesse pisado em uma pedra solta. %nVoc� ouve um ru�do de mecanismos se movimentando, e uma escotilha se abre no teto atr�s de voc�, no corredor. %nFlechas voam da escotilha em sua dire��o, e voc� salta para dentro da sala, %npor�m uma delas te acerta na perna.");
						break;
					case 2:
						System.out.printf(
								"%nVoc� respira fundo e desata a correr em dire��o � sala. %nQuando passa pela porta, sente que pisou em uma pedra solta, mas n�o d� muita import�ncia e segue para dentro da sala, %nolhando ao redor � procura de inimigos. N�o tem ningu�m, mas voc� ouve sons de %nflechas batendo na pedra atr�s de voc�, e quando se vira, v� v�rias flechas no ch�o. %nEspiando pela porta, voc� entende que pisou em uma armadilha que soltou flechas %nde uma escotilha aberta no teto, mas por sorte voc� entrou correndo e %nconseguiu escapar desse ataque surpresa.");
						break;
					case 3:
						System.out.printf(
								"%nVoc� se concentra e pula em dire��o � luz, saltando de antes da porta at� o interior da sala.");
						break;

					default:
						System.out.printf("%nEscolha inv�lida, tente novamente");
						// System.out.printf("%n1 - Andando cuidadosamente %n2 - Correndo %n3 -
						// Saltando");
						// modoDeAndar = entrada.nextInt();
					}
				} while (modoDeAndar != 1 && modoDeAndar != 2 && modoDeAndar != 3);

				System.out.printf("%n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::%n");
				System.out.printf(
						"%nVoc� se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede. %nUma delas foi aquela pela qual voc� entrou, que estava aberta, e as outras tr�s est�o fechadas. %nA porta � sua frente � a maior das quatro, com inscri��es em seu entorno em uma l�ngua que voc� n�o sabe ler, %nmas reconhece como sendo a l�ngua antiga utilizada pelo inimigo. %nVoc� se aproxima da porta e percebe que ela est� trancada por duas fechaduras douradas, %ne voc� entende que precisar� primeiro derrotar o que estiver nas outras duas portas laterais, %nantes de conseguir enfrentar o l�der."
								+ "%n" + "%nVoc� se dirige para a porta � direita." + "%n");

				System.out.printf(
						"%n::::::::::::::::::::::::::::::::::PORTA DIREITA:::::::::::::::::::::::::::::::::::::::%n");
				System.out
						.printf("%nVoc� se aproxima, tentando ouvir o que acontece porta adentro, mas n�o escuta nada. "
								+ "%nSegura com mais for�a sua arma com uma m�o, enquanto empurra a porta com a outra. "
								+ "%nAo entrar, voc� se depara com uma sala espa�osa, com v�rios equipamentos de batalha pendurados "
								+ "%nnas paredes e dispostos em arm�rios e mesas. "
								+ "%nVoc� imagina que este seja o arsenal do inimigo, onde est�o guardados os equipamentos que seus "
								+ "%nsoldados utilizam quando saem para espalhar o terror nas cidades e vilas da regi�o."
								+ "%n"
								+ "%nEnquanto seu olhar percorre a sala, voc� ouve a porta se fechando e gira rapidamente para olhar para tr�s. "
								+ "%nAli, de p� entre voc� e a porta fechada, bloqueando o caminho do seu destino, "
								+ "%nest� um dos capit�es do inimigo. Um orque horrendo, de armadura, capacete e espada em punho, "
								+ "%nem posi��o de combate. Ele avan�a em sua dire��o." + "%n");
				System.out.printf("%n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::%n");

				int continua;

				do {
					System.out.printf("O que voc� deseja fazer? %n1 - Seguir em frente %n2 - Fugir");

					continua = entrada.nextInt();

					switch (continua) {
					case 1:
						combate.combatePortaDireita(continua, nivel, armaJogador, modoDeAndar, escolhaMotivacao,
								classeCombate);
						break;
					case 2:
						System.out.printf("%nVoc� n�o estava preparado para a for�a do inimigo, "
								+ "%ne decide fugir para que possa tentar novamente em uma pr�xima vez.");
						break;
					default:
						System.out.printf("%nEntrada Inv�lida!");

					}
				} while (continua != 1 && continua != 2);

				int escolhaArmaduraNova;
				if (combate.combatePortaDireita(continua, nivel, armaJogador, modoDeAndar, escolhaMotivacao,
						classeCombate) == 1) {
					System.out.printf(
							"%nAp�s derrotar o Armeiro, voc� percebe que seus equipamentos est�o muito danificados, "
									+ "%ne olha em volta, encarando todas aquelas pe�as de armaduras resistentes e em �timo estado.");

					do {
						System.out.printf("%nVoc� deseja substituir sua armadura por uma nova? %n1 - Sim %n2 - N�o ");

						escolhaArmaduraNova = entrada.nextInt();

						if (escolhaArmaduraNova == 1) {

							System.out.printf("%n�Voc� resolve usar os equipamentos do"
									+ "%ninimigo contra ele, e trocar algumas pe�as suas, que estavam danificadas, pelas pe�as de"
									+ "%narmaduras existentes na sala. De armadura nova, voc� se sente mais protegido para os desafios"
									+ "%n� sua frente.");
						} else if (escolhaArmaduraNova == 2) {

							System.out.printf(
									"%nVoc� decide que n�o precisa utilizar nada que venha das m�os do inimigo.");
						} else {

							System.out.println("Escolha inv�lida!");
							// System.out.printf("%nVoc� deseja substituir sua armadura por uma nova? %1 -
							// Sim %n2 - N�o ");
							// escolhaArmaduraNova = entrada.nextInt();
						}
					} while (escolhaArmaduraNova != 1 && escolhaArmaduraNova != 2);
				} else {
					System.out.printf(
							"%nVoc� n�o estava preparado para a for�a do inimigo, e decide fugir para que possa tentar novamente em uma pr�xima vez."
									+ "%n JOGO ENCERRADO!");
					break;
				}

				System.out.printf("%n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::%n");

				do {
					System.out.printf("O que voc� deseja fazer? %n1 - Seguir em frente %n2 - Fugir");
					continua = entrada.nextInt();

					switch (continua) {
					case 1:
						combate.combatePortaEsquerda(escolhaSeguimentoJogo, nivel, armaJogador, escolhaMotivacao,
								classeCombate, escolhaArmaduraNova);
						break;
					case 2:
						System.out.printf(
								"%nVoc� n�o estava preparado para a for�a do inimigo, %ne decide fugir para que possa tentar novamente em uma pr�xima vez.");
						break;
					default:
						System.out.printf("%nEntrada Inv�lida!");

					}
				} while (continua != 1 && continua != 2);

				System.out.printf("%n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::%n");

				int escolhaBeberPocao;

				if (combate.combatePortaEsquerda(escolhaSeguimentoJogo, nivel, armaJogador, escolhaMotivacao,
						classeCombate, escolhaArmaduraNova) == 1) {
					// caso ven�a o combate e queira continuar: continua...

					System.out.printf(
							"%nAp�s derrotar o Alquimista, voc� olha em volta, tentando reconhecer alguma po��o do estoque do inimigo. "
									+ "%nEm uma mesa, voc� reconhece uma pequena garrafa de vidro contendo um l�quido levemente rosado, "
									+ "%npega a garrafa e pondera se deve beber um gole.");

					do {

						System.out.printf("%nVoc� deseja ingerir beber um gole da po��o? %n1 - Sim %n2 - N�o ");
						escolhaBeberPocao = entrada.nextInt();
						switch (escolhaBeberPocao) {
						case 1:
							System.out.printf("%nVoc� se sente revigorado para seguir adiante!");
							escolhaBeberPocao = 1;
							break;
						case 2:
							System.out.printf("%nVoc� fica receoso de beber algo produzido pelo inimigo!");
							escolhaBeberPocao = 2;
							break;
						default:
							System.out.println("Escolha inv�lida!");
							// System.out.printf("%nVoc� deseja ingerir beber um gole da po��o? %n1 - Sim
							// %n2 - N�o ");
							// escolhaBeberPocao = entrada.nextInt();
						}
					} while (escolhaBeberPocao != 1 && escolhaBeberPocao != 2);

					System.out.printf("%n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::%n");

					System.out.printf(
							"%nAo lado da porta, voc� v� uma chave dourada em cima de uma mesa, e sabe que aquela chave"
									+ "%nabre a outra fechadura da porta do l�der inimigo. Voc� pega a chave e guarda na pequena bolsa"
									+ "%nque leva presa ao cinto." + "%n");

					System.out.printf(
							"%nDe volta � sala das portas, voc� se dirige � porta final. Coloca as chaves nas fechaduras, e a"
									+ "%nporta se abre. Seu cora��o acelera, mem�rias de toda a sua vida passam pela sua mente, e voc�"
									+ "%npercebe que est� muito pr�ximo do seu objetivo final. Segura sua arma com mais firmeza, foca"
									+ "%nno combate que voc� sabe que ir� se seguir, e adentra a porta.");

					System.out.printf(
							"%nL� dentro, voc� v� o l�der sentado em uma poltrona dourada, com duas fogueiras de cada lado, e"
									+ "%nprisioneiros acorrentados �s paredes.%n"
									+ "%nEle percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de"
									+ "%nl�mina dupla.");

					System.out.printf(
							"%n::::::::::::::::::::::::::::::::::PORTA FINAL:::::::::::::::::::::::::::::::::::::::%n");

					int escolhaAtacarEsperar;

					do {
						System.out.printf("%nO que voc� deseja fazer? %n1- Atacar %n2 - Esperar");
						escolhaAtacarEsperar = entrada.nextInt();

						if (escolhaAtacarEsperar == 1) {
							System.out.printf("%n Voc� optou por Atacar");
						} else if (escolhaAtacarEsperar == 2) {
							System.out.printf("%n Voc� optou por Esperar, o inimigo iniciou o combate");
						} else {
							System.out.printf("Escolha inv�lida!");
							// System.out.printf("%nO que voc� deseja fazer? %n1- Atacar %n2 - Esperar");
							// escolhaAtacarEsperar = entrada.nextInt();
						}
					} while (escolhaAtacarEsperar != 1 && escolhaAtacarEsperar != 2);

					combate.combatePortaFinal(escolhaSeguimentoJogo, nivel, armaJogador, escolhaMotivacao,
							classeCombate, escolhaBeberPocao, escolhaAtacarEsperar);

					if (combate.combatePortaFinal(escolhaSeguimentoJogo, nivel, armaJogador, escolhaMotivacao,
							classeCombate, escolhaBeberPocao, escolhaAtacarEsperar) == 1) {

						System.out.printf("%nVoc� conseguiu!");

						if (escolhaMotivacao.equals("V")) {

							System.out.printf(
									"%nVoc� obteve sua vingan�a. Voc� se ajoelha e cai no choro, invadido por uma sensa��o de al�vio e felicidade. Voc� se vingou, tudo que sempre quis, est� feito. Agora voc� pode seguir sua vida.");
						} else {

							System.out.printf(
									"%nO �xtase em que voc� se encontra n�o cabe dentro de si. Voc� se ajoelha e grita de alegria. A gl�ria o aguarda, voc� a conquistou.");
						}

						System.out.printf(
								"%n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

						System.out.printf(
								"%nVoc� se levanta, olha para os prisioneiros, vai de um em um e os liberta, %ne todos voc�s saem em dire��o � noite, retornando � cidade. %nSeu dever est� cumprido.");

						System.out.printf("%nJOGO ENCERRADO!");
					}
				}

			}
			// else {
			// System.out.printf(
			// "%nVoc� n�o estava preparado para a for�a do inimigo, e decide fugir para que
			// possa tentar novamente em uma pr�xima vez."
			// + "%n JOGO ENCERRADO!");
			// return;
			// }

			// caso ven�a o combate e queira continuar: continua...
			/*
			 * int escolhaBeberPocao; if (continua == 1) { System.out.printf(
			 * "%nAp�s derrotar o Alquimista, voc� olha em volta, tentando reconhecer alguma po��o do estoque do inimigo. %nEm uma mesa, voc� reconhece uma pequena garrafa de vidro contendo um l�quido levemente rosado, %npega a garrafa e pondera se deve beber um gole."
			 * );
			 * 
			 * System.out.
			 * printf("%nVoc� deseja ingerir beber um gole da po��o? %n1 - Sim %n2 - N�o ");
			 * escolhaBeberPocao = entrada.nextInt(); switch (escolhaBeberPocao) { case 1:
			 * System.out.printf("%nVoc� se sente revigorado para seguir adiante!");
			 * escolhaBeberPocao = 1; break; case 2:
			 * System.out.printf("%nVoc� fica receoso de beber algo produzido pelo inimigo!"
			 * ); escolhaBeberPocao = 2; break; default:
			 * System.out.println("Escolha inv�lida!"); System.out.
			 * printf("%nVoc� deseja ingerir beber um gole da po��o? %n1 - Sim %n2 - N�o ");
			 * escolhaBeberPocao = entrada.nextInt(); } } else { return; }
			 * 
			 * System.out.
			 * printf("%nAo lado da porta, voc� v� uma chave dourada em cima de uma mesa, e sabe que aquela chave"
			 * +
			 * "%nabre a outra fechadura da porta do l�der inimigo. Voc� pega a chave e guarda na pequena bolsa"
			 * + "%nque leva presa ao cinto." + "%n");
			 * 
			 * System.out.
			 * printf("De volta � sala das portas, voc� se dirige � porta final. Coloca as chaves nas fechaduras, e a\r\n"
			 * +
			 * "porta se abre. Seu cora��o acelera, mem�rias de toda a sua vida passam pela sua mente, e voc�\r\n"
			 * +
			 * "percebe que est� muito pr�ximo do seu objetivo final. Segura sua arma com mais firmeza, foca\r\n"
			 * + "no combate que voc� sabe que ir� se seguir, e adentra a porta.");
			 * 
			 * System.out.
			 * printf("%nL� dentro, voc� v� o l�der sentado em uma poltrona dourada, com duas fogueiras de cada lado, e"
			 * + "%nprisioneiros acorrentados �s paredes.%n" +
			 * "%nEle percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de"
			 * + "%nl�mina dupla.");
			 * 
			 * System.out.
			 * printf("%n::::::::::::::::::::::::::::::::::PORTA FINAL:::::::::::::::::::::::::::::::::::::::%n"
			 * );
			 * 
			 * 
			 * System.out.printf("%nO que voc� deseja fazer? %n1- Atacar %n2 - Esperar");//
			 * dependendo da escolha inverte a ordem do ataque int escolhaAtacarEsperar =
			 * entrada.nextInt(); if(escolhaAtacarEsperar == 1) {
			 * System.out.printf("%n Voc� optou por Atacar"); } else if
			 * (escolhaAtacarEsperar == 2) {
			 * System.out.printf("%n Voc� optou por Esperar, o inimigo iniciou o combate");
			 * } else { System.out.printf("Escolha inv�lida!");
			 * System.out.printf("%nO que voc� deseja fazer? %n1- Atacar %n2 - Esperar"); }
			 * 
			 * 
			 * 
			 * continua = combate.combatePortaFinal(escolhaSeguimentoJogo, nivel,
			 * armaJogador, escolhaMotivacao, classeCombate, escolhaBeberPocao,
			 * escolhaAtacarEsperar);
			 * 
			 * 
			 * 
			 * // caso ven�a: VIT�RIAAAAA
			 * 
			 * System.out.printf("%nVoc� conseguiu!");
			 * 
			 * 
			 * if(escolhaMotivacao.equals("V")) {
			 * 
			 * System.out.printf(
			 * "%nVoc� obteve sua vingan�a. Voc� se ajoelha e cai no choro, invadido por uma sensa��o de al�vio e felicidade. Voc� se vingou, tudo que sempre quis, est� feito. Agora voc� pode seguir sua vida."
			 * ); } else {
			 * 
			 * System.out.printf(
			 * "%nO �xtase em que voc� se encontra n�o cabe dentro de si. Voc� se ajoelha e grita de alegria. A gl�ria o aguarda, voc� a conquistou."
			 * ); }
			 * 
			 * System.out .printf(
			 * "%n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"
			 * );
			 * 
			 * System.out.printf(
			 * "%nVoc� se levanta, olha para os prisioneiros, vai de um em um e os liberta, %ne todos voc�s saem em dire��o � noite, retornando � cidade. %nSeu dever est� cumprido."
			 * );
			 * 
			 * System.out.printf("%nJOGO ENCERRADO!");
			 */

			// }
			else if (inicio == 2) {
				System.out.printf("%nJOGO ENCERRADO!");
				entrada.close();
				return;
			} else {
				System.out.printf("%nEntrada inv�lida! Tente novamente%n");
				// System.out.printf("%nIniciar o jogo:%n 1 - Sim %n 2 - N�o");
				// inicio = entrada.nextInt();
			}
		} while (inicio != 1 || inicio != 2);
		// }

		entrada.close();
	}
}
