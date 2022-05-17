/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iapereira
 */
public class ConexaoPostgreSQL {
    private String host;
    private String port;
    private String username;
    private String password;
    private String dbname;
    
    
    public ConexaoPostgreSQL(){
        this.host = "localhost";
        this.port = "5432";
        this.username = "postgres";
        this.password = "postgres";
        this.dbname = "twitter";
    }
    
    public Connection getConexao(){
        try {
            String url = "jdbc:postgresql://"+this.host+":"+this.port+"/"+this.dbname;
            return DriverManager.getConnection(url, this.username, this.password);
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
