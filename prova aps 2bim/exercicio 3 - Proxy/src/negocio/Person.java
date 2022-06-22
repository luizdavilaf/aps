package negocio;

import java.sql.SQLException;

public interface Person {
    String getNome() throws SQLException;
    int getId();
    
    
}
