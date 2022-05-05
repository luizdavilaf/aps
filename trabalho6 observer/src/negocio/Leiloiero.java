package negocio;

import java.util.ArrayList;

public class Leiloiero implements Subject{
    private ArrayList<Observer> vetComprador;
    private ArrayList<Item> vetItem;

    public Leiloiero() {
        this.vetComprador = new ArrayList();
        this.vetItem = new ArrayList();
    }

    @Override
    public void addObserver(Observer observer) {
        this.vetComprador.add(observer);
        
    }

    @Override
    public void removeObserver(int i) {
        this.vetComprador.remove(i);
        
    }

    @Override
    public void removeObserver(Observer observer) {
        this.vetComprador.remove(observer);
        
    }

    @Override
    public void notifyObservers() {     
        for(Observer o : vetComprador){
            o.update(this.vetItem.get(this.vetItem.size()-1));            
        }
    }

    public void addItem(Item item){
        this.vetItem.add(item);
        this.notifyObservers();
    }

    public void addLance(Item item, double valorDoLance, Comprador comprador)
    {
        if(valorDoLance> item.getLanceAtual()){
            item.setLanceAtual(valorDoLance);
            item.setDonoMaiorLance(comprador);
            this.notifyObservers();
        }
        else{
            System.out.println("O valor de: R$ "+valorDoLance + " é inferior ao maior lance do item "+ item.getNome()+".");
        }
    }
    
    
}
