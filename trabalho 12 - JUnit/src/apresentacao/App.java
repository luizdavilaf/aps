package apresentacao;
//import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import negocio.*;

public class App {

    
        

    public static void main(String[] args) throws Exception {
        Date d = new Date();

    
       
        
    
    // -----------

     // deve ser indiferente a posição do ano, apenas o mês é fixo no meio
     d = new Date(13, 7, 2016);    
    System.out.println(d.day == 13);
    System.out.println(d.month == 7);
    System.out.println(d.year == 2016);

    // os construtores a seguir devem lançar IllegalArgumentException
    // após fazer lançar a exceção comente as linhas para não parar a execução

     // inválido (ambíguo)
    // d = new Date(1900, 7, 2016);

     // inválido (ano abaixo do mínimo 1900)
      //d = new Date(16, 7, 1899);
 
     // inválido (ano abaixo do mínimo 1900)
    // d = new Date(1899, 7, 16);
 
     // inválido (mês inválido)
    // d = new Date(2016, 13, 16);
 
     // inválido (dia inválido)
    //d = new Date(2016, 12, 32);
 
     // inválido (dia inválido)
    // d = new Date(2016, 12, -1);
 
     // inválido (mês inválido)
    // d = new Date(2016, -1, 16);
 
     // inválido (dia inválido)
    // d = new Date(2016, 2, 30);

    // toString
    Date d8 = new Date(5, 5, 2005);
    System.out.println(d8.toString().equals("05/05/2005"));
    d8 = new Date(1, 10, 2001);
    System.out.println(d8.toString().equals("01/10/2001"));


    // comparações
    Date d5 = new Date(1, 7, 2014);
    Date d6 = new Date(1, 7, 2014);
    System.out.println(d5.equals(d6) == true);
    System.out.println(d5.equals(new Date()) == false);

    Date d7 = new Date(23, 4, 2016);
    System.out.println(d5.after(d7) == false);
    System.out.println(d7.after(d5) == true);
    System.out.println(d5.before(d7) == true);
    System.out.println(d7.before(d5) == false);
    System.out.println(d7.before(d7) == false);
    System.out.println(d7.after(d7) == false);

    // plusDays, minusDays, tomorrow e yesterday
    d = new Date(2016, 4, 22);
    Date d2 = d.yesterday();
    System.out.println(d2.day == 21);
    System.out.println(d2.month == 4);
    System.out.println(d2.year == 2016);

    // lembrando que é imutável
    System.out.println(d.day == 22);
    System.out.println(d.month == 4);
    System.out.println(d.year == 2016);

    d2 = d.tomorrow();
    System.out.println(d2.day == 23);
    System.out.println(d2.month == 4);
    System.out.println(d2.year == 2016);

    Date d3 = d2.plusDays(10);
    System.out.println(d3.day == 3);
    System.out.println(d3.month == 5);
    System.out.println(d3.year == 2016);

    Date d4 = d3.minusDays(10);
    System.out.println(d4.day == 23);
    System.out.println(d4.month == 4);
    System.out.println(d4.year == 2016);

    // situações complexas
    Date q = new Date(20, 2, 2016);
    q = q.plusDays(9);
    System.out.println(q.toString().equals("29/02/2016"));
     for (int i = 0; i < 400; i++) q = q.tomorrow();

   System.out.println(q.toString().equals("04/04/2017")); 
    q = q.plusDays(365);
    System.out.println(q.toString().equals("04/04/2018")); 
    }
}
