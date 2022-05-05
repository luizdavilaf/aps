package negocio;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import persistencia.ConexaoPostgreSql;

import java.util.ArrayList;

public class PessoaJuridica extends Contato{
    private String cnpj;
    private String nomeFantasia;
    protected Contato contato;
    private int idpj;
    protected ArrayList<Endereco> enderecos = new ArrayList<>();

     public PessoaJuridica(Contato contato, String cnpj, String nomeFantasia)
    {
        this.contato=contato;
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    } 

    public PessoaJuridica() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public ArrayList<Endereco> getVetEnderecos() {
        return enderecos;
    }

    public void SetVetEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void create(Contato contato) throws SQLException {
        String sql = "INSERT INTO pessoajuridica (cnpj, nomefantasia, contato) VALUES (?, ?, ?) returning id;";
        Connection connection = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);        
        preparedStatement.setString(1, this.getCnpj());
        preparedStatement.setString(2, this.getNomeFantasia());
        preparedStatement.setInt(3, contato.getId());
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            this.setIDPJ(rs.getInt("id"));
        }
        contato.getVetPJ().add(this);
        contato.getVetPJ();
        preparedStatement.close();
        connection.close();
    }

    public int getIdPJ() {
        
        return idpj;
    }

    public void setIDPJ(int idpj) {

        this.idpj= idpj;
    }

    public void read() throws SQLException {
        String sql = "SELECT pessoajuridica.id as idpj, pessoajuridica.cnpj as cnpj, pessoajuridica.nomefantasia as nome_fantasia, contato.cpf as cpf, contato.nome as nome	FROM public.pessoajuridica	join contato on (contato.id = pessoajuridica.contato) WHERE pessoajuridica.id = ?; ";
        Connection conexao = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, this.getIdPJ());
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            this.setContato(new Contato(rs.getString("nome"), rs.getString("cpf")));
            this.setIDPJ(rs.getInt("idpj"));
            this.setNomeFantasia(rs.getString("nome_fantasia"));  
            this.setCnpj(rs.getString("cnpj"));
        }
        preparedStatement.close();
        conexao.close();
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public void update() throws SQLException {
        String sql = "UPDATE pessoajuridica SET nomefantasia = ? WHERE id = ?;";
        Connection connection = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, this.getNomeFantasia());
        preparedStatement.setInt(2, this.getIdPJ());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    public void delete(Contato contato) throws SQLException {
        String sql = "DELETE FROM pessoajuridica WHERE id = ? ;";
        Connection conexao = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, this.id);
        preparedStatement.execute();
        contato.getVetPJ().remove(this);
        contato.getVetPJ();
        preparedStatement.close();
        conexao.close();
    }

    
    
}
