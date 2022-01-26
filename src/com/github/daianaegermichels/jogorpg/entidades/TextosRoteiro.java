package com.github.daianaegermichels.jogorpg.entidades;

public class TextosRoteiro {

	public TextosRoteiro(){
		
	}
	
	public void TextoUm () {
		System.out.printf(
				"%nA noite se aproxima, a lua já surge no céu, estrelas vão se acendendo, e sob a luz do crepúsculo você está prestes a entrar na fase final da sua missão."
						+ "%nVocê olha para o portal à sua frente, e sabe que a partir desse ponto, sua vida mudará para sempre. "
						+ "%n%nMemórias do caminho percorrido para chegar até aqui invadem sua mente. "
						+ "%nVocê se lembra de todos os inimigos já derrotados para alcançar o covil do líder maligno. "
						+ "%nOlha para seu equipamento de combate, já danificado e desgastado depois de tantas lutas. "
						+ "%nVocê está a um passo de encerrar para sempre esse mal."
						+ "%n%nBuscando uma injeção de ânimo, você se força a lembrar o que te trouxe até aqui.");
	}
	
	public void TextoDois() {
		System.out.printf(
				"%nInspirado pelo motivo que te trouxe até aqui, você sente seu coração ardendo em chamas, suas mãos formigarem em volta da sua arma. Você a segura com firmeza. Seu foco está renovado. Você avança pelo portal.%n"
						+ "%n"
						+ "A escuridão te envolve. Uma iluminação muito fraca entra pelo portal às suas costas. À sua frente, só é possível perceber que você se encontra em um corredor extenso. Você só pode ir à frente, ou desistir.%n");
	}
	
	public void TextoTres() {
		System.out
		.printf("%nVocê se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha, "
				+ "%ne pondera sobre como passar pela porta.");
	}
	
	public void TextoQuatro() {
		System.out.printf(
				"%nVocê se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede. "
						+ "%nUma delas foi aquela pela qual você entrou, que estava aberta, e as outras três estão fechadas. "
						+ "%nA porta à sua frente é a maior das quatro, com inscrições em seu entorno em uma língua que você não sabe ler, "
						+ "%nmas reconhece como sendo a língua antiga utilizada pelo inimigo. "
						+ "%nVocê se aproxima da porta e percebe que ela está trancada por duas fechaduras douradas, "
						+ "%ne você entende que precisará primeiro derrotar o que estiver nas outras duas portas laterais, "
						+ "%nantes de conseguir enfrentar o líder." + "%n"
						+ "%nVocê se dirige para a porta à direita." + "%n");

		System.out.printf(
				"%n::::::::::::::::::::::::::::::::::PORTA DIREITA:::::::::::::::::::::::::::::::::::::::%n");
		System.out.printf(
				"%nVocê se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada. "
						+ "%nSegura com mais força sua arma com uma mão, enquanto empurra a porta com a outra. "
						+ "%nAo entrar, você se depara com uma sala espaçosa, com vários equipamentos de batalha pendurados "
						+ "%nnas paredes e dispostos em armários e mesas. "
						+ "%nVocê imagina que este seja o arsenal do inimigo, onde estão guardados os equipamentos que seus "
						+ "%nsoldados utilizam quando saem para espalhar o terror nas cidades e vilas da região."
						+ "%n"
						+ "%nEnquanto seu olhar percorre a sala, você ouve a porta se fechando e gira rapidamente para olhar para trás. "
						+ "%nAli, de pé entre você e a porta fechada, bloqueando o caminho do seu destino, "
						+ "%nestá um dos capitães do inimigo. Um orque horrendo, de armadura, capacete e espada em punho, "
						+ "%nem posição de combate. Ele avança em sua direção." + "%n");
	}
	
	public void TextoCinco() {
		System.out.printf(
				"%nEm uma mesa, você encontra uma chave dourada, e sabe que aquela chave abre uma das"
						+ "%nfechaduras da porta do líder inimigo. Você pega a chave e guarda numa pequena bolsa que leva"
						+ "%npresa ao cinto." + "%n");

		System.out.printf(
				"%n::::::::::::::::::::::::::::::::::PORTA ESQUERDA:::::::::::::::::::::::::::::::::::::::%n");

		System.out.printf("%nVocê retorna à sala anterior e se dirige à porta da esquerda. Você se"
				+ "%naproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada. Segura com mais"
				+ "%nforça sua arma com uma mão, enquanto empurra a porta com a outra. Ao entrar, você se depara"
				+ "%ncom uma sala parecida com a do arsenal, mas em vez de armaduras, existem vários potes e"
				+ "%ngarrafas de vidro com conteúdos misteriosos e de cores diversas, e você entende que o capitão"
				+ "%nque vive ali, realiza experimentos com diversos ingredientes, criando poções utilizadas pelos"
				+ "%nsoldados para aterrorizar a região."
				+ "%nNo fundo da sala, olhando em sua direção, está outro dos capitães do inimigo. Um orque"
				+ "%nhorrendo, de armadura, cajado em punho, em posição de combate. Ele avança em sua direção.");

	}
	
	public void TextoSeis()
	{
		System.out.printf(
				"%nAo lado da porta, você vê uma chave dourada em cima de uma mesa, e sabe que aquela chave"
						+ "%nabre a outra fechadura da porta do líder inimigo. Você pega a chave e guarda na pequena bolsa"
						+ "%nque leva presa ao cinto." + "%n");

		System.out.printf(
				"%nDe volta à sala das portas, você se dirige à porta final. Coloca as chaves nas fechaduras, e a"
						+ "%nporta se abre. Seu coração acelera, memórias de toda a sua vida passam pela sua mente, e você"
						+ "%npercebe que está muito próximo do seu objetivo final. Segura sua arma com mais firmeza, foca"
						+ "%nno combate que você sabe que irá se seguir, e adentra a porta.");

		System.out.printf(
				"%nLá dentro, você vê o líder sentado em uma poltrona dourada, com duas fogueiras de cada lado, e"
						+ "%nprisioneiros acorrentados às paredes.%n"
						+ "%nEle percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de"
						+ "%nlâmina dupla.");

		System.out.printf(
				"%n::::::::::::::::::::::::::::::::::PORTA FINAL:::::::::::::::::::::::::::::::::::::::%n");

	}
}
