
package negocio;

import java.sql.SQLException;

public class PessoaProxy implements Person {
    private int id;
    private Pessoa pessoa;
    

    public PessoaProxy(int id) {
        this.id = id;       
    }

    @Override
    public String getNome() throws SQLException {
        this.pessoa = new Pessoa();        
        this.pessoa.read(this.id);        
        return this.pessoa.getNome();
    }

    @Override
    public int getId() {        
        return this.id;
    }

    @Override
    public String toString() {
        return "PessoaProxy [id=" + id + ", pessoa=" + pessoa + "]";
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
