
package apresentacao;

import java.sql.SQLException;

import negocio.*;


public class Main {

    
    public static void main(String[] args) throws SQLException {

        PessoaProxy p1 = new PessoaProxy(1);
        System.out.println(p1.getId());
        System.out.println(p1.getNome());
        
    } 
}
