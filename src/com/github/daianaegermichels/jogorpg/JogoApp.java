package com.github.daianaegermichels.jogorpg;

import java.util.Scanner;

import com.github.daianaegermichels.jogorpg.entidades.Cacador;
import com.github.daianaegermichels.jogorpg.entidades.Combate;
import com.github.daianaegermichels.jogorpg.entidades.Guerreiro;
import com.github.daianaegermichels.jogorpg.entidades.Jogador;
import com.github.daianaegermichels.jogorpg.entidades.Mago;

public class JogoApp {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.printf("Iniciar o jogo:%n 1 - Sim %n 2 - Não");
		int inicio = entrada.nextInt();
		// while (inicio != 0) {
		if (inicio == 1) {
			System.out.println("Seja Bem-Vindo(a) a BATALHA FINAL!");

			System.out.printf("Escolha um nível de jogo: %n 1 - Fácil  %n 2 - Normal %n 3 - Difícil");
			int nivel = entrada.nextInt();

			switch (nivel) {
			case 1:
				System.out.printf("Você escolheu o nível fácil, correto? %n1 - Sim %n2 - Não, alterar.");
				int confirmacao = entrada.nextInt();
				if (confirmacao == 1) {
					nivel = 1;
				} else {
					System.out.printf("Escolha um nível de jogo: %n 1 - Fácil  %n 2 - Normal %n 3 - Difícil");
					nivel = entrada.nextInt();
				}
				break;
			case 2:
				System.out.printf("Você escolheu o nível normal, correto? %n1 - Sim %n2 - Não, alterar.");
				confirmacao = entrada.nextInt();
				if (confirmacao == 1) {
					nivel = 2;
				} else {
					System.out.printf("Escolha um nível de jogo: %n 1 - Fácil  %n 2 - Normal %n 3 - Difícil");
					nivel = entrada.nextInt();
				}
				break;
			case 3:
				System.out.printf("Você escolheu o nível difícil, correto? %n1 - Sim %n2 - Não, alterar.");
				confirmacao = entrada.nextInt();
				if (confirmacao == 1) {
					nivel = 3;
				} else {
					System.out.printf("Escolha um nível de jogo: %n 1 - Fácil  %n 2 - Normal %n 3 - Difícil");
					nivel = entrada.nextInt();
				}
				break;
			default:
				while (nivel != 1 && nivel != 2 && nivel != 3) {
					System.out.println("Entrada inválida!");
					System.out.printf("Escolha um nível de jogo: %n 1 - Fácil  %n 2 - Normal %n 3 - Difícil");
					nivel = entrada.nextInt();
				}
				break;
			}

			System.out.println(entrada.nextLine());
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.println("De um nome ao seu avatar");
			String nomeAvatar = entrada.nextLine().toUpperCase();
			Jogador jogador = new Jogador();
			
			if (nomeAvatar.length() > 0) {
				System.out.printf("O nome do seu avatar será %s, confirmar? %n1 - Sim %n2 - Não, alterar", nomeAvatar);
				int confirmacaoNome = entrada.nextInt();
				if (confirmacaoNome == 1) {
					jogador.setNome(nomeAvatar);
					System.out.printf("Nome do Avatar: %s ", jogador.getNome());
				} else {
					System.out.println("Altere o nome do seu avatar");
					nomeAvatar = entrada.nextLine();
				}
			}
			
			

			System.out.println(entrada.nextLine());
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.printf("%nEscolha um sexo para o seu avatar: %n 1 - Feminino %n 2 - Masculino ");
			int sexoAvatar = entrada.nextInt();
			if (sexoAvatar == 1) {
				System.out.printf("O seu avatar será do sexo FEMININO, confirmar? %n1 - Sim %n2 - Não, alterar");
				int confirmacaoSexo = entrada.nextInt();
				if (confirmacaoSexo == 1) {
					System.out.println("Sexo do Avatar: FEMININO ");
					jogador.setSexo(sexoAvatar);
				} else {
					System.out.println("Altere o sexo do seu avatar");
					System.out.printf("%nEscolha um sexo para o seu avatar: %n 1 - Feminino %n 2 - Masculino ");
					sexoAvatar = entrada.nextInt();
				}
			} else {
				System.out.printf("O seu avatar será do sexo MASCULINO, confirmar? %n1 - Sim %n2 - Não, alterar");
				int confirmacaoSexo = entrada.nextInt();
				if (confirmacaoSexo == 1) {
					System.out.println("Sexo do Avatar: MASCULINO ");
					jogador.setSexo(sexoAvatar);
				} else {
					System.out.println("Altere o sexo do seu avatar");
					System.out.printf("%nEscolha um sexo para o seu avatar: %n 1 - Feminino %n 2 - Masculino ");
					sexoAvatar = entrada.nextInt();
				}
			}
			
			
			
			
			System.out.println(entrada.nextLine());
			int arma;
			int armaJogador = 0;
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.printf("%nEscolha uma classe de combate: %n G - Guerreiro %n M - Mago %n C - Caçador");
			String classeCombate = entrada.nextLine().toUpperCase();
			if (classeCombate.equals("G")) {
				System.out.println("Você escolheu a classe Guerreiro, confirmar? 1 - Sim  2 - Não");
				int confirmacaoClasse = entrada.nextInt();
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
					System.out.printf("%nEscolha uma classe de combate: %n G - Guerreiro %n M - Mago %n C - Caçador");
					classeCombate = entrada.nextLine();
				}
			} else if (classeCombate.equals("M")) {
				System.out.println("Você escolheu a classe Mago, confirmar? 1 - Sim  2 - Não");
				int confirmacaoClasse = entrada.nextInt();
				if (confirmacaoClasse == 1) {
					System.out.println("Classe de combate: MAGO ");
					Mago mago = new Mago(nomeAvatar, sexoAvatar);
					System.out.printf("%nEscolha uma arma para o combate: %n1 - Livro %n2 - Cajado");
					arma = entrada.nextInt();
					armaJogador = mago.setArma(arma);
					System.out.println(armaJogador);
				} else {
					System.out.println("Altere a classe de combate do seu avatar");
					System.out.printf("%nEscolha uma classe de combate: %n G - Guerreiro %n M - Mago %n C - Caçador");
					classeCombate = entrada.nextLine();
				}
			} else if (classeCombate.equals("C")) {
				System.out.println("Você escolheu a classe Caçador, confirmar? 1 - Sim  2 - Não");
				int confirmacaoClasse = entrada.nextInt();
				if (confirmacaoClasse == 1) {
					System.out.println("Classe de combate: CAÇADOR ");
					Cacador cacador = new Cacador(nomeAvatar, sexoAvatar);
					System.out.printf("%nEscolha uma arma para o combate: %n1 - Arco e Flecha %n2 - Besta e Virote");
					arma = entrada.nextInt();
					armaJogador = cacador.setArma(arma);
					System.out.println(armaJogador);
					// se armaJogador == 0 perguntar a arma novamente, pois a arma escolhida foi
					// invalida
				} else {
					System.out.printf("%nAltere a classe de combate do seu avatar");
					System.out.printf("%nEscolha uma classe de combate: %n G - Guerreiro %n M - Mago %n C - Caçador");
					classeCombate = entrada.nextLine();
				}
			} else {
				System.out.printf("%nClasse de combate inválida!");
				System.out.printf("%nEscolha uma classe de combate: %n G - Guerreiro %n M - Mago %n C - Caçador");
				classeCombate = entrada.nextLine();
			}

