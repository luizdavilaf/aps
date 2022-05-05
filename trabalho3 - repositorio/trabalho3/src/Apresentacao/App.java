package Apresentacao;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Negocio.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        
        Sala sala1 = new Sala("Sala 1");
        Lugar lugar1 = new Lugar(sala1, "a1");
        Lugar lugar2 = new Lugar(sala1, "a2");
        Lugar lugar3 = new Lugar(sala1, "a3");
        Lugar lugar4 = new Lugar(sala1, "a4");
        Lugar lugar5 = new Lugar(sala1, "a5");
        sala1.adicionaLugar(lugar1);
        sala1.adicionaLugar(lugar2);
        sala1.adicionaLugar(lugar3);
        sala1.adicionaLugar(lugar4);
        sala1.adicionaLugar(lugar5);
        Filme Avengers = new Filme("Avengers");
        Filme HomemAranha = new Filme("Homem Aranha");        
        Sessao sessao1 = new Sessao(sala1, Avengers, LocalDate.of(2022,1,8), LocalTime.of(18,0,0), 20);
        Sessao sessao2 = new Sessao(sala1, Avengers, LocalDate.of(2022, 1, 9), LocalTime.of(18, 0, 0), 20);
        Sessao sessao3 = new Sessao(sala1, Avengers, LocalDate.of(2022, 1, 10), LocalTime.of(18, 0, 0), 20);
        Avengers.NovaSessao(sessao1);
        Avengers.NovaSessao(sessao2);
        System.out.println((Avengers.getSessoes().toString()));
        //Bilhete bilhete1 = new Bilhete(lugar1, sessao1);
        sessao1.venderLugar(lugar1);
        System.out.println(sessao1.getLugaresvendidos());
        System.out.println(sessao1.getLugaresLivres().toString());
        System.out.println(sala1.getSessoes().toString());
        System.out.println(Filme.getFilmes().toString());


        System.out.println("Qual filme Você deseja assistir?");
        for (Filme filme : Filme.getFilmes()) {
               System.out.println(Filme.getFilmes().indexOf(filme)+"."+ filme.toString());     
                  
        }
        int escolhido= entrada.nextInt();
        Filme filmeescolhido = Filme.getFilmes().get(escolhido);
        System.out.println("Você escolheu: " + filmeescolhido.toString());
        System.out.println(filmeescolhido.getSessoes().toString());


        for (Sessao sessao : filmeescolhido.getSessoes()) {
            System.out.println(filmeescolhido.getSessoes().indexOf(sessao) + "." + sessao.toString());
        }

        System.out.println("Qual Sessão Você deseja assistir?");
        int esc1 = entrada.nextInt();
        Sessao sessaoescolhida = filmeescolhido.getSessoes().get(esc1);
        //System.out.println(sessaoescolhida.toString());


        System.out.println("Qual lugar Você deseja escolher?");
        for (Lugar lugar : sessaoescolhida.getLugaresLivres()) {
            System.out.println(sessaoescolhida.getLugaresLivres().indexOf(lugar) + "." + lugar.toString());
        }

        int esc2 = entrada.nextInt();
        Lugar lugarescolhido = sessaoescolhida.getLugaresLivres().get(esc2);
        sessaoescolhida.venderLugar(lugarescolhido);
        System.out.println(sessaoescolhida.getBilhetes().get(sessaoescolhida.getBilhetes().size()-1));
        //System.out.println(sessaoescolhida.getLugaresLivres().toString());
         

    }
}
