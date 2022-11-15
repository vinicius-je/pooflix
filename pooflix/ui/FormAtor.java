package ui;
import java.io.Console;

import cdu.CDUcadastrarAtor;

public class FormAtor extends Form {
    private String id;
    private String nome;
    private String nacionalidade;
    private CDUcadastrarAtor cduca;

    public void setcduca(CDUcadastrarAtor cduca){
        this.cduca = cduca;
    }

    public void exibe(){
        Console c = System.console();
        boolean termina = false;
        String continuar;

        System.out.println("CADASTRANDO ATOR\n");

        while(!termina){
            id = c.readLine("ID: ");
            nome = c.readLine("Nome: ");
            nacionalidade = c.readLine("Nacionalidade: ");

            continuar = c.readLine("Deseja continuar?(s/n): ");
            termina = continuar.toLowerCase().equals("n");

            cduca.salvarAtor();
        }
    }

    public String getid(){
        return id;
    }

    public String getnome(){
        return nome;
    }

    public String getnacionalidade(){
        return nacionalidade;
    }
}
