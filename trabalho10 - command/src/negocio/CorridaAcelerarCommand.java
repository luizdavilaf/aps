package negocio;

public class CorridaAcelerarCommand implements Command{

    private Corrida corrida;

    public CorridaAcelerarCommand(Corrida corrida) {
        this.corrida = corrida;
    }

    @Override
    public void execute() {
        this.corrida.acelerar();
        
    }

    
    
}
