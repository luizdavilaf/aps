package apresentacao;

import negocio.*;

public class App {
    public static void main(String[] args) throws Exception {

        SimpleRemoteControl controle = new SimpleRemoteControl();       

        controle.setSlot(0, new ArduinoHibernateCommand(new Arduino()));
        controle.setSlot(1, new ArduinoRestartCommand(new Arduino()));
        controle.setSlot(2, new ArduinoShutdownCommand(new Arduino()));
        controle.buttonWasPressed(0);//hibernate
        controle.buttonWasPressed(1);//restart
        controle.buttonWasPressed(2);//shutdown
        
        
        
    }
}
