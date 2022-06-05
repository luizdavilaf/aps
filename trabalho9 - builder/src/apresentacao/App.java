package apresentacao;

import javax.swing.JOptionPane;

import negocio.*;

public class App {
    public static void main(String[] args) throws Exception {

        

        // SELECT SIMPLES
        SqlBuilder s = new SqlBuilder.Builder(Comando.SELECT).from("pessoa").build();
        System.out.println(s.toString());

        // SELECT MAIS DE UMA COLUNA COM ALIAS
        SqlBuilder s1 = new SqlBuilder.Builder(Comando.SELECT).from("pessoa").colunas("coluna1","coluna2","coluna3","coluna4") 
                .alias("coluninha1", "coluninha2", "coluninha3").build();
        System.out.println(s1.toString());

        // SELECT MAIS DE UMA COLUNA COM JOIN
        SqlBuilder s3 = new SqlBuilder.Builder(Comando.SELECT).from("pessoa").colunas("pessoa.nome","salarios.salario")
                .whereAnd("pessoa.idade>18").join("salarios", "cpf", "pessoa", "cpf").alias("nome", "salario").build();
        System.out.println(s3.toString());

        // delete
        SqlBuilder s11 = new SqlBuilder.Builder(Comando.DELETE).from("pessoa").whereAnd("cpf = '111.111.111-11'")
                .whereAnd("data_nascimento = '29-09-1989'").build();
        System.out.println(s11.toString());

        // update       
        SqlBuilder s12 = new SqlBuilder.Builder(Comando.UPDATE).from("reajustes")
        .criterio("salario=reajustes.salario").tabelaUp("pessoa").build();
        System.out.println(s12.toString());

        // insert
        InsertBuilder s13 = new InsertBuilder.Builder().colunas("nome", "cpf").valores("Luiz", "111.111.111-11")
                .tabela("funcionario").build();
        System.out.println(s13.toString());

        

       






























        /* Object[] options = { "Select Colunas específicas", "Select Tudo", "Delete", "Insert", "Update" };

        int n = JOptionPane.showOptionDialog(null,
                "Qual comando você deseja?",
                "SQL builder",
                JOptionPane.YES_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[4]);

        SqlBuilder s4 = null;
        int operacao;
        int quantcolunas;

        switch (n) {
            case 0:// select colunas
                tabela = JOptionPane.showInputDialog(null, "Qual a tabela?");
                quantcolunas = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantas colunas deseja?"));
                String[] testecol = new String[quantcolunas];
                for (int i = 0; i < quantcolunas; i++) {
                    testecol[i] = JOptionPane.showInputDialog(null, "Qual o nome da coluna " + i);
                }
                s4 = new SqlBuilder.Builder(Comando.SELECT, tabela, testecol).build();
                operacao = 0;
                break;
            case 1:// select TUDO
                tabela = JOptionPane.showInputDialog(null, "Qual a tabela?");
                s4 = new SqlBuilder.Builder(Comando.SELECT, tabela).build();
                operacao = 1;
                break;
            case 2:// delete
                operacao = 2;
                tabela = JOptionPane.showInputDialog(null, "Qual a tabela?");
                s4 = new SqlBuilder.Builder(Comando.DELETE, tabela).build();
                break;
            case 3:// insert
                operacao = 3;
                tabela = JOptionPane.showInputDialog(null, "Qual a tabela?");
                quantcolunas = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantas colunas deseja?"));
                String[] testecol1 = new String[quantcolunas];
                String[] testeparam = new String[quantcolunas];
                for (int i = 0; i < quantcolunas; i++) {
                    testecol1[i] = JOptionPane.showInputDialog(null, "Qual o nome da coluna " + i);
                    testeparam[i] = JOptionPane.showInputDialog(null, "Qual o valor da coluna " + testecol1[i]);
                }
                InsertBuilder s15 = new InsertBuilder.Builder().colunas(testecol1).valores(testeparam).tabela(tabela)
                        .build();
                JOptionPane.showMessageDialog(null, s15.toString());
                break;
            default://// "Update"
                operacao = 4;
                JOptionPane.showMessageDialog(null, "não implementado");
                break;
        }

        if (operacao < 3) {
            Object[] options1 = { "where com and", "where com or", "limit", "group", "order", "join", "encerrar" };

            n = JOptionPane.showOptionDialog(null,
                    "Qual comando você deseja?",
                    "SQL builder",
                    JOptionPane.YES_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options1,
                    options1[6]);
        }
        boolean encerrar = false;
        while (encerrar == false) {
            switch (n) {
                case 0:// "where com and",                
                    break;
                case 1:// "where com or",
                    break;
                case 2:// "limit",
                    break;
                case 3:// "group",
                    break;
                case 4:// "order",
                    break;
                case 5:// "join"
                    break;
                default:// build
                    encerrar = true;
                    break;
            }
        } */

    }
}
