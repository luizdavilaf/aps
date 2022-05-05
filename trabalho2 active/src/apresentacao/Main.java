package apresentacao;

import java.sql.SQLException;
import java.util.ArrayList;
import negocio.*;
import persistencia.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Contato contato = new Contato();
        Contato c1 = new Contato("Luiz", "888.888.888-87");
        Contato c2 = new Contato("Roberto", "777.888.888-88");
        Contato c3 = new Contato("Claudio", "666.888.888-86");
        Contato c4 = new Contato("Nicole", "555.888.888-85");
        Contato c5 = new Contato("Renan", "444.888.888-84");
        Contato c6 = new Contato("Marcio", "333.888.888-83");
        Contato c7 = new Contato("Igor", "222.888.888-82");
        Contato c8 = new Contato("Bob", "111.888.888-81");
        Contato c9 = new Contato("Pedro", "000.888.888-80");
        Contato c10 = new Contato("Scooby", "999.888.888-89");
        //CRIANDO CONTATOS
        c1.create();
        c2.create();
        


        
        PessoaJuridica PJ = new PessoaJuridica();
        PessoaJuridica PJ1 = new PessoaJuridica("06.214.097.0001-11","Organizações Globo SA");
        PessoaJuridica PJ2 = new PessoaJuridica( "00.000.000.0001-11", "RBS TV SA");
        //lendo contato
        c1.read();
        c2.read();        
        //criando pj
        PJ1.create(c1);
        PJ2.create(c2);
        //lendo pj
        PJ1.read();
        PJ2.read();

        Endereco endereco = new Endereco();
        Endereco e1 = new Endereco( "Avenida Pelotas", 420, "Cidade Nova", "");
        Endereco e2 = new Endereco( "Avenida MAUA", 123, "ASSE Nova", "");
        Endereco e3 = new Endereco( "Avenida TONAR", 111, "Asgard", "");
        Endereco e4 = new Endereco( "Rua 12", 12, "Gests", "");
        Endereco e5 = new Endereco( "Avenida RG", 444, "Cidade NEW", "");
        Endereco e6 = new Endereco("Avenida Gestapo", 987, "Germania", "");
        Endereco e7 = new Endereco( "Avenida Moscou", 123, "Putin", "");

        //criando endereços
        e1.create(c1,PJ1);
        e2.create(c2);
        e3.create(c2);
        e4.create(c1, PJ2);
        e5.create(c1);        
        e6.create(c2, PJ2);

        //lendo e1
        e1.read();
        /* System.out.println(e1.getLogradouro());
        System.out.println(e1.getBairro());
        System.out.println(e1.getNumero()); */
        

       
        //listando endereços do c1
       /*  System.out.println("contato: " + c1.getNome());
        ArrayList<Endereco> vetenderecos = c1.getVetEnderecos();

        for (int j = 0; j < vetenderecos.size(); j++) {
            Endereco endereco1 = vetenderecos.get(j);
            System.out.println("endereço " + (j + 1) + ":");
            System.out.println("logradouro: " + endereco1.getLogradouro());
            System.out.println("numero: " + endereco1.getNumero());
            System.out.println("bairro: " + endereco1.getBairro());
            System.out.println("complemento: " + endereco1.getComplemento());
            System.out.println("-----");
        }
        System.out.println("-------------------------------------------------");

        //listando PJs de c1
        System.out.println("contato: " + c1.getNome());
        ArrayList<PessoaJuridica> vPessoaJuridicas = c1.getVetPJ();

        for (int j = 0; j < vPessoaJuridicas.size(); j++) {
            PessoaJuridica PJtesste = vPessoaJuridicas.get(j);
            System.out.println("empresa " + (j + 1) + ":");
            System.out.println("cnpj: " + PJtesste.getCnpj());
            System.out.println("nome fantasia: " + PJtesste.getNomeFantasia());            
            System.out.println("-----");
        }
        System.out.println("-------------------------------------------------"); */

        
