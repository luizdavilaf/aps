package Negocio;



public class Bilhete {
    private Lugar lugar;
    private int id;
    private Sala sala;
    private Filme filme;    
    private double valor;
    private Sessao sessao;

    public Bilhete(Lugar lugar, Sessao sessao ){
        //this.valor=valor;
        this.lugar=lugar;
        /* this.filme=filme;
        this.sala=sala; */
        this.sessao=sessao;        
    }
    
    @Override
    public String toString() {
        return "Bilhete [id=" + id + ", " + getLugar() + ","  + sessao   +   "]";
    }

    public Sessao GetSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    /* public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    } */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

   /*  public Sala GetSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Filme GetFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    } */
    
}


