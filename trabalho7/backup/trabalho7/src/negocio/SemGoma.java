package negocio;

public class SemGoma implements EstadoMaquina{    

    public SemGoma(){
        System.out.println("Máquina sem goma, chame o Administrador!!");        
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
        return this;
    }

    @Override
    public EstadoMaquina abasteceMaquina(int entradagoma) {                      
        return new SemMoeda() ;
    }

}
