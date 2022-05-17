package negocio;

public class Maquina {

    protected EstadoMaquina estado;
    protected int gomas;
    private RecebeMoeda novagoma = new RecebeMoeda("teste");

    public Maquina() {
        this.estado = new SemGoma();
        gomas=0;
    }

    public EstadoMaquina getEstado() {
        return estado;
    }

    public void setEstado(EstadoMaquina estado) {
        this.estado = estado;
    }

    public int getGomas() {
        return gomas;
    }

    public void setGomas(int gomas) {
        this.gomas = gomas;
    }   

    public void ejetaMoeda(){
        this.estado = this.estado.ejetaMoeda();
    }

    public void acionaAlavanca(){        
        if(this.estado.getClass()==novagoma.getClass()  ) //vem do estado recebemoeda
        {                  
            gomas--;
            this.estado = new GomaVendida();            
            if(gomas==0){
                this.estado = new SemGoma();
            }else{
                this.estado = this.estado.acionaAlavanca();                
            }
        }else{//demais estados que acionam alavanca
            this.estado = this.estado.acionaAlavanca();
        }
        
    }

    public void entregaGoma(){     
        
        this.estado = this.estado.entregaGoma();
        
    }   

    

    public void insereMoeda(){
        this.estado = this.estado.insereMoeda();
    }

    public void abasteceMaquina(int entradagoma){
        this.estado = this.estado.abasteceMaquina(entradagoma);
        this.gomas = gomas + entradagoma;
    }
    
}
