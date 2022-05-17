package negocio;

import java.util.ArrayList;

public class Sirene implements Subject{
    private ArrayList<Observer> vetOperarios;
    private ArrayList<Alarme> vetAlarmes;


    public Sirene(){
        this.vetAlarmes = new ArrayList<>();
        this.vetOperarios = new ArrayList<>();
    }
    @Override
    public void addObserver(Observer observer)
    {
        this.vetOperarios.add(observer);
    }

    @Override
    public void removeObserver(int i){
        this.vetOperarios.remove(i);

    }

   

    @Override
    public void notifyObservers(){

        for (int i = 0; i < vetOperarios.size(); i++) {
            Observer operario = vetOperarios.get(i);
            if (this.vetAlarmes.size() >= 1) {
                operario.update(this.vetAlarmes.get(this.vetAlarmes.size() - 1));
            }
        }
    }

    public void addAlarme(Alarme alarme){
        this.vetAlarmes.add(alarme);
        this.notifyObservers();
    }

}