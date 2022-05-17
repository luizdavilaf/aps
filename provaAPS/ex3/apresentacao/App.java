package apresentacao;

import java.util.ArrayList;
import negocio.Twitter;

//feito com active record
public class App {
    public static void main(String[] args) throws Exception {
        Twitter mensagem1 = new Twitter("lsd", "1234", "essa é a mensagem numero 1");
        mensagem1.send();

        ArrayList<Twitter> twitter = Twitter.listarTodos();
        for (int i = 0; i < twitter.size(); i++) {
            Twitter t = twitter.get(i);
            System.out.println("user: " + t.getUsuario());
            System.out.println("mensagem: " + t.getMensagem());

        }
    }
}