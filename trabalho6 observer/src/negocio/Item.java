package negocio;

public class Item {
    private String nome;
    private double precoInicial;
    private double lanceAtual;
    private Comprador donoMaiorLance;

    
    public Item(String nome, double precoInicial) {
        this.nome = nome;
        this.precoInicial = precoInicial;
        this.lanceAtual = precoInicial;
        this.donoMaiorLance = null;
    }


    @Override
    public String toString() {
        return "Item [donoMaiorLance=" + donoMaiorLance + ", lanceAtual=" + lanceAtual + ", nome=" + nome
                + ", precoInicial=" + precoInicial + "]";
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public double getPrecoInicial() {
        return precoInicial;
    }


    public void setPrecoInicial(double precoInicial) {
        this.precoInicial = precoInicial;
    }


    public double getLanceAtual() {
        return lanceAtual;
    }


    public void setLanceAtual(double lanceAtual) {
        this.lanceAtual = lanceAtual;
    }


    public Observer getDonoMaiorLance() {
        return donoMaiorLance;
    }


    public void setDonoMaiorLance(Comprador donoMaiorLance) {
        this.donoMaiorLance = donoMaiorLance;
    }

}
