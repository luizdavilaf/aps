package apresentacao;
import negocio.*;

public class App {
    public static void main(String[] args) throws Exception {
       Sirene sirene = new Sirene();
       Operario operario1 = new Operario("Luiz");
       sirene.addObserver(operario1);
       sirene.addAlarme( new Alarme ("Inicio do expediente."));
        sirene.addAlarme(new Alarme("Almoço"));

    }
}