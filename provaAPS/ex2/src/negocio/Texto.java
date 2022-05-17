package negocio;
import java.util.Scanner;


public class Texto extends Login{

    Scanner entrada = new Scanner(System.in);
    
    @Override
    protected void identificacao() {
       System.out.println("digite seu login:");
       String log1 = entrada.nextLine(); 
       System.out.println(log1);
       this.setLogin(log1);

        System.out.println("digite sua senha:");
        log1 = entrada.nextLine();
        this.setSenha(log1);
       
        
    }

    @Override
    protected void aviso(boolean resposta) {
        if (resposta==true){
            System.out.println( "Deu boa");
        }
        else{
            System.out.println( "Deu ruim");
        }
    }
    
}