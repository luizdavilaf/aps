package negocio;


import java.util.Arrays;
import java.util.stream.Collectors;

public class SqlBuilder {

    protected String comando;
    protected String where;
    protected String group;
    protected String order;
    protected String limit;
    protected String join;
    protected String[] colunas;
    protected String tabela;
    private Builder builder;

    public SqlBuilder(Builder builder) {
        comando = builder.comando;
        where = builder.where;
        group = builder.group;
        order = builder.order;
        limit = builder.limit;
        join = builder.join;
        colunas = builder.colunas;
        tabela = builder.tabela;
    }

    @Override
    public String toString() {
        return comando + join + where + group + order + limit + ";";
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
        private String[] colunas;

        public Builder(Comando comando1, String tabela1) {
            this.tabela = tabela1;
            switch(comando1){
                case SELECT:
                this.comando = comando1.toString() + " *\n from " + tabela1;
                break;
                case DELETE:
                this.comando = comando1.toString() + " \n from " + tabela1;
                break;
                default:
                    break;     
            }
        }

        public Builder(Comando comando1, String tabela1, String... colunas1) {
            this.colunas = colunas1;
            this.tabela = tabela1;
            this.comando = comando1.toString() + Arrays.stream(this.colunas).collect(Collectors.joining(",")) + "\n from "
                    + tabela1;
        }


        //update       
        public Builder(Comando comando1, String tabela1, String coluna, String criterio, String origem) {    
            this.tabela = tabela1;
            this.comando = "UPDATE " + tabela1+ "\n SET "+coluna+ " = "+ criterio +  "\n from "
                    + origem;
        }

        public Builder(){
            this.comando=""            ;
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
            this.comando = "SELECT " + Arrays.stream(this.colunas).collect(Collectors.joining(",")) + "\n from "
                    + this.tabela;
            return this;
        }

        public SqlBuilder build() {
            return new SqlBuilder(this);
        }

        

        

    }
}