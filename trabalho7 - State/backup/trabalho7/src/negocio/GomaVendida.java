package negocio;

public class GomaVendida implements EstadoMaquina {

    public GomaVendida(){
        System.out.println("Goma Vendida!");
        this.entregaGoma();         
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
        return new SemMoeda();
    }
    
}
