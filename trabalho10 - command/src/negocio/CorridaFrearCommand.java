package negocio;

public class CorridaFrearCommand implements Command{

    private Corrida corrida;

    public CorridaFrearCommand(Corrida corrida) {
        this.corrida = corrida;
    }

    @Override
    public void execute() {
        this.corrida.frear();
        
    }
    
}
