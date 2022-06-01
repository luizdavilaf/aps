package negocio;

public class LutaSocarAltoCommand implements Command{

    private Luta luta;

    public LutaSocarAltoCommand(Luta luta) {
        this.luta = luta;
    }

    @Override
    public void execute() {
        this.luta.socarAlto();
        
    }

    
    
}
