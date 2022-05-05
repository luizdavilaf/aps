package negocio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/* import org.apache.commons.*;
import org.apache.log4j.*;
import org.apache.logging.*;
 */

public class XLS extends Conversao {

    public XLS(String nomeDoArquivo) {
        super(nomeDoArquivo);

    }

    @Override
    public String conversao(ArrayList<Pessoa> pessoas) throws IOException, FileNotFoundException {

        XSSFWorkbook pastaTrabalho = new XSSFWorkbook();

        // pegar o diretório do usuário e criar um arquivo com o determinado nome
        FileOutputStream arquivo = new FileOutputStream(new File("src/apresentacao/listaPessoas.xls"));        

        // criar várias abas
        XSSFSheet abaPrimaria = pastaTrabalho.createSheet("ABA 1");

        // criar linhas (passar o nome da aba onde deseja criar)
        XSSFRow primeiraLinha = abaPrimaria.createRow(0);

        // criar uma célula em uma linha (passar o nome da linha onde deseja criar)
        XSSFCell primeiraCelulaColuna = primeiraLinha.createCell(0);
        XSSFCell segundaCelulaColuna = primeiraLinha.createCell(1);
        primeiraCelulaColuna.setCellValue("Nome");
        segundaCelulaColuna.setCellValue("Email");
        int idlinha = 1;
        for (Pessoa p : pessoas) {
            primeiraLinha = abaPrimaria.createRow(idlinha++);
            int idcelula = 0;
            XSSFCell celula = primeiraLinha.createCell(idcelula++);
            celula.setCellValue(p.getNome());
            celula = primeiraLinha.createCell(idcelula++);
            celula.setCellValue(p.getEmail());

        }

        // escrever tudo o que foi feito no arquivo
        pastaTrabalho.write(arquivo);

        // fecha a escrita de dados nessa planilha
        pastaTrabalho.close();

        return "Feito XLS";
    }

}
