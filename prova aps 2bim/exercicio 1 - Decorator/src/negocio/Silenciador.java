
package negocio;

public class Silenciador extends AcessoriosDecorator {
    
    public Silenciador(Arma arma){
        super();
        super.component = arma;
    }
    
    @Override
    public String getDescription(){
        return super.component.getDescription() + "\n-Silenciador";
    }

   

    
    
}
