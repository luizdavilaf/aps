package negocio;

public class RecebeMoeda implements EstadoMaquina {

    public RecebeMoeda(){
        System.out.println("Moeda recebida, acione a alavanca!");
    }

    public RecebeMoeda(String string) {
    }

    @Override
    public EstadoMaquina ejetaMoeda() {
        System.out.println("Moeda ejetada!");
        return new SemMoeda();
    }

    @Override
    public EstadoMaquina acionaAlavanca() {        
        return new GomaVendida();
    }

    @Override
    public EstadoMaquina entregaGoma() {       
        return this;
    }

    @Override
    public EstadoMaquina insereMoeda() {        
        return this ;
    }

    @Override
    public EstadoMaquina abasteceMaquina(int entradagoma) {        
        return new SemMoeda();
    }
    
}
