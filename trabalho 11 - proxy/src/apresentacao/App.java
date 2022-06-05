package apresentacao;

import negocio.*;


public class App {
    public static void main(String[] args) throws Exception {
       Empregado joaomanobra = new Empregado("João", new Data("06/06/1992") , "0101222222");
       Empregado mariaestagiaria = new Empregado("Maria", new Data("10/10/2010"), null);
       Empregado ticiocontador = new Empregado("Ticio", new Data("10/01/1950"), null);
       Carro ferrari = new Carro(1980, "GTS 50", "Ferrari", "ith9090", "sda1515105115011");
       CarroProxy cproxy = new CarroProxy(ferrari);

       cproxy.manobrar(joaomanobra);
       cproxy.manobrar(mariaestagiaria);
       cproxy.manobrar(ticiocontador);


    }
}
