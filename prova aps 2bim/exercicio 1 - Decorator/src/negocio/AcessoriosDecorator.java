
package negocio;


public abstract class AcessoriosDecorator extends Arma {
    protected Arma component;
    
    @Override
    public String getDescription(){
        return component.getDescription();
    }
}
