package negocio.Armas;

public class Faca implements Arma{
    
    protected final int dano;
    protected final String nome;

    public Faca() {
        this.dano = 100;
        this.nome = "Faca";
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
