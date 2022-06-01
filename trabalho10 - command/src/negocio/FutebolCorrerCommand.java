package negocio;

public class FutebolCorrerCommand implements Command{

    private Futebol futebol;

    public FutebolCorrerCommand(Futebol futebol) {
        this.futebol = futebol;
    }

    @Override
    public void execute() {
        this.futebol.correr();
        
    }
}
