package negocio;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;



public class XML extends Conversao{

    public XML(String nomeDoArquivo) {
        super(nomeDoArquivo);
        
    }

    @Override
    public String conversao(ArrayList<Pessoa> pessoas) throws FileNotFoundException, IOException {
        FileWriter arquivo = new FileWriter("src/apresentacao/listadePessoas.xml");
        arquivo.write("<?xml version='1.0' encoding='UTF-8' standalone='no'?><pessoas>\n");
        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa p = pessoas.get(i);
            arquivo.write("<pessoa>\n<nome>" + p.getNome() + "</nome>"+
            "\n<email> " + p.getEmail() + "</email>\n</pessoa>\n");
        }
        arquivo.write("</pessoas>");
        arquivo.close();
        
        
        return "feito xml";
    }
    
}
