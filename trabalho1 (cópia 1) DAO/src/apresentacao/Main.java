package apresentacao;

import java.sql.SQLException;
import java.util.ArrayList;
import negocio.*;
import persistencia.*;

public class Main 
{
    public static void main(String[] args) throws SQLException    {       
        
        //salvando contato
        //new contatoDAO().inserir(new contato("Roberto","888.888.888-89"));
        //new contatoDAO().inserir(new contato("Luiz sebasti", "888.884.888-88"));
        //new contatoDAO().inserir(new contato("Rambo nitro", "858.884.881-82"));
        
        //listando contatos
        Contato contato = new Contato();
        ArrayList<Contato> vet = ContatoDAO.listar();
        for (int i = 0; i < vet.size(); i++) {
            Contato p = vet.get(i);
            System.out.println("Nome:" + p.getNome()+"\nCpf: "+ p.getCpf()+"\nid: "+ p.getId());

        }
        
        System.out.println(ContatoDAO.obterContato(1).getCpf());
        System.out.println(ContatoDAO.obterContato(2).getCpf());
       
        
        //Endereco endereco1 = new Endereco(,"Napoleão Laureano", 277, "centro", " ", "96200020", "Rio Grande", "Rio Grande do Sul");
        //contato.getVetEnderecos().add(endereco1);
        
        //salvando endereco
        //new ContatoDAO().adicionarEndereco(ContatoDAO.obterContato(9),new Endereco(9,"Napoleão Laureano", 44444, "centro", " ", "96200020", "Rio Grande", "Rio Grande do Sul"));
       // boolean resultado = new contatoDAO().removerendereco(enderecoDAO.obter(5));
       
       
        //contato.SetVetEnderecos(new ContatoDAO().RemoverClienteEnderecos2((ContatoDAO.obterContato(9))));
        //boolean resultado1 = new contatoDAO().removerclienteenderecos((5));
        new ContatoDAO().atualizar(ContatoDAO.obterContato(7));
        //new EnderecoDAO().atualizar(new Endereco("av pelotas" , "bairro" , 88888, 52));
        //listando contatos e seus enderecos
        ContatoDAO contatoDAO = new ContatoDAO();
        
        ArrayList<Contato> vetcontatos = contatoDAO.ListarContatosEnderecos();        
        for (int i = 0; i < vetcontatos.size(); i++)
        {
            Contato c = vetcontatos.get(i);
            System.out.println("contato: "+ c.getNome());
            ArrayList<Endereco> vetenderecos = c.getVetEnderecos();
            
            
            for (int j = 0; j<vetenderecos.size(); j++)
            {
                Endereco endereco = vetenderecos.get(j);
                System.out.println("endereço "+ (j+1)+":");
                System.out.println("logradouro: "+ endereco.getLogradouro());
                System.out.println("numero: "+ endereco.getNumero());
                System.out.println("bairro: "+ endereco.getBairro());
                System.out.println("complemento: "+ endereco.getComplemento());
                System.out.println("-----");
            }
            System.out.println("-------------------------------------------------");

        }
        
            

       
         
         
         

        
        
    }
    
}


