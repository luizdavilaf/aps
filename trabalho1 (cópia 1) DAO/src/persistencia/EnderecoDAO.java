package persistencia;

import java.util.ArrayList;
import negocio.Endereco;
import negocio.Contato;
import java.sql.*;

public class EnderecoDAO {
    public static Endereco obter(int id) throws SQLException {
        Endereco endereco = new Endereco();
        Contato contato = new Contato();
        String sql = "SELECT * FROM endereco WHERE endereco_id = ?";
        Connection conexao = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            endereco.setId(rs.getInt("endereco_id"));  
            contato.setId(id);          
            endereco.setLogradouro(rs.getString("logradouro"));            
            endereco.setNumero(rs.getInt("numero"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setComplemento(rs.getString("complemento"));
            endereco.setCep(rs.getString("cep"));
            endereco.setCidade(rs.getString("cidade"));
            endereco.setLogradouro(rs.getString("logradouro"));
            endereco.setEstado(rs.getString("estado"));
        }
        preparedStatement.close();
        conexao.close();
        return endereco;
    }

    public void atualizar(Endereco e) throws SQLException {
        String sql = "UPDATE endereco SET logradouro = ?, numero = ?, bairro = ? WHERE endereco_id = ?;";
        Connection connection = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, e.getLogradouro());
        preparedStatement.setInt(2, e.getNumero());
        preparedStatement.setString(3, e.getBairro());
        preparedStatement.setInt(4, e.getId());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    public boolean removerEndereco(Endereco endereco) throws SQLException {
        Contato contato = new Contato(endereco.getContato());
        String sql = "DELETE FROM endereco WHERE endereco_id = ?;";
        Connection conexao = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, endereco.getId());
        int resultado = preparedStatement.executeUpdate();
        if (resultado == 1) {

            contato.getVetEnderecos().remove(endereco);
            preparedStatement.close();
            conexao.close();
            return true;
        }
        preparedStatement.close();
        conexao.close();
        return false;

    }


    

    

}
