package negocio.Armas;

public class ArcoEFlecha implements Arma {
    protected final int dano;
    protected final String nome;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ArcoEFlecha other = (ArcoEFlecha) obj;
        if (dano != other.dano)
            return false;
        return true;
    }

    public ArcoEFlecha() {
        this.dano = 20;
        this.nome = "Arco e Flecha";
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
