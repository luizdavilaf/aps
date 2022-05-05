package apresentacao;

import negocio.Comprador;
import negocio.Item;
import negocio.Leiloiero;

public class App {
    public static void main(String[] args) throws Exception {
        Leiloiero jucao = new Leiloiero();
        Comprador gerundio = new Comprador("Gerundio");
        Comprador infinitivo = new Comprador("Infinitivo");
        jucao.addObserver(gerundio);
        jucao.addObserver(infinitivo);
        Item item1 = new Item("Porsche S2000", 50000);
        jucao.addItem(item1);
        
        jucao.addLance(item1, 49000, gerundio);
        jucao.addLance(item1, 52000, infinitivo);
        
    }
}
