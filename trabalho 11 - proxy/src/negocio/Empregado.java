package negocio;
import java.time.LocalDate;



public class Empregado {
    private String nome;
    private Data dataNascimento;    
    private String numCarteiraMotorista;
    private int idade;

    public Empregado(String nome, Data dataNascimento, String numCarteiraMotorista) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.numCarteiraMotorista = numCarteiraMotorista;
        this.idade = this.calculaIdade();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNumCarteiraMotorista() {
        return numCarteiraMotorista;
    }

    public void setNumCarteiraMotorista(String numCarteiraMotorista) {
        this.numCarteiraMotorista = numCarteiraMotorista;
    }

    public int getIdade() {              
        return idade;
    }

    public int calculaIdade(){
        LocalDate agora = LocalDate.now();
        int idade1 = agora.getYear()- this.dataNascimento.getAno();  
        if((agora.getMonthValue())<(this.dataNascimento.getMes())){
            idade1--;
        }
        if((agora.getMonthValue())==(this.dataNascimento.getMes())){
            if((agora.getDayOfMonth()<this.dataNascimento.getDia())){
                idade1--;
            }
        }
        return idade1;
    }

}
