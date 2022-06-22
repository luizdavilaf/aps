package persistencia;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoPostgreSql {

    private String host;
    private String port;
    private String username;
    private String password;
    private String database;

    public ConexaoPostgreSql(){
        this.host = "127.0.0.1";
        this.port = "5432";
        this.username = "postgres";
        this.password = "postgres";
        this.database = "pessoa";
    }

    public Connection getConnection() {
        String url = "jdbc:postgresql://" + this.host + ":" + this.port + "/" + this.database;
        try {
            // System.out.println("Tudo ok!");
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println("Deu xabum!!");
            Logger.getLogger(ConexaoPostgreSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
