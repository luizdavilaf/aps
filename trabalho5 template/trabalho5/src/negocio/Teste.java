package negocio;

import java.util.ArrayList;

public class Teste extends Conversao {

    public Teste(String nomeDoArquivo) {
        super(nomeDoArquivo);        
    }

    @Override
    public String conversao(ArrayList<Pessoa> pessoas) {
        String tudo = "Lista\n";
        for(int i=0; i<pessoas.size(); i++)
        {
            Pessoa p = pessoas.get(i);
            tudo = tudo + "Nome: "+p.getNome() + " - Email: " + p.getEmail() + "\n";
        }
        return tudo;
    }
    
}
