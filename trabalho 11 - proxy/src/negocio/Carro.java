package negocio;

public class Carro implements CarroInterface{
    private int ano;
    private String modelo;
    private String marca;
    private String placa;
    private String chassi;

    
    public Carro(int ano, String modelo, String marca, String placa, String chassi) {
        this.ano = ano;
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.chassi = chassi;
    }


    public int  getAno() {
        return ano;
    }


    public void setAno(int  ano) {
        this.ano = ano;
    }


    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public String getMarca() {
        return marca;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }


    public String getPlaca() {
        return placa;
    }


    public void setPlaca(String placa) {
        this.placa = placa;
    }


    public String getChassi() {
        return chassi;
    }


    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
    
    @Override
    public void manobrar(Empregado empregado){
        System.out.println(this.modelo + " está sendo manobrado por "+ empregado.getNome()+".");
    }
    
    
}
