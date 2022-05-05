package Negocio;

import java.util.ArrayList;

public class Sala 
{
    private String nome;
    private int id;
    private ArrayList<Lugar> lugares = new ArrayList<>();
    private ArrayList<Sessao> sessoes = new ArrayList<>();
    
    public ArrayList<Sessao> getSessoes() {
        return sessoes;
    }

    public void setSessoes(ArrayList<Sessao> sessoes) {
        this.sessoes = sessoes;
    }

    public ArrayList<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(ArrayList<Lugar> lugares) {
        this.lugares = lugares;
    }

    public Sala(String nome){
        this.nome=nome;
    }

    @Override
    public String toString() {
        return "[nome=" + nome + "]";
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

    public void adicionaLugar(Lugar lugar){
        this.lugares.add(lugar);
    }

    public void adicionaSessao(Sessao sessao) {
        this.sessoes.add(sessao);
    }
    

}
