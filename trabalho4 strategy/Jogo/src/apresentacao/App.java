package apresentacao;

import java.util.Scanner;

import negocio.*;
import negocio.Personagens.Cavaleiro;
import negocio.Personagens.Peao;
import negocio.Personagens.Personagem;
import negocio.Personagens.Rainha;
import negocio.Personagens.Rei;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner entrada = new Scanner(System.in);
        //boolean Invalidado = true;
        int posicaohorizontal;
        int posicaovertical;
        

        System.out.println(
                "\nBem vindo ao Batalha Medieval! \n\nNo jogo você tem as peças: Rainha, Rei, Cavaleiro e " +
                        "peão dentro do tabuleiro que na posição vertical vai de 0 a 9 e na horizontal de 0 a 4."+
                        "\nO dano que cada personagem dá no oponente varia de acordo com a arma que cada classe inicia.");

                        System.out.println("Quando você elimina um personagem inimigo você tem a opção de pegar a arma dele.");

        
        // posições marcadas para teste
        Rainha rainhaJ1 = new Rainha(0, 2, Jogador.JOGADOR1);
        Rei reiJ1 = new Rei(0, 3, Jogador.JOGADOR1);
        Cavaleiro cavaleiroJ1 = new Cavaleiro(0, 1, Jogador.JOGADOR1);
        Peao peaoJ1 = new Peao(0, 4, Jogador.JOGADOR1);
        Rainha rainhaJ2 = new Rainha(9, 3, Jogador.JOGADOR2);
        Rei reiJ2 = new Rei(9, 2, Jogador.JOGADOR2);
        Cavaleiro cavaleiroJ2 = new Cavaleiro(9, 4, Jogador.JOGADOR2);
        Peao peaoJ2 = new Peao(9, 1, Jogador.JOGADOR2);

        System.out.println(
                "\nAgora é a vez de jogar. \nA Cada rodada você terá 1 movimento e 1 ataque. O jogo acaba em 10 rodadas ou quando "
                        +
                        "algum jogador matar o rei do oponente.");
        System.out.println("\nPara andar Você deverá escolher as direções: CIMA,BAIXO,DIREITA,ESQUERDA ou NAOMOVER ");

        String direcaomovimento;
        int personagemescolhido;
        int oponenteescolhido;
        int rodadas = 10;
        /* Tabuleiro tabuleiro = new Tabuleiro();

        tabuleiro.PreencherTabuleiro();

        for (int i = 0; i < Tabuleiro.tabuleiro.length; i++) 
        {
            for (int j = 0; j < Tabuleiro.tabuleiro[0].length; j++) {
                System.out.print(Tabuleiro.tabuleiro[i][j]+"  ");
            }
            System.out.println("");
        } */

        while ((rodadas > 0) && (reiJ1.getVida() > 0) & (reiJ2.getVida() > 0)) {
            // MOVIMENTO J1
            //System.out.println("\nRodada " + rodadas);
            System.out.println("\nÉ a vez do Jogador 1");
            System.out.println("\nJogadores para mover:");
            for (Personagem personagem : Personagem.getpersonagensJogo()) {
                if ((personagem.getJogador()) == Jogador.JOGADOR1) {
                    System.out
                            .println(Personagem.getpersonagensJogo().indexOf(personagem) + "." + personagem.toString());
                }
            }
            System.out.println("Qual Jogador Você deseja mover?");
            personagemescolhido = entrada.nextInt();
            System.out.println("\nQual direção deseja mover: CIMA,BAIXO,DIREITA,ESQUERDA,NAOMOVER ?");
            direcaomovimento = entrada.next().toUpperCase();
            direcaomovimento = verificaDirecao(direcaomovimento);
            
            Personagem.getpersonagensJogo().get(personagemescolhido).andar(Direcao.valueOf(direcaomovimento));

            // ataque J1
            System.out.println("\nPersonagens para ataque:");
            for (Personagem personagem : Personagem.getpersonagensJogo()) {
                if ((personagem.getJogador()) == Jogador.JOGADOR1) {
                    System.out
                            .println(Personagem.getpersonagensJogo().indexOf(personagem) + "." + personagem.toString());
                }
            }
            System.out.println("Com qual personagem Você deseja atacar?");
            personagemescolhido = entrada.nextInt();

            System.out.println("\nOponentes para ataque:");
            for (Personagem personagem : Personagem.getpersonagensJogo()) {
                if ((personagem.getJogador()) == Jogador.JOGADOR2) {
                    System.out
                            .println(Personagem.getpersonagensJogo().indexOf(personagem) + "." + personagem.toString());
                }
            }
            System.out.println("\nQual Oponente Você deseja atacar?");
            oponenteescolhido = entrada.nextInt();
            Personagem.getpersonagensJogo().get(personagemescolhido)
                    .atacar(Personagem.getpersonagensJogo().get(oponenteescolhido));
            if (reiJ2.getVida() > 0) {
                // MOVIMENTO J2
                System.out.println("\nÉ a vez do Jogador 2");
                System.out.println("Jogadores para mover:");
                for (Personagem personagem : Personagem.getpersonagensJogo()) {
                    if ((personagem.getJogador()) == Jogador.JOGADOR2) {
                        System.out.println(
                                Personagem.getpersonagensJogo().indexOf(personagem) + "." + personagem.toString());
                    }
                }
                System.out.println("Qual Jogador Você deseja mover?");
                personagemescolhido = entrada.nextInt();
                System.out.println("Qual direção deseja mover: CIMA,BAIXO,DIREITA,ESQUERDA,NAOMOVER ?");
                direcaomovimento = entrada.next().toUpperCase();
                direcaomovimento = verificaDirecao(direcaomovimento);
                Personagem.getpersonagensJogo().get(personagemescolhido).andar(Direcao.valueOf(direcaomovimento));

                // ATAQUE J2
                System.out.println("\nPersonagens para ataque:");
                for (Personagem personagem : Personagem.getpersonagensJogo()) {
                    if ((personagem.getJogador()) == Jogador.JOGADOR2) {
                        System.out.println(
                                Personagem.getpersonagensJogo().indexOf(personagem) + "." + personagem.toString());
                    }
                }
                System.out.println("\nCom qual personagem Você deseja atacar?");
                personagemescolhido = entrada.nextInt();

                System.out.println("\nOponentes para ataque:");
                for (Personagem personagem : Personagem.getpersonagensJogo()) {
                    if ((personagem.getJogador()) == Jogador.JOGADOR1) {
                        System.out.println(
                                Personagem.getpersonagensJogo().indexOf(personagem) + "." + personagem.toString());
                    }
                }
                System.out.println("Qual Oponente Você deseja atacar?");
                oponenteescolhido = entrada.nextInt();
                Personagem.getpersonagensJogo().get(personagemescolhido)
                        .atacar(Personagem.getpersonagensJogo().get(oponenteescolhido));
            } else if(reiJ1.getVida()<=0){
                System.out.println("Jogador 2 matou o rei");
                
            }else{
                System.out.println("Jogador 1 matou o rei");
            }
            rodadas--;
            System.out.println("Faltam "+ rodadas + " rodadas");
        }
        if(rodadas==0)
        if (Jogador.JOGADOR1.getPontos() > Jogador.JOGADOR2.getPontos()) {
            System.out.println("Jogador 1 venceu com " + Jogador.JOGADOR1.getPontos());
        } else {
            System.out.println("Jogador 2 venceu " + Jogador.JOGADOR2.getPontos());
        }

        entrada.close();

    }

    private static String verificaDirecao(String direcaomovimento) {
        switch (direcaomovimento) {
            case "CIMA":
                break;
            case "BAIXO":
                break;
            case "DIREITA":
                break;
            case "ESQUERDA":
                break;
            case "NAOMOVER":
                break;
            default:
                System.out.println("Direção Inválida, perdeu o movimento");
                direcaomovimento = "NAOMOVER";
        }
        return direcaomovimento;
    }
}
