package apresentacao;

import negocio.*;

public class App {
    public static void main(String[] args) throws Exception {
        SQL s = new SQL.Builder(Comando.SELECT, "pessoa").build();
        System.out.println(s.toString());
    }
}