			System.out.println(entrada.nextLine());

			System.out.printf("%n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.printf(
					"A noite se aproxima, a lua já surge no céu, estrelas vão se acendendo, e sob a luz do crepúsculo você está prestes a entrar na fase final da sua missão."
							+ "%nVocê olha para o portal à sua frente, e sabe que a partir desse ponto, sua vida mudará para sempre. "
							+ "%n%nMemórias do caminho percorrido para chegar até aqui invadem sua mente. "
							+ "%nVocê se lembra de todos os inimigos já derrotados para alcançar o covil do líder maligno. "
							+ "%nOlha para seu equipamento de combate, já danificado e desgastado depois de tantas lutas. "
							+ "%nVocê está a um passo de encerrar para sempre esse mal."
							+ "%n%nBuscando uma injeção de ânimo, você se força a lembrar o que te trouxe até aqui.");
			System.out.printf("Escolha da motivação: %n V - VINGANÇA %n G - GLÓRIA ");
			String escolhaMotivacao = entrada.nextLine().toUpperCase();
			switch (escolhaMotivacao) {
			case "V":
				System.out.printf(
						"Imagens daquela noite trágica invadem sua mente. %nVocê nem precisa se esforçar para lembrar, pois essas memórias estão sempre presentes, %nmesmo que de pano de fundo, quando você tem outros pensamentos em foco, elas nunca o deixaram. %nElas são o combustível que te fizeram chegar até aqui. %nE você sabe que não irá desistir até ter vingado a morte daqueles que foram - e pra sempre serão - sua fonte de amor e desejo de continuar vivo. %nO maldito líder finalmente pagará por tanto mal causado na vida de tantos (e principalmente na sua).");
				break;
			case "G":
				System.out.printf(
						"Você já consegue visualizar na sua mente o povo da cidade te recebendo de braços abertos, %nbardos criando canções sobre seus feitos heróicos, nobres te presenteando com jóias e diversas riquezas, %ntaberneiros se recusando a cobrar por suas bebedeiras e comilanças. %nDesde já, você sente o amor do público, te louvando a cada passo que dá pelas ruas, depois de %ndestruir o vilão que tanto assombrou a paz de todos. Porém, você sabe que ainda falta o último ato dessa história. %nVocê se concentra na missão. A glória o aguarda, mas não antes da última batalha.");
				break;
			default:
				System.out.println("Escolha inválida, tente novamente");
				System.out.printf("Escolha da motivação: %n V - VINGANÇA %n G - GLÓRIA ");
				escolhaMotivacao = entrada.nextLine().toUpperCase();
				break;
			}

