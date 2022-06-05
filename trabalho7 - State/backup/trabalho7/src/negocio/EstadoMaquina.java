package negocio;

public interface EstadoMaquina {       

    EstadoMaquina ejetaMoeda();
    EstadoMaquina acionaAlavanca();
    EstadoMaquina entregaGoma();
    EstadoMaquina insereMoeda();
    EstadoMaquina abasteceMaquina(int gomas);
    
}
