package negocio;

import negocio.Personagens.Personagem;

public class Tabuleiro {
    public static String[][] tabuleiro = new String[10][5]; // neste exemplo são 8 linhas e 8 colunas
    private int linhas = tabuleiro.length;
    private int colunas = tabuleiro[0].length;
    
    
    public String[][] getTabuleiro() {
        return tabuleiro;
    }


    public void setTabuleiro(String[][] tabuleiro) {
        Tabuleiro.tabuleiro = tabuleiro;
    }


    public int getLinhas() {
        return linhas;
    }


    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }


    public int getColunas() {
        return colunas;
    }


    public void setColunas(int colunas) {
        this.colunas = colunas;
    }


    public void PreencherTabuleiro(){
        for (Personagem personagem : Personagem.getpersonagensJogo()) {            
            for (int i = 0; i < linhas; i++) 
            {
                for (int j = 0; j < colunas; j++) {
                    
                        if((i==personagem.getPosicaovertical())&&(j==personagem.getPosicaohorizontal())){
                            tabuleiro[i][j] = personagem.toString2();
                        }
                        else if (tabuleiro[i][j]==null){
                            tabuleiro[i][j] = "  "+"nada   ";
                        }
                    }
                }
                
            }     

    }
    public void imprimirTabuleiro(){
        for (int i = 1; i < linhas; i++) 
        {
            for (int j = 1; j < colunas; j++) {}}}

    
}
