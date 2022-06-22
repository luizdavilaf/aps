package apresentacao;

import negocio.*;

public class Main {

    public static void main(String[] args) {

        Arma pistola = new Pistola();
        pistola = new Mira(pistola);
        pistola = new Silenciador(pistola);
        System.out.println(pistola.getDescription());
    }

}
