
package negocio;


public class Mira extends AcessoriosDecorator {
    
    public Mira(Arma arma){
        super();
        super.component = arma;
    }
    
    @Override
    public String getDescription(){
        return super.component.getDescription() + "\n-Mira";
    }

    
    
}
