package negocio;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import persistencia.ConexaoPostgreSql;

public class Endereco {
    private int id;
    private int numero;
    //private int id_contato; 
    private String bairro;
    private String logradouro;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    //private String nome_contato;
    private Contato contato; 
    private PessoaJuridica pessoaJuridica;
    //private int idcontato;


    public Endereco(Contato contato, String logradouro, int numero, String bairro, String complemento)
    {
        
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.contato=contato;
        
    }   

    public Endereco(Contato contato, PessoaJuridica pessoaJuridica, String logradouro, int numero, String bairro, String complemento) {

        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.contato = contato;
        this.pessoaJuridica = pessoaJuridica;

    }

    

    public Endereco() {
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
    
    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

   
    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getLogradouro() 
    {
        return logradouro;
    }

    public void setLogradouro(String logradouro) 
    {
        this.logradouro = logradouro;
    }

    public int getNumero() 
    {
        return numero;
    }

    public void setNumero(int numero) 
    {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        if(complemento==null){
            return "";
        }
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    



   

    public void create(Contato contato, PessoaJuridica pessoaJuridica) throws SQLException {
        String sql = "INSERT INTO endereco (contato, logradouro, numero, bairro, complemento, pessoajuridica) VALUES (?, ?, ?, ?, ?, ? ) returning id;";
        Connection conexao = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, contato.getId());
        preparedStatement.setString(2, this.getLogradouro());
        preparedStatement.setInt(3, this.getNumero());
        preparedStatement.setString(4, this.getBairro());
        preparedStatement.setString(5, this.getComplemento());        
        preparedStatement.setInt(6, pessoaJuridica.getIdPJ());
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            this.setId(rs.getInt("id"));
        }
        
        contato.getVetEnderecos().add(this);
        pessoaJuridica.getVetEnderecos().add(this);
        preparedStatement.close();
        conexao.close();
        contato.getVetEnderecos();
        pessoaJuridica.getVetEnderecos();
      
        preparedStatement.close();
        conexao.close();
        contato.getVetEnderecos();
        pessoaJuridica.getVetEnderecos();
    }

    public void create(Contato contato) throws SQLException {
        String sql = "INSERT INTO endereco (contato, logradouro, numero, bairro, complemento) VALUES (?, ?, ?, ?, ? );";
        Connection conexao = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, contato.getId());
        preparedStatement.setString(2, this.getLogradouro());
        preparedStatement.setInt(3, this.getNumero());
        preparedStatement.setString(4, this.getBairro());
        preparedStatement.setString(5, this.getComplemento());       
        

        int resultado = preparedStatement.executeUpdate();
        if (resultado == 1) {
            contato.getVetEnderecos().add(this);            
            preparedStatement.close();
            conexao.close();
            contato.getVetEnderecos();
            
        }
        preparedStatement.close();
        conexao.close();
        contato.getVetEnderecos();
        
    }

    public void read() throws SQLException {
       /*  Endereco endereco = new Endereco();
        Contato contato = new Contato(); */
        String sql = "SELECT endereco.id as id_endereco, endereco.bairro as bairro, endereco.logradouro as logradouro, endereco.numero as numero, endereco.complemento as complemento, endereco.contato as contato, endereco.pessoajuridica as pessoajuridica,contato.nome as nome, contato.cpf as cpf, pessoajuridica.nomefantasia as nomefantasia, pessoajuridica.cnpj as cnpj	FROM public.endereco	left join contato on (contato.id = endereco.contato) 	left join pessoajuridica on (pessoajuridica.id = endereco.pessoajuridica)	where endereco.id= ?";
        Connection conexao = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, this.getId());
        ResultSet rs = preparedStatement.executeQuery();
        
        if (rs.next()) {
            Contato contato1 = new Contato(rs.getString("nome"), rs.getString("cpf"));
            this.setId(rs.getInt("id_endereco"));
            this.setContato(contato1);
            this.setPessoaJuridica(new PessoaJuridica(contato1, rs.getString("cnpj"), rs.getString("nomefantasia")));
            this.setLogradouro(rs.getString("logradouro"));
            this.setNumero(rs.getInt("numero"));
            this.setBairro(rs.getString("bairro"));
            this.setComplemento(rs.getString("complemento"));                     
            this.setLogradouro(rs.getString("logradouro"));            
        }
        preparedStatement.close();
        conexao.close();
        
    }

       
            

    public void update() throws SQLException {
        String sql = "UPDATE endereco SET logradouro = ?, numero = ?, bairro = ? WHERE id = ?;";
        Connection connection = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, this.getLogradouro());
        preparedStatement.setInt(2, this.getNumero());
        preparedStatement.setString(3, this.getBairro());
        preparedStatement.setInt(4, this.getId());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    public void delete() throws SQLException {
        
        String sql = "DELETE FROM endereco WHERE id = ?;";
        Connection conexao = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, this.getId());
        preparedStatement.execute();        
        preparedStatement.close();
        conexao.close();

        
       
    }

    public Contato obterContato() throws SQLException {
        String sql = "SELECT contato.nome as nome, contato.cpf as cpf, endereco.contato as id from endereco join contato on (contato.id = endereco.contato) WHERE id = ?; ";
        Connection conexao = new ConexaoPostgreSql().getConnection();
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, this.getContato().getId());
        ResultSet rs = preparedStatement.executeQuery();
        Contato contato = new Contato();
        while (rs.next()) {
            contato.setId(rs.getInt("id"));
            contato.setNome(rs.getString("nome"));
            contato.setCpf(rs.getString("cpf"));
        }
        preparedStatement.close();
        conexao.close();
        return contato;
    }

   
    
    
   
}




