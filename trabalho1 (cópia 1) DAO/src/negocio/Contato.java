package negocio;

import java.util.ArrayList;

public class Contato {
    private int id;
    private String nome;
    private String cpf;
    private ArrayList <Endereco> enderecos = new ArrayList<>();
    private Contato contato;


    public Contato(String nome, String cpf)
    {
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

    public Contato getContato(int i) {
        return this;
    }

    
    
}







