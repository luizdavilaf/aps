package Negocio;

import java.util.ArrayList;

public class Filme {

    private String nome;
    private int id;   
    protected ArrayList<Sessao> sessoes = new ArrayList<>(); 
    protected static ArrayList<Filme> filmes = new ArrayList<>();
    private boolean ativo;
    
    public static ArrayList<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(ArrayList<Filme> filmes) {
        Filme.filmes = filmes;
    }

    @Override
    public String toString() {
        return "[nome=" + nome + "]";
    }

    public ArrayList<Sessao> getSessoes() {
        return sessoes;
    }

    public void setSessoes(ArrayList<Sessao> sessoes) {
        this.sessoes = sessoes;
    }

    public Filme(String nome){
        this.nome=nome;
        this.filmes.add(this);
        //this.ativo=true;
    }

    public Filme() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void NovaSessao(Sessao sessao1) {
        this.sessoes.add(sessao1);
        sessao1.GetSala().adicionaSessao(sessao1);
    }
    
}
