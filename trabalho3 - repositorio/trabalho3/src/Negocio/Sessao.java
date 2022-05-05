package Negocio;

import java.time.LocalDate;
import java.time.LocalTime;
//import java.util.Date;
import java.util.ArrayList;

public class Sessao {
    private String nome;
    private int id;
    private Sala sala;
    private Filme filme;
    private LocalDate data;
    private LocalTime hora;
    private double valor;
    private ArrayList<Lugar> lugaresvendidos = new ArrayList<>();
    private ArrayList<Lugar> lugaresLivres = new ArrayList<>();
    private ArrayList<Bilhete> bilhetes = new ArrayList<>();

    public ArrayList<Bilhete> getBilhetes() {
        return bilhetes;
    }



    public void setBilhetes(ArrayList<Bilhete> bilhetes) {
        this.bilhetes = bilhetes;
    }



    public void setLugaresLivres(ArrayList<Lugar> lugaresLivres) {
        this.lugaresLivres = lugaresLivres;
    }



    public ArrayList<Lugar> getLugaresvendidos() {
        return lugaresvendidos;
    }



    public void setLugaresvendidos(ArrayList<Lugar> lugaresvendidos) {
        this.lugaresvendidos = lugaresvendidos;
    }

    public ArrayList<Lugar> getLugaresLivres() {
        lugaresLivres.removeAll(lugaresvendidos);
        return lugaresLivres;
    }



    public Sessao(Sala sala, Filme filme, LocalDate data, LocalTime hora, double valor ){
        this.valor=valor;        
        this.filme=filme;
        this.sala=sala;
        this.data=data;
        this.hora=hora;
        this.lugaresLivres=sala.getLugares();
        
    }

    

    @Override
    public String toString() {
        return "Sessao [data=" + data + ", filme=" + filme + ", hora=" + hora + ", sala=" + sala + ", valor=" + valor
                + "]";
    }



    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
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
    
    public Sala GetSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Filme GetFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public void venderLugar(Lugar lugar)
    {
        Bilhete bilhete = new Bilhete(lugar, this);
        this.lugaresvendidos.add(lugar);
        this.lugaresLivres.remove(lugar);
        lugar.getBilhetes().add(bilhete);
        this.getBilhetes().add(bilhete);
        
    }
    
}
