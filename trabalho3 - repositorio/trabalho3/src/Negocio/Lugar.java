package Negocio;

import java.util.ArrayList;

public class Lugar {
    private String acento;
    private Sala sala;
    private int id;
    private ArrayList<Bilhete> bilhetes = new ArrayList<>();

    public ArrayList<Bilhete> getBilhetes() {
        return bilhetes;
    }

    public void setBilhetes(ArrayList<Bilhete> bilhetes) {
        this.bilhetes = bilhetes;
    }

    public Lugar(Sala sala, String acento)
    {
        this.sala=sala;
        this.acento=acento;
    }

    @Override
    public String toString() {
        return "Lugar [acento=" + acento +"]";
    }

    public Sala GetSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getAcento() {
        return acento;
    }

    public void setAcento(String acento) {
        this.acento = acento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
