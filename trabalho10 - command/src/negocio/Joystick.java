package negocio;

public class Joystick {
    private Command botaoA;
    private Command botaoB;
    
    
    public Joystick() {
    }   

    public void setBotaoA(Command command) {
        this.botaoA = command;
    }

    public void setBotaoB(Command command) {
        this.botaoB = command;
    }

    public void aButtonPressed(){
        this.botaoA.execute();
    }

    public void bButtonPressed(){
        this.botaoB.execute();
    }

    
    
}
