
package negocio;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import persistencia.ConexaoPostgreSql;


public class Pessoa implements Person {
    private String nome;
    private int id;

    
    public Pessoa() {
    }

    public Pessoa(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }
    @Override
    public String getNome() {        
        return this.nome;
    }
    @Override
    public int getId() {        
        return this.id;
    }

    public void read(int id) throws SQLException {
        String sql = "SELECT * from pessoa WHERE id = ?; ";
        Connection conexao = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();        
        while (rs.next()) {
            this.setId(rs.getInt("id"));
            this.setNome(rs.getString("nome"));  
        }
        preparedStatement.close();        
        conexao.close();        
    }
    private void setId(int id) {
        this.id=id;
    }
    private void setNome(String nome) {
        this.nome=nome;
    }

    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + "]";
    }
    
    
}
