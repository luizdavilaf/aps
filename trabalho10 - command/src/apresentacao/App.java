package apresentacao;

import negocio.*;

public class App {
    public static void main(String[] args) throws Exception {

        Joystick controle = new Joystick();
        Luta StreetFighter = new Luta();
        Corrida TopGear = new Corrida();
        Futebol SuperStarSoccer = new Futebol();
        controle.setBotaoA(new LutaChutarAltoCommand(StreetFighter));
        controle.setBotaoB(new LutaSocarAltoCommand(StreetFighter));
        controle.aButtonPressed();
        controle.bButtonPressed();
        controle.setBotaoA(new FutebolChutarCommand(SuperStarSoccer));
        controle.setBotaoB(new FutebolCorrerCommand(SuperStarSoccer));
        controle.aButtonPressed();
        controle.bButtonPressed();
        controle.setBotaoA(new CorridaAcelerarCommand(TopGear));
        controle.setBotaoB(new CorridaFrearCommand(TopGear));
        controle.aButtonPressed();
        controle.bButtonPressed();
        
    }
}
