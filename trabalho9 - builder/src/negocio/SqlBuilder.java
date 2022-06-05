package negocio;


import java.util.Arrays;
import java.util.stream.Collectors;

import javax.swing.JComponent;

public class SqlBuilder {

    protected String comando;
    protected String where;
    protected String group;
    protected String order;
    protected String limit;
    protected String join;
    protected String[] colunas;
    protected String tabela;    
    private String from;
    private String tabelaUpdate;
        private String criterio;

    public SqlBuilder(Builder builder) {
        comando = builder.comando;
        where = builder.where;
        group = builder.group;
        order = builder.order;
        limit = builder.limit;
        join = builder.join;
        colunas = builder.colunas;
        tabela = builder.tabela;
        from = builder.from;
        tabelaUpdate = builder.tabelaUpdate;
        criterio = builder.criterio;
    }
    
    @Override
    public String toString() {
        switch(this.comando){
            case "UPDATE":
            return comando+" " + tabelaUpdate + "\n SET " + criterio+ from +";";
            
            case "DELETE":
            return comando + from +join + where + group + order + limit + ";";
            
            default:
            if(this.colunas==null){
                return comando + " * " + from +join + where + group + order + limit + ";";
            }else{
                return comando +" " +Arrays.stream(this.colunas).collect(Collectors.joining(","))+  from +join + where + group + order + limit + ";";            
            }
            
        }
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getJoin() {
        return join;
    }

    public void setJoin(String join) {
        this.join = join;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
   
    

    public static class Builder {
        private String limit = "";
        private String tabela = "";
        private String comando;
        private String where = "";
        private String group = "";
        private String order = "";
        private String join = "";
        private String from = "";
        private String[] colunas;
        private String tabelaUpdate="";
        private String criterio="";

       

        public Builder(Comando comando1) {   
            this.comando = comando1.toString();
        }

        public Builder from (String tabela1){
            this.tabela = tabela1;
            this.from = "\n from "+tabela1;
            return this;
        }

        public Builder colunas(String ... colunas1){
            this.colunas = colunas1;
            return this;
        }

        public Builder tabelaUp(String tabelaUpdate1){
            this.tabelaUpdate = tabelaUpdate1;
            return this;
        }

        public Builder criterio(String criterio1) {
            this.criterio = criterio1;
            return this;
        }

      

        public Builder limit(int limite) {
            this.limit = "\n LIMIT " + Integer.toString(limite);
            return this;
        }

        public Builder whereAnd(String parametro) {
            if (where == "") {
                this.where = "\n WHERE " + parametro;
            } else {
                this.where = this.where + "\n AND " + parametro;
            }
            return this;
        }

        public Builder whereOr(String parametro) {
            if (where == "") {
                this.where = "\n WHERE " + parametro;
            } else {
                this.where = this.where + "\n OR " + parametro;
            }
            return this;
        }

        public Builder group(String coluna) {
            this.group = "\n GROUP BY " + coluna;
            return this;
        }

        public Builder order(String coluna) {
            this.group = "\n ORDER BY " + coluna;
            return this;
        }

        public Builder join(String tabelajoin, String itemtabelajoin, String tabelain, String itemtabelain) {
            if (this.join == "") {
                this.join = "\n JOIN " + tabelajoin + " on " + tabelajoin + "." + itemtabelajoin + "=" + tabelain + "."
                        + itemtabelain;
                return this;
            } else {
                this.join = this.join + "\n JOIN " + tabelajoin + " on " + tabelajoin + "." + itemtabelajoin + "="
                        + tabelain + "." + itemtabelain;
                return this;
            }
        }

        public Builder alias(String... alias) {
            int tamanho = this.colunas.length;
            int j = 0;
            for (int i = 0; i < tamanho; i++) {

                this.colunas[i] = this.colunas[i] + " as " + alias[j];
                j++;
                if (j == alias.length) {
                    i = tamanho;
                }
            }           
            return this;
        }

        public SqlBuilder build() {
            return new SqlBuilder(this);
        }

        

        

        

    }



    
}