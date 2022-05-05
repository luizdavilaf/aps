package negocio.Personagens;

import negocio.Jogador;

public class Peao extends Personagem{

    public Peao(int posicaovertical, int posicaohorizontal, Jogador jogador) {
        super(posicaovertical, posicaohorizontal, jogador);
        this.vida = 20;
        this.nome="Pawn  ";
             
        
    }

    public Peao() {
    }

    @Override
    public String getNome() {
        
        return nome;
    }

   
    
}
