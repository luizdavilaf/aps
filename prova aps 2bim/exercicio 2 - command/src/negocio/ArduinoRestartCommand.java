package negocio;

public class ArduinoRestartCommand implements Command{

    private Arduino arduino;
    
    public ArduinoRestartCommand(Arduino arduino){
        this.arduino = arduino;
    }

    @Override
    public void execute() {
        this.arduino.restart();
    }
    
}