/* 
        //update c1
        c1.setNome("Luiz Davila");
        c1.update();
        c1.read();
        System.out.println("nome atualizado: "+c1.getNome());

        //update e1
        e1.setLogradouro("5th Avenue");
        e1.update();
        e1.read();
        System.out.println("endereço atualizado: " + e1.getLogradouro());


        //update PJ1
        PJ1.setNomeFantasia("Sistema Brasileiro de Telecomunicações SA");
        PJ1.update();
        PJ1.read();
        System.out.println("nome da empresa atualizado: " + PJ1.getNomeFantasia()); */

        // deletando C1
        // c1.delete();

        // deletando PJ1
        /*
         * PJ1.delete(c1);
         * System.out.println("PJ deletada");
         * 
         * // listando PJs de c1
         * System.out.println("contato: " + c1.getNome());
         * ArrayList<PessoaJuridica> vPessoaJuridicas1 = c1.getVetPJ();
         * 
         * for (int j = 0; j < vPessoaJuridicas1.size(); j++) {
         * PessoaJuridica PJtesste = vPessoaJuridicas1.get(j);
         * System.out.println("empresa " + (j + 1) + ":");
         * System.out.println("cnpj: " + PJtesste.getCnpj());
         * System.out.println("nome fantasia: " + PJtesste.getNomeFantasia());
         * System.out.println("-----");
         * }
         * System.out.println("-------------------------------------------------");
         */

         //deletando e1
         e1.obterContato();
         e1.delete();
         e1.read();
        
         
         e4.read();
         
         e4.delete();


         //listando enderecos de C1
         /* System.out.println("contato: " + c1.getNome());
         ArrayList<Endereco> vetenderecos1 = c1.getVetEnderecos();

         for (int j = 0; j < vetenderecos1.size(); j++) {
             Endereco endereco1 = vetenderecos1.get(j);
             System.out.println("endereço " + (j + 1) + ":");
             System.out.println("logradouro: " + endereco1.getLogradouro());
             System.out.println("numero: " + endereco1.getNumero());
             System.out.println("bairro: " + endereco1.getBairro());
             System.out.println("complemento: " + endereco1.getComplemento());
             System.out.println("-----");
         }
         System.out.println("-------------------------------------------------"); */


         // listando enderecos de pj1
       /*   System.out.println("empresa: " + PJ1.getNomeFantasia());
         ArrayList<Endereco> vetenderecos2 = PJ1.getVetEnderecos();

         for (int j = 0; j < vetenderecos2.size(); j++) {
             Endereco endereco1 = vetenderecos2.get(j);
             System.out.println("endereço " + (j + 1) + ":");
             System.out.println("logradouro: " + endereco1.getLogradouro());
             System.out.println("numero: " + endereco1.getNumero());
             System.out.println("bairro: " + endereco1.getBairro());
             System.out.println("complemento: " + endereco1.getComplemento());
             System.out.println("-----");
         }
         System.out.println("-------------------------------------------------"); */
         


















        /* e1.read(1);
        e1.update();
        e1.delete(); */


        
        //PJ.create(c1);
         //System.out.println("id: " + c1.getId());
        // c.setNome("Luiz Sebastião");
        // c.setCpf("888.888.888-51");
        // c.create();
        //PJ.read(15);
        // c.setNome("Roberto Jefferson");
        /* PJ.setNomeFantasia("RBS TV SA");        
        PJ.update(); */
        //PJ.delete(c1);
        
        /* System.out.println("nome: "+PJ1.getContato().getNome());
        System.out.println("fantasia: " + PJ1.getNomeFantasia());
        System.out.println("cnpj: " + PJ1.getCnpj());
        System.out.println("cpf: " +PJ1.getContato().getCpf()); */
        

        
        /*  ArrayList<Contato> vetContato = Contato.list();
         for(int i=0; i <vetContato.size(); i++)
         {
         System.out.println("Nome: "+ vetContato.get(i).getNome());
         } */
        
    }

}
