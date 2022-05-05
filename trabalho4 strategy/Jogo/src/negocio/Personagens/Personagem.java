package negocio.Personagens;

import java.util.ArrayList;
import java.util.Scanner;
import negocio.Direcao;
import negocio.Jogador;
import negocio.Armas.ArcoEFlecha;
import negocio.Armas.Arma;
import negocio.Armas.SemArma;

public abstract class Personagem {
    protected Arma arma;
    protected ArcoEFlecha arcoEFlecha = new ArcoEFlecha();
    protected int vida; // cada classe de personagem tem sua vida
    protected int posicaovertical; // eixo y de 0 a 9
    protected int posicaohorizontal; // eixo x de 0 a 4
    protected int dano; // de acordo com a arma
    protected String nome;
    Scanner entrada = new Scanner(System.in);
    protected static ArrayList<Personagem> personagensJogo = new ArrayList<>();
    protected Jogador jogador;

    public static ArrayList<Personagem> getpersonagensJogo() {
        return personagensJogo;
    }

    public static void setpersonagensJogo(ArrayList<Personagem> personagensJogo) {
        Personagem.personagensJogo = personagensJogo;
    }

    public int getPosicaovertical() {
        return posicaovertical;
    }

    public void setPosicaovertical(int posicaovertical) {
        this.posicaovertical = posicaovertical;
    }

    public int getPosicaohorizontal() {
        return posicaohorizontal;
    }

    public void setPosicaohorizontal(int posicaohorizontal) {
        this.posicaohorizontal = posicaohorizontal;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public Personagem() {

    };

    public Personagem(int posicaovertical, int posicaohorizontal, Jogador jogador) {

        if (posicaovertical < 0 || posicaovertical > 9)

        {
            throw new IllegalArgumentException("Posição Vertical inválida, reiniciando...");
        } else if (posicaohorizontal < 0 || posicaohorizontal > 4) {
            throw new IllegalArgumentException("Posição Horizontal inválida, reiniciando...");

        }
        this.arma = new SemArma();
        this.posicaohorizontal = posicaohorizontal;
        this.posicaovertical = posicaovertical;
        this.dano = this.getArma().plusDano();
        this.jogador = jogador;
        Personagem.personagensJogo.add(this);

    }

    @Override
    public String toString() {
        return this.getNome() + " " + this.getJogador() + "  [dano=" + dano + ", posicaohorizontal=" + posicaohorizontal
                + ", posicaovertical="
                + posicaovertical + ", vida=" + vida + "]";
    }

    public String toString2() {
        String jog;
        if(this.getJogador()==Jogador.JOGADOR1)
        {jog="P1-";}
        else{jog="P2-";}
        return jog + this.getNome().substring(0, 6)  ;
        
    }

    public abstract String getNome();

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void atacar(Personagem oponente) {
        int deltaX = Math.abs(this.posicaohorizontal - oponente.posicaohorizontal);
        int deltaY = Math.abs(this.posicaovertical - oponente.posicaovertical);
        if (this.getJogador() != oponente.getJogador()) {
            if (this.getArma().equals(arcoEFlecha)) {
                if (deltaX == 0 && deltaY <= 2) {
                    oponente.setVida(oponente.getVida() - this.dano);
                    this.getJogador().somarPontos(this.dano);
                    System.out.println("acertou com arco e flecha");
                } else if (deltaX <= 2 && deltaY == 0) {
                    oponente.setVida(oponente.getVida() - this.dano);
                    this.getJogador().somarPontos(this.dano);
                    System.out.println("acertou com arco e flecha");
                } else {
                    System.out.println("Você errou o alvo com arco e flecha!");
                }
            } else if (deltaX == 0 && deltaY == 1) {
                oponente.setVida(oponente.getVida() - this.dano);
                this.getJogador().somarPontos(this.dano);
                System.out.println("acertou com " + this.getArma().getNome());
            } else if (deltaX == 1 && deltaY == 0) {
                oponente.setVida(oponente.getVida() - this.dano);
                this.getJogador().somarPontos(this.dano);
                System.out.println("acertou com " + this.getArma().getNome());
            } else {
                System.out.println("Você errou o alvo!");
            }
            if (oponente.getVida() <= 0) {
                System.out
                        .println("Você matou o Personagem do inimigo! Ele tem uma arma " + oponente.getArma().getNome()
                                + "com dano de " + oponente.getArma().getDano() +
                                ". Deseja pegar sua arma? 1-sim 2-não");
                int escolhaarma = entrada.nextInt();
                this.setPosicaohorizontal(oponente.getPosicaohorizontal());
                this.setPosicaovertical(oponente.getPosicaovertical());
                if (escolhaarma == 1) {
                    this.setArma(oponente.getArma());
                    System.out.println("Você pegou a arma de " + oponente.getNome());
                }
                Personagem.personagensJogo.remove(oponente);
            }
        } else {
            System.out.println("Perdeu o ataque!!! Você não pode atacar um personagem seu!");
        }
    }

    public boolean andar(Direcao direcao) {
        if ((direcao == Direcao.DIREITA) && (this.posicaohorizontal < 4)) {
            this.posicaohorizontal++;
            if (this.verificaPosicao() == true) {
                System.out.println("Você moveu para direita.");
                return true;
            } else {
                this.atacar(this.getPersonagemPosicaoOcupada());
                this.posicaohorizontal--;
                return false;
            }

        } else if ((direcao == Direcao.ESQUERDA) && (this.posicaohorizontal > 0)) {
            this.posicaohorizontal--;
            if (this.verificaPosicao() == true) {
                System.out.println("Você moveu para esquerda.");
                return true;
            } else {
                this.atacar(this.getPersonagemPosicaoOcupada());
                this.posicaohorizontal++;
                return false;
            }
        } else if ((direcao == Direcao.CIMA) && (this.posicaovertical < 9)) {
            this.posicaovertical++;
            if (this.verificaPosicao() == true) {
                System.out.println("Você moveu para cima.");
                return true;
            } else {
                this.atacar(this.getPersonagemPosicaoOcupada());
                this.posicaohorizontal--;
                return false;
            }
        } else if ((direcao == Direcao.BAIXO) && (this.posicaovertical > 0)) {
            this.posicaovertical--;
            if (this.verificaPosicao() == true) {
                System.out.println("Você moveu para baixo.");
                return true;
            } else {
                this.atacar(this.getPersonagemPosicaoOcupada());
                this.posicaovertical++;
                return false;
            }
        } else if (direcao == Direcao.NAOMOVER) {
            System.out.println("Você não quis mover.");
            return true;
        } else {
            System.out.println("Você perdeu a rodada de movimento. O personagem não pode se movimentar nessa direção.");
            return false;
        }
    }

    public boolean verificaPosicao() {
        for (Personagem personagem : Personagem.getpersonagensJogo()) {
            if (((personagem.getPosicaohorizontal()) == this.getPosicaohorizontal()) && ((personagem
                    .getPosicaovertical()) == this.getPosicaovertical()) && (this != personagem)) {
                return false;
            }
        }
        return true;
    }

    public Personagem getPersonagemPosicaoOcupada() {
        for (Personagem personagem : Personagem.getpersonagensJogo()) {
            if (((personagem.getPosicaohorizontal()) == this.getPosicaohorizontal()) &&
                    ((personagem.getPosicaovertical()) == this.getPosicaovertical()) &&
                    (this != personagem)) {
                // System.out.println("ENTROU");
                return personagem;
            }
        }
        return this;
        

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
