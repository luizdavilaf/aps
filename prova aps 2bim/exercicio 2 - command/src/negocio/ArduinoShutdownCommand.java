package negocio;

public class ArduinoShutdownCommand implements Command{

    private Arduino arduino;
    
    public ArduinoShutdownCommand(Arduino arduino){
        this.arduino = arduino;
    }

    @Override
    public void execute() {
        this.arduino.shutdown();
    }
    
}
