package negocio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public abstract class Conversao {

    private String nomeDoArquivo;

    public Conversao(String nomeDoArquivo) {
        this.nomeDoArquivo = nomeDoArquivo;        
    }


    //template method
    public final void Exportar(String nomeDoArquivo) throws FileNotFoundException, IOException{
        this.exportacao(this.conversao(this.ler(nomeDoArquivo)));
    }

    //imprime
    private void exportacao(String conversao) {
        System.out.println(conversao);
    }


    public abstract String conversao(ArrayList<Pessoa> pessoas) throws FileNotFoundException, IOException ;


    //operação primitiva
    public ArrayList<Pessoa> ler(String nomeDoArquivo) throws FileNotFoundException, IOException {
        ArrayList<Pessoa> pessoas = new ArrayList <Pessoa>();        
        try (BufferedReader br = new BufferedReader(new FileReader(nomeDoArquivo))) {
            String line;
            String divisor=";";
            while ((line = br.readLine()) != null) {
                String[] linhas = line.split(divisor);
                pessoas.add(new Pessoa(linhas[0], linhas[1]));
            }
        }
        return pessoas;
    }

    public String getNomeDoArquivo() {
        return nomeDoArquivo;
    }
    public void setNomeDoArquivo(String nomeDoArquivo) {
        this.nomeDoArquivo = nomeDoArquivo;
    }
   
    



    
}
