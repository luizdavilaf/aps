package negocio;

public class Comprador implements Observer {

    private String nome;

    public Comprador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(Item item) {
        System.out.println(this.nome+" foi notificado que o item "+ item.getNome() + " recebeu o lance de R$ "+ item.getLanceAtual());
        
    }
    
}
