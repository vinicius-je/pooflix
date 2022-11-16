package ui;
import java.io.Console;

import cdu.CDUcadastrarPersonagem;

public class FormPersonagem extends Form {
    private String id;
    private String nome;
    private CDUcadastrarPersonagem cdupe;

    public void setcdupe(CDUcadastrarPersonagem cdupe){
        this.cdupe = cdupe;
    }

    public void exibe(){
        Console c = System.console();
        boolean termina = false;
        String continuar;

        System.out.println("CADASTRANDO PERSONAGEM\n");

        while(!termina){
            id = c.readLine("ID: ");
            nome = c.readLine("Nome: ");

            continuar = c.readLine("Deseja continuar?(s/n): ");
            termina = continuar.toLowerCase().equals("n");

            cdupe.salvarPersonagem();
        }
    }

    public String getid(){
        return id;
    }

    public String getnome(){
        return nome;
    }
}
