package negocio;

public class SemMoeda implements EstadoMaquina {

    public SemMoeda(){
        System.out.println("Não tem moeda.");
    }

    @Override
    public EstadoMaquina ejetaMoeda() {        
        return this;
    }

    @Override
    public EstadoMaquina acionaAlavanca() {        
        return this;
    }

    @Override
    public EstadoMaquina entregaGoma() {        
        return this;
    }

    @Override
    public EstadoMaquina insereMoeda() {        
        return new RecebeMoeda();
    }

    @Override
    public EstadoMaquina abasteceMaquina(int entradagoma) {        
        return this;
    }
    
}
