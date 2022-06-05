package negocio;

public class CarroProxy implements CarroInterface{
    private Carro carro;

    public CarroProxy(Carro carro) {
        this.carro = carro;
    }

    @Override
    public void manobrar(Empregado empregado) {
        if((empregado.getNumCarteiraMotorista()!=null) &&(empregado.getIdade()>17))      {
            carro.manobrar(empregado);
        }
        else{
            System.out.println(empregado.getNome()+ " não está autorizado(a) a manobrar o carro.");
        }
        
    }
    
}
