package negocio;

public class SQL {    
    private String comando;    
    private String where;
    private String group;
    private String order;

    public SQL(Builder builder) {        
        this.comando = builder.comando;
        this.where = builder.where;
        this.group = builder.group;
        this.order = builder.order;
    }

    
    
    @Override
    public String toString() {
        return comando + where + group + order;
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



    public static class Builder {        
        private String comando;
        private String where = "";
        private String group = "";
        private String order = "";

        public Builder(Comando comando1, String tabela){
            this.comando = comando1.toString()+ " * from "+ tabela;
        }

        public Builder where(String parametro){
            this.where = " WHERE "+ parametro;
            return this;            
        }

        public Builder group(String parametro){
            this.group = " GROUP BY " + parametro;
            return this;
        }

        public Builder order(String parametro){
            this.group = " ORDER BY " + parametro;
            return this;
        }

        public SQL build(){
            return new SQL(this);
        }

        

    }

}