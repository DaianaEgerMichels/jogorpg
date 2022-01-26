# jogorpg
Jogo de RPG desenvolvido em Java | Projeto 3 - Módulo 02 - BackEnd | DEVinHouse
By: Daiana Eger Michels

O jogo foi desenvolvido seguindo os requisitos da aplicação propostos no projeto 3 do curso DEVinHouse.

A classe JogoApp é a classe responsável por rodar a aplicação.

Para o intuito do jogo, foram criadas outras classes (entidades). 
As classes de combate: Guerreiro, Mago e Caçador extendem da classe mãe Jogador. 
As classes dos adversários: armeiro, alquimista e adversário líder extendem da classe Adversário.

A classe Combate é onde a ação do jogo acontece. 

Conforme a aplicação (JogoApp) vai rodando e as informações vão sendo preenchidas, estás informações são armazenadas e utilizadas pelas demais classes.

Dependendo do nível de dificuldade escolhido pelo jogador, valores de vida, pontos de defesa e pontos de ataque, tanto do jogador, como
do adversário são diferentes.

O jogo acontece em três portas, com um adversário diferente em cada uma delas.

Além do nível, foi adicionado a opção de agilidade do jogador, que caso a opção escolhida seja rápido, no nível fácil 
e na primeira porta de combate, o jogador consiguira dar dois golpes seguidos.

Ao fim do combate em cada porta que antecede a porta final, em caso de vitória, o jogador é questionado sobre a utilização de artificios que, 
em caso afirmativo, somam pontos ao jogador.

Após cada combate o jogador é questionado sobre sua intenção de continuar o jogo ou fugir (encerrando o jogo).

O jogo se encerra quando um dos combatentes é derrotado, ou quando o jogador opta por desistir/fugir.
