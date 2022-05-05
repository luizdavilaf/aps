package negocio.Armas;

public class Machado implements Arma{
    
    protected final int dano;
    protected final String nome;


    public Machado() {
        this.dano = 30;
        this.nome = "Machado";
    }

    @Override
    public int plusDano() {
        return dano;
        
        
    }



    @Override
    public String getNome() {
        
        return nome;
    }



    @Override
    public int getDano() {
        
        return dano;
    }
    
}