			System.out.printf("%n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.printf(
					"Inspirado pelo motivo que te trouxe até aqui, você sente seu coração ardendo em chamas, suas mãos formigarem em volta da sua arma. Você a segura com firmeza. Seu foco está renovado. Você avança pelo portal.%n"
							+ "%n"
							+ "A escuridão te envolve. Uma iluminação muito fraca entra pelo portal às suas costas. À sua frente, só é possível perceber que você se encontra em um corredor extenso. Você só pode ir à frente, ou desistir.%n");
			System.out.printf("%nO que você deseja? %n 1 - Seguir em frente %n 2 - Desistir");
			int escolhaSeguimentoJogo = entrada.nextInt();
			switch (escolhaSeguimentoJogo) {
			case 1:
				System.out.printf(
						"Você caminha, atento a todos os seus sentidos, por vários metros, %naté visualizar a frente uma fonte de luz, que você imagina ser a chama de uma tocha, %nvindo de dentro de uma porta aberta.");

				break;
			case 2:
				System.out.printf(
						"O medo invade o seu coração e você sente que ainda não está à altura do desafio. %nVocê se volta para a noite lá fora e corre em direção à segurança.%n");
				System.out.printf("%nJOGO ENCERRADO!");
				entrada.close();
				break;
			default:
				System.out.printf("%nEscolha inválida, tente novamente");
				System.out.printf("O que você deseja? %n 1 - Seguir em frente %n 2 - Desistir");
				escolhaSeguimentoJogo = entrada.nextInt();
			}

			System.out.printf("%n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.printf(
					"Você se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha, %ne pondera sobre como passar pela porta.");
			System.out.printf("%n1 - Andando cuidadosamente %n2 - Correndo %n3 - Saltando");
			int modoDeAndar = entrada.nextInt();
			switch (modoDeAndar) {
			case 1:
				System.out.printf(
						"%nVocê toma cuidado e vai caminhando vagarosamente em direção à luz. %nQuando você pisa exatamente embaixo da porta, você sente o chão ceder levemente, como se tivesse pisado em uma pedra solta. %nVocê ouve um ruído de mecanismos se movimentando, e uma escotilha se abre no teto atrás de você, no corredor. %nFlechas voam da escotilha em sua direção, e você salta para dentro da sala, %nporém uma delas te acerta na perna.");
				break;
			case 2:
				System.out.printf(
						"%nVocê respira fundo e desata a correr em direção à sala. %nQuando passa pela porta, sente que pisou em uma pedra solta, mas não dá muita importância e segue para dentro da sala, %nolhando ao redor à procura de inimigos. Não tem ninguém, mas você ouve sons de %nflechas batendo na pedra atrás de você, e quando se vira, vê várias flechas no chão. %nEspiando pela porta, você entende que pisou em uma armadilha que soltou flechas %nde uma escotilha aberta no teto, mas por sorte você entrou correndo e %nconseguiu escapar desse ataque surpresa.");
				break;
			case 3:
				System.out.printf(
						"%nVocê se concentra e pula em direção à luz, saltando de antes da porta até o interior da sala.");
				break;

			default:
				System.out.printf("%nEscolha inválida, tente novamente");
				System.out.printf("%n1 - Andando cuidadosamente %n2 - Correndo %n3 - Saltando");
				modoDeAndar = entrada.nextInt();
			}

