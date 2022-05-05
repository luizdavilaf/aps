package apresentacao;
import negocio.*;

public class App {
    public static void main(String[] args) throws Exception {
        String localDoArquivo = "src/apresentacao/listaPessoas.csv";        
        Teste teste = new Teste(localDoArquivo);         
        XLS xls = new XLS(localDoArquivo);
        DOC doc = new DOC(localDoArquivo);
        HTML html = new HTML(localDoArquivo);
        TXT pdf = new TXT(localDoArquivo);
        XML xml = new XML(localDoArquivo);
        teste.Exportar(localDoArquivo);        
        html.Exportar(localDoArquivo);
        pdf.Exportar(localDoArquivo);
        xml.Exportar(localDoArquivo);
        doc.Exportar(localDoArquivo);
        xls.Exportar(localDoArquivo);
    }
}
