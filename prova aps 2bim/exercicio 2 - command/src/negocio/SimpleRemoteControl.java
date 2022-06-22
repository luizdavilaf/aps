/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 *
 * @author iapereira
 */
public class SimpleRemoteControl {
    private Command slot[];

    
    public SimpleRemoteControl(){
        this.slot = new Command[3]; 
        this.slot[0] = new noCommand();
        this.slot[1] = new noCommand();
        this.slot[2] = new noCommand();       
    }
    
    public void setSlot(int i, Command command){
        this.slot[i] = command;
    }
    
    public void buttonWasPressed(int i){
        this.slot[i].execute();
    }
    
    
   
}
