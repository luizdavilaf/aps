package negocio.Armas;

public class Espada implements Arma {

    protected final int dano;
    protected final String nome;

    public Espada() {
        this.dano = 150;
        this.nome = "Espada";
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
