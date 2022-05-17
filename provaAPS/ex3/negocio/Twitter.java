/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.sql.*;
import persistencia.ConexaoPostgreSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Twitter {

    private int id;
    private String usuario;
    private String senha;
    private String mensagem;
    private Connection con;
   // private ArrayList<Twitter> mensagens;

   public Twitter(){

   }

    public Twitter(int id, String usuario, String mensagem) {
        this();
        this.id=id;
        this.usuario=usuario;
        this.mensagem=mensagem;
    }

    public Twitter(int id, String usuario, String senha, String mensagem) {
        
        this.id = id;
        this.usuario = usuario;
        this.senha=senha;
        this.mensagem = mensagem;
    }

    public Twitter( String usuario, String senha, String mensagem) {
               
        this.usuario = usuario;
        this.senha = senha;
        this.mensagem = mensagem;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setusuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void send() throws SQLException {
        String sql = "INSERT INTO twitter (usuario, senha, mensagem) VALUES (?,?,?) RETURNING id";
        this.con = new ConexaoPostgreSQL().getConexao();
        PreparedStatement preparedStatement = this.con.prepareStatement(sql);
        preparedStatement.setString(1, this.usuario);
        preparedStatement.setString(2, this.senha);
        preparedStatement.setString(3, this.mensagem);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            this.id = rs.getInt("id");
        }
    }

    public static ArrayList<Twitter> listarTodos() throws SQLException {
        ArrayList<Twitter> mensagens = new ArrayList();
        Connection conexao = new ConexaoPostgreSQL().getConexao();
        String sql = "SELECT * FROM twitter;";
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            mensagens.add(new Twitter(rs.getInt("id"), rs.getString("usuario"), rs.getString("mensagem")));
        }
        preparedStatement.close();
        conexao.close();
        return mensagens;
    }
}
