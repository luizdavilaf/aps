package apresentacao;

import negocio.Maquina;

public class App {
    public static void main(String[] args) throws Exception {
        Maquina maquina1 = new Maquina();
        maquina1.ejetaMoeda();
        maquina1.abasteceMaquina(1);
        maquina1.insereMoeda();
        maquina1.acionaAlavanca();
        
    }
}
