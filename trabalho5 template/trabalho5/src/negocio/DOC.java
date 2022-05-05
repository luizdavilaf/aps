package negocio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
/* import org.apache.commons.*;
import org.apache.log4j.*;
import org.apache.logging.*; */

public class DOC extends Conversao {

    public DOC(String nomeDoArquivo) {
        super(nomeDoArquivo);
    }
    @Override
    public String conversao(ArrayList<Pessoa> pessoas) throws IOException, FileNotFoundException {
        XWPFDocument documento = new XWPFDocument();
        FileOutputStream arquivo = new FileOutputStream(new File("src/apresentacao/listaPessoas.docx"));
        XWPFParagraph paragrafotitulo = documento.createParagraph();
        XWPFRun titulo = paragrafotitulo.createRun();
        paragrafotitulo.setAlignment(ParagraphAlignment.CENTER);
        titulo.setText("Lista de Pessoas");
        titulo.setBold(true);
        titulo.setFontSize(18);
        titulo.addBreak();
        for (Pessoa p : pessoas) {
            XWPFParagraph paragrafo1 = documento.createParagraph();
            XWPFRun corpo = paragrafo1.createRun();
            corpo.setText("Nome: " + p.getNome() + " - Email: " + p.getEmail());
            corpo.addBreak();
        }
        documento.write(arquivo);
        documento.close();
        return "Feito DOC";
    }

}
