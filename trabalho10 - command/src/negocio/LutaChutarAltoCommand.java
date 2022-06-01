package negocio;

public class LutaChutarAltoCommand implements Command {

    private Luta luta;

    public LutaChutarAltoCommand(Luta luta) {
        this.luta = luta;
        
    }

    @Override
    public void execute() {
        this.luta.chutarAlto();
        
    }

    
    
}
