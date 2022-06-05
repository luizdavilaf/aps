package negocio;

public class Data {
    private String data;
    private int ano;
    private int mes;
    private int dia;

    public Data(String data) {
        this.data = data;
        parseData(data);        
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }

    public void parseData(String data){
        String[] dataInteira = data.split("/");
        this.dia = Integer.parseInt(dataInteira[0]);
        this.mes = Integer.parseInt(dataInteira[1]);
        this.ano = Integer.parseInt(dataInteira[2]);
    }
}
