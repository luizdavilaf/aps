package negocio;

import javax.swing.JOptionPane;

public class JOption extends Login {

    @Override
    protected void identificacao() {
        this.setLogin(JOptionPane.showInputDialog("digite seu usuario:"));
        this.setSenha(JOptionPane.showInputDialog("digite sua senha:"));
    }

    @Override
    protected void aviso(boolean resposta) {
        if(resposta==true)        {
            JOptionPane.showMessageDialog(null, "deu boa");
        }
        else{
            JOptionPane.showMessageDialog(null, "deu ruim");
        }
    }

}