			System.out.printf("%n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.printf(
					"%nVocê se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede. %nUma delas foi aquela pela qual você entrou, que estava aberta, e as outras três estão fechadas. %nA porta à sua frente é a maior das quatro, com inscrições em seu entorno em uma língua que você não sabe ler, %nmas reconhece como sendo a língua antiga utilizada pelo inimigo. %nVocê se aproxima da porta e percebe que ela está trancada por duas fechaduras douradas, %ne você entende que precisará primeiro derrotar o que estiver nas outras duas portas laterais, %nantes de conseguir enfrentar o líder."
							+ "%n" + "%nVocê se dirige para a porta à direita." + "%n");

			System.out
					.printf("%n::::::::::::::::::::::::::::::::::PORTA DIREITA:::::::::::::::::::::::::::::::::::::::");
			System.out.printf(
					"%nVocê se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada. %nSegura com mais força sua arma com uma mão, enquanto empurra a porta com a outra. %nAo entrar, você se depara com uma sala espaçosa, com vários equipamentos de batalha pendurados %nnas paredes e dispostos em armários e mesas. %nVocê imagina que este seja o arsenal do inimigo, onde estão guardados os equipamentos que seus %nsoldados utilizam quando saem para espalhar o terror nas cidades e vilas da região."
							+ "%n"
							+ "%nEnquanto seu olhar percorre a sala, você ouve a porta se fechando e gira rapidamente para olhar para trás. %nAli, de pé entre você e a porta fechada, bloqueando o caminho do seu destino, %nestá um dos capitães do inimigo. Um orque horrendo, de armadura, capacete e espada em punho, %nem posição de combate. Ele avança em sua direção."
							+ "%n");

			System.out.printf("O que você deseja fazer? %n1 - Seguir em frente %n2 - Fugir");
			int continua = entrada.nextInt();

			switch (continua) {
			case 1:
				Combate combatePortaDireita = new Combate();
				//combatePortaDireita.combateJogador(nivel,armaJogador, modoDeAndar, escolhaMotivacao, classeCombate);//isso estava fazendo dar 2 golpes
				//continua = combatePortaDireita.batalhaPortaDireita(continua);
				
				//combatePortaDireita.golpeJogador(armaJogador, modoDeAndar, escolhaMotivacao, classeCombate);
				continua = combatePortaDireita.combatePortaDireita(continua, nivel, armaJogador, modoDeAndar, escolhaMotivacao, classeCombate);
				break;
			case 2:
				System.out.printf(
						"%nVocê não estava preparado para a força do inimigo, %ne decide fugir para que possa tentar novamente em uma próxima vez.");
				break;
			default:
				System.out.printf("%nEntrada Inválida!");
				while (continua != 1 && continua != 2) {
					System.out.printf("%nO que você deseja fazer? %n1 - Seguir em frente %n2 - Fugir");
					continua = entrada.nextInt();
					// como faz para retornar ao inicio do switch case??

				}

			}

			// caso vença o combate e queira continuar: contiunua...

			//System.out.printf("O que você deseja fazer? %n1 - Seguir em frente %n2 - Fugir");
			//continua = entrada.nextInt();

			if (continua == 1) {
				System.out.printf(
						"%nApós derrotar o Armeiro, você percebe que seus equipamentos estão muito danificados, %ne olha em volta, encarando todas aquelas peças de armaduras resistentes e em ótimo estado.");

				System.out.printf("%nDecidi se usa a armadura ou não ");

			} else {
				System.out.printf(
						"%nVocê não estava preparado para a força do inimigo, e decide fugir para que possa tentar novamente em uma próxima vez."
						+ "%n JOGO ENCERRADO!");
				return;
			}

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

