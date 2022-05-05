package negocio;

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


    public Endereco(Contato contato, String logradouro, int numero, String bairro, String complemento)
    {
        this.contato = contato;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        
    }   

    public Endereco() {
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

    /* public int getIdcontato(Contato contato) {
        id_contato = contato.getId();
        return id_contato;
    }

    public void setIdcontato(int id_contato) {
        this.id_contato = id_contato;
    }

    public String getNome(Contato contato) {
        nome_contato = contato.getNome();
        return nome_contato;
    }

    public void setNome(String nome_contato) {
        this.nome_contato = nome_contato;
    } */

    public void setContato(Contato contato){
        this.contato = contato;
    }

    public Contato getContato()
    {
        return contato;
    }



   
    
    
   
}




