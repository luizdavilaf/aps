package persistencia;

import java.util.ArrayList;
import negocio.Contato;
import negocio.Endereco;

import java.sql.*;

public class ContatoDAO {

   /*  public void inserir(Contato p) throws SQLException {
        String sql = "INSERT INTO contato (nome, cpf) VALUES (?, ?);";
        Connection connection = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, p.getNome());
        preparedStatement.setString(2, p.getCpf());        
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    public static ArrayList<Contato> listar() throws SQLException {
        ArrayList<Contato> vetContato = new ArrayList<Contato>();
        String sql = "SELECT * FROM contato";
        Connection connection = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        Contato p = null;
        while (rs.next()) {
            p = new Contato();
            p.setId(rs.getInt("id_contato"));
            p.setCpf(rs.getString("cpf"));
            p.setNome(rs.getString("nome"));
            vetContato.add(p);
        }
        preparedStatement.close();
        connection.close();
        return vetContato;
    }

    public ArrayList<Endereco> adicionarEndereco(Contato contato , Endereco endereco) throws SQLException
    {
        //ArrayList<endereco> enderecos = negocio.contato.enderecos;
        String sql = "INSERT INTO endereco (id_contato, logradouro,numero,bairro,complemento,cep,cidade,estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";         
        Connection conexao = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, contato.getId());
        preparedStatement.setString(2, endereco.getLogradouro());
        preparedStatement.setInt(3, endereco.getNumero());
        preparedStatement.setString(4, endereco.getBairro());
        preparedStatement.setString(5, endereco.getComplemento());
         preparedStatement.setString(6, endereco.getCep());
        preparedStatement.setString(7, endereco.getCidade());
        preparedStatement.setString(8, endereco.getEstado());         
        int resultado = preparedStatement.executeUpdate();        
        if (resultado == 1) {                       
            contato.getVetEnderecos().add(endereco);
            preparedStatement.close();
            conexao.close();
            return contato.getVetEnderecos();
        }
        preparedStatement.close();
        conexao.close();
        return contato.getVetEnderecos();
        
    }

    public static Contato obterContato(int id) throws SQLException {
        String sql = "SELECT * from contato WHERE id_contato = ?; ";
        Connection conexao = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);        
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        Contato contato = new Contato();
        while (rs.next()) {                 
            contato.setId(rs.getInt("id_contato"));
            contato.setNome(rs.getString("nome"));
            contato.setCpf(rs.getString("cpf"));
            //contato.getVetEnderecos().add(new endereco(rs.getInt("empregado_id"), rs.getString("empregado_nome")));
        }
        preparedStatement.close();
        conexao.close();
        return contato;
    }

    public ArrayList<Contato> ListarContatosEnderecos() throws SQLException {
        ArrayList<Contato> vetContatos = new ArrayList<>();
        //ContatoDAO contatoDAO = new ContatoDAO();
        String sql = "SELECT contato.nome as nome, endereco.logradouro as logradouro, endereco.numero as numero, endereco.bairro as bairro, endereco.complemento as complemento , endereco.id_contato as id_contato from endereco        join contato on (contato.id_contato = endereco.id_contato) order by contato.nome; ";
        Connection conexao = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        int id_contato = 0;
        Contato contato1 = new Contato();
        while (rs.next()) {
            if (id_contato == 0 || id_contato != rs.getInt("id_contato")) {
               vetContatos.add(contato1);
               contato1 = new Contato();
               
            }
            contato1.setNome(rs.getString("nome"));
            //contato1.setId(rs.getInt("id_contato"));
            contato1.getVetEnderecos().add(new Endereco(contato1, rs.getString("logradouro"), rs.getInt("numero"), rs.getString("bairro"), rs.getString("complemento")));
            
            vetContatos.add(contato1);
        }
        vetContatos.remove(0);
        vetContatos.add(contato1);
        preparedStatement.close();
        conexao.close();
        return vetContatos;
    }
    

    

    //deveria conseguir ajustar a referencia de memoria? não consegui, tentei delete, returning
    public boolean RemoverEnderecosDoContato(int id_contato) throws SQLException {
        String sql = "DELETE FROM endereco WHERE id_contato = ? ;";
        //contato contato = new contato()        ;
        
        //ArrayList<endereco> vetContatos = contato.getVetEnderecos();
        Connection conexao = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, id_contato);
        preparedStatement.execute();
        //ResultSet rs = preparedStatement.executeQuery();        
        preparedStatement.close();
        conexao.close();
        return true;
    
        

    }

   


    public boolean removerCliente(int id_contato) throws SQLException {
        String sql = "DELETE FROM contato WHERE id = ? ;";
        Connection conexao = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, id_contato);
        preparedStatement.execute();
        preparedStatement.close();
        conexao.close();
        return true;

    }

    public void atualizar(Contato c) throws SQLException {
        String sql = "UPDATE contato SET nome = ? WHERE id_contato = ?;";
        Connection connection = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, c.getNome());
        preparedStatement.setInt(2, c.getId());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    public ArrayList<Endereco> RemoverClienteEnderecos2(Contato contato) throws SQLException {
        String sql = "DELETE FROM endereco WHERE id_contato = ?;DELETE FROM contato WHERE id_contato = ?;";
        String sql2 = "SELECT * FROM endereco;";
        Connection conexao = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        ArrayList<Endereco> vetContato = new ArrayList<Endereco>();
        preparedStatement.setInt(1, contato.getId());
        preparedStatement.setInt(2, contato.getId());
        preparedStatement.execute();
        preparedStatement.close();
        Statement stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery(sql2);
        
        Endereco p = null;
        while (rs.next()) {
            p = new Endereco();
            p.setId(rs.getInt("id_contato"));
            p.setBairro(rs.getString("bairro"));
            p.setLogradouro(rs.getString("logradouro"));
            p.setNumero(rs.getInt("numero"));
            p.setComplemento(rs.getString("complemento"));
            p.setCep(rs.getString("cep"));
            p.setCidade(rs.getString("cidade"));
            p.setEstado(rs.getString("estado"));
            vetContato.add(p);
        }
        contato.SetVetEnderecos(vetContato);
        stmt.close();
        conexao.close();
        return vetContato;
        
    } */


}
