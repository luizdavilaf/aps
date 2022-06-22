package negocio;

public class ArduinoHibernateCommand implements Command{

    private Arduino arduino;
    
    public ArduinoHibernateCommand(Arduino arduino){
        this.arduino = arduino;
    }

    @Override
    public void execute() {
        this.arduino.hibernate();
    }
    
}
