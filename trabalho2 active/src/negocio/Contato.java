package negocio;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

import persistencia.ConexaoPostgreSql;

public class Contato {
    protected int id;
    protected  String nome;
    protected  String cpf;
    public ArrayList <Endereco> enderecos = new ArrayList<>();
    private ArrayList<PessoaJuridica> pessoaJuridicas = new ArrayList<>();
    protected Contato contato;


    public Contato(String nome, String cpf)
    {
        super();
        this.nome = nome;
        this.cpf = cpf;
    }

    public Contato() {
    }

    public Contato(Contato contato) {
        this.contato = contato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Endereco> getVetEnderecos() {
        return enderecos;
    }

    public void SetVetEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    
    public void load(int i) {
    }

    public void create() throws SQLException {
        String sql = "INSERT INTO contato (nome, cpf) VALUES (?, ?) returning id;";
        Connection connection = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, this.getNome());
        preparedStatement.setString(2, this.getCpf());
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            this.id = rs.getInt("id");
        }
        preparedStatement.close();
        connection.close();
    }

    

    public void read() throws SQLException {
        String sql = "SELECT * from contato WHERE id = ?; ";
        Connection conexao = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, this.getId());
        ResultSet rs = preparedStatement.executeQuery();        
        while (rs.next()) {
            this.setId(rs.getInt("id"));
            this.setNome(rs.getString("nome"));
            this.setCpf(rs.getString("cpf"));            
        }
        preparedStatement.close();
        conexao.close();        
    }

    public void update() throws SQLException {
        String sql = "UPDATE contato SET nome = ? WHERE id = ?;";
        Connection connection = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, this.getNome());
        preparedStatement.setInt(2, this.getId());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    public void delete() throws SQLException {
        String sql = "DELETE FROM contato WHERE id = ? ;";
        Connection conexao = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, this.id);
        preparedStatement.execute();
        preparedStatement.close();
        conexao.close();        
    }

    public static ArrayList<Contato> list() throws SQLException {
        ArrayList<Contato> vetContato = new ArrayList<Contato>();
        String sql = "SELECT * FROM contato";
        Connection connection = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        Contato p = null;
        while (rs.next()) {
            p = new Contato();
            p.setId(rs.getInt("id"));
            p.setCpf(rs.getString("cpf"));
            p.setNome(rs.getString("nome"));
            vetContato.add(p);
        }
        preparedStatement.close();
        connection.close();
        return vetContato;        
    }

    public ArrayList<PessoaJuridica> getVetPJ() {
        return pessoaJuridicas;
    }

    public void SetVetPJ(ArrayList<PessoaJuridica> pessoaJuridicas) {
        this.pessoaJuridicas = pessoaJuridicas;
    }

    

    

    
    
}







