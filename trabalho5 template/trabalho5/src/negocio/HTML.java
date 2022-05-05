package negocio;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HTML extends Conversao {

    public HTML(String nomeDoArquivo) {
        super(nomeDoArquivo);

    }

    @Override
    public String conversao(ArrayList<Pessoa> pessoas) throws FileNotFoundException, IOException {
        BufferedWriter arquivo = new BufferedWriter(new FileWriter("src/apresentacao/listaPessoas.html"));

        String head = "<html lang='pt-br'><head>    <title>lista</title>    <meta charset='utf-8'> " +
                "<meta name='viewport' content='width=device-width, initial-scale=1'>" +
                "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>" +
                "<link rel='stylesheet' href='style.css'>" +
                "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>" +
                "<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'>" +
                "</script><script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>" +
                "<style>body {background-color: gray;}</style></head>";
        String body = "<body><header class='jumbotron'><h1 class='azul'>Lista de pessoas</h1></header>" +
                "<main class='container p-3 my-3 bg-light'>";

        body = body + "<table class='table table-bordered'><thead><tr><th>Nome</th><th>Idade</th></tr></thead>";

        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa p = pessoas.get(i);
            body = body + "<tr><td> " + p.getNome() + "</td><td>Email: " + p.getEmail() + "</td>";
        }
        arquivo.write(head + body + "</main></body></html>");
        arquivo.close();
        return "Feito HTML";
    }

}
