package negocio.Armas;

public class SemArma implements Arma{

    
    protected final int dano;
    protected final String nome;

    public SemArma() {
        this.dano = 5;
        this.nome = "Sem Arma";
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
