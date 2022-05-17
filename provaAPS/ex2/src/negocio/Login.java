/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;


public abstract class Login {

    private String login;
    private String senha;
    
    public Login ()
    {
        this.login=null;
        this.senha=null;
    }
    public void logar(){
        this.identificacao();
        
        this.aviso(this.autenticacao());
        
    }

    protected abstract void identificacao();
    
    private boolean autenticacao() {
        if((this.senha!=null)&&(this.login!=null)){
            return true ;           
        }
        else if ((this.senha=="")|(this.login=="")) {
            return false;            
        }
        else{
            return false;
        }
        
    }   

    protected abstract void aviso(boolean resposta);

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

   
}