			System.out.printf(
					"%nEm uma mesa, você encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras da porta do líder inimigo. %nVocê pega a chave e guarda numa pequena bolsa que leva presa ao cinto.");

			System.out
					.printf("%n::::::::::::::::::::::::::::::::::PORTA ESQUERDA:::::::::::::::::::::::::::::::::::::::");
			System.out.printf(
					"%nVocê retorna à sala anterior e se dirige à porta da esquerda. %nVocê se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada. %nSegura com mais força sua arma com uma mão, enquanto empurra a porta com a outra. %nAo entrar, você se depara com uma sala parecida com a do arsenal, mas em vez de armaduras, %nexistem vários potes e garrafas de vidro com conteúdos misteriosos e de cores diversas, %ne você entende que o capitão que vive ali, realiza experimentos com diversos ingredientes, %ncriando poções utilizadas pelos soldados para aterrorizar a região."
							+ "%nNo fundo da sala, olhando em sua direção, está outro dos capitães do inimigo. %nUm orque horrendo, de armadura, cajado em punho, em posição de combate. %nEle avança em sua direção."
							+ "%n");

			System.out.printf("%nLoop de combate");

			// caso vença o combate e queira continuar: continua...

			System.out.printf(
					"%nApós derrotar o Alquimista, você olha em volta, tentando reconhecer alguma poção do estoque do inimigo. %nEm uma mesa, você reconhece uma pequena garrafa de vidro contendo um líquido levemente rosado, %npega a garrafa e pondera se deve beber um gole.");

			/*
			 * [jogador escolhe entre beber ou não. Se beber, o jogo exibe a mensagem: “Você
			 * se sente revigorado para seguir adiante!” e recupera 100% dos pontos de vida
			 * do jogador. Se não beber, o jogo exibe a mensagem: “Você fica receoso de
			 * beber algo produzido pelo inimigo”.]
			 */

			System.out.printf(
					"abre a outra fechadura da porta do líder inimigo. Você pega a chave e guarda na pequena bolsa que leva presa ao cinto.\r\n"
							+ "\r\n"
							+ "De volta à sala das portas, você se dirige à porta final. Coloca as chaves nas fechaduras, e a porta se abre. Seu coração acelera, memórias de toda a sua vida passam pela sua mente, e você percebe que está muito próximo do seu objetivo final. Segura sua arma com mais firmeza, foca no combate que você sabe que irá se seguir, e adentra a porta.\r\n"
							+ "\r\n"
							+ "Lá dentro, você vê o líder sentado em uma poltrona dourada, com duas fogueiras de cada lado, e prisioneiros acorrentados às paredes.\r\n"
							+ "\r\n"
							+ "Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de lâmina dupla.\r\n"
							+ "");

			System.out.printf("%n::::::::::::::::::::::::::::::::::PORTA FINAL:::::::::::::::::::::::::::::::::::::::");
			System.out.printf("%nJogador decidi se Ataca ou Espera");
			System.out.printf("%nLoop de combate");

			// caso vença: VITÓRIAAAAA

			System.out.printf("%nVocê conseguiu!");

			System.out.printf("%nMensagem de acordo com a MOTIVAÇÃO");

			// VINGANÇA
			System.out.printf(
					"%nVocê obteve sua vingança. Você se ajoelha e cai no choro, invadido por uma sensação de alívio e felicidade. Você se vingou, tudo que sempre quis, está feito. Agora você pode seguir sua vida.");

			// GLÓRIA
			System.out.printf(
					"%nO êxtase em que você se encontra não cabe dentro de si. Você se ajoelha e grita de alegria. A glória o aguarda, você a conquistou.");

			System.out
					.printf("%n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

			System.out.printf(
					"%nVocê se levanta, olha para os prisioneiros, vai de um em um e os liberta, %ne todos vocês saem em direção à noite, retornando à cidade. %nSeu dever está cumprido.");

			System.out.printf("%nJOGO ENCERRADO!");

		} else if (inicio == 2) {
			System.out.printf("%nJOGO ENCERRADO!");
			entrada.close();
			return;
		} else {
			System.out.printf("%nEntrada inválida! Tente novamente");
			System.out.printf("%nIniciar o jogo:%n 1 - Sim %n 2 - Não");
			inicio = entrada.nextInt();
		}
		// }

		entrada.close();
	}
}
