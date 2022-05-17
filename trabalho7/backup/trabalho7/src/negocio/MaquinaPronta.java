/* package negocio;

public class MaquinaPronta implements EstadoMaquina {

    public MaquinaPronta(){
        System.out.println("Máquina pronta, Insira Moeda!");
    }

    @Override
    public EstadoMaquina ejetaMoeda() {        
        return new SemMoeda();
    }

    @Override
    public EstadoMaquina acionaAlavanca() {        
        return new SemMoeda();
    }

    @Override
    public EstadoMaquina entregaGoma() {        
        return new SemMoeda();
    }

    @Override
    public EstadoMaquina insereMoeda() {        
        return new RecebeMoeda();
    }

    @Override
    public EstadoMaquina abasteceMaquina(int gomas) {        
        return this;
    }
    
}
 */