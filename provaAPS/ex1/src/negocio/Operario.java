package negocio;

public class Operario implements Observer{
    private String nome;

    public Operario(String nome){
        this.nome = nome;
    }


    @Override
    public void update(Alarme alarme){
        System.out.println(this.nome + ", é hora do " + alarme.getTitulo());

    }
}