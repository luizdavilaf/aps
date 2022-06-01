package negocio;

public class FutebolChutarCommand implements Command{

    private Futebol futebol;

    public FutebolChutarCommand(Futebol futebol) {
        this.futebol = futebol;
    }

    @Override
    public void execute() {
        this.futebol.chutar();
        
    }
    
}
