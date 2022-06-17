package apresentacao;

import negocio.*;

public class App {

    public static void main(String[] args) throws Exception {
        Date d = new Date();

        

        //System.out.println(d2);

      
        

        // situações complexas
        Date q = new Date(20, 2, 2016);
        q = q.plusDays(9);
        
        
        
        for (int i = 0; i < 400; i++)
            q = q.tomorrow();

        System.out.println(q.toString().equals("04/04/2017"));
        
        
        
        q = q.plusDays(365);
        System.out.println(q.toString().equals("04/04/2018"));
    }
}
