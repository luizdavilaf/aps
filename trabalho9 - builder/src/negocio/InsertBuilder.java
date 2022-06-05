package negocio;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InsertBuilder {
    private String comando;
    private String tabela;
    private String colunas;
    private String valores;

    private InsertBuilder(Builder builder) {
        comando = builder.comando;
        tabela = builder.tabela;
        colunas = builder.colunas;
        valores = builder.valores;
    }

    @Override
    public String toString() {
        return comando + tabela + colunas +" values\n" +valores+ ";";
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public String getColunas() {
        return colunas;
    }

    public void setColunas(String colunas) {
        this.colunas = colunas;
    }

    public String getValores() {
        return valores;
    }

    public void setValores(String valores) {
        this.valores = valores;
    }

    public static class Builder {
        private String comando = "";
        private String tabela = "";
        private String colunas = "";
        private String valores = "";

        public Builder() {
            this.comando = "INSERT INTO ";
        }

        public Builder tabela(String tabela1) {
            this.tabela = tabela1;
            return this;
        }

        public Builder colunas(String... colunas1) {
            this.colunas = "(" + Arrays.stream(colunas1).collect(Collectors.joining(",")) + ")";
            return this;
        }

        public Builder valores(String... valores1) {
            this.valores = "(" + Arrays.stream(valores1).collect(Collectors.joining(("','"), "'", "'")) + ")";
            return this;
        }


        public InsertBuilder build() {
            return new InsertBuilder(this);
        }

    }

   

}
