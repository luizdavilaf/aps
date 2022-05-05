package negocio;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class TXT extends Conversao {

    public TXT(String nomeDoArquivo) {
        super(nomeDoArquivo);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String conversao(ArrayList<Pessoa> pessoas) throws FileNotFoundException, IOException {

        FileWriter arquivo = new FileWriter("src/apresentacao/listadePessoas.txt");
        arquivo.write("Lista de pessoas\n\n");        
        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa p = pessoas.get(i);
            arquivo.write( "Nome: " + p.getNome() + " - Email: " + p.getEmail() + "\n");            
        }        
        arquivo.close();
        return "Feito txt";
    }
    
}
