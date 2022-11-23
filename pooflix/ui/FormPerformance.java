package ui;

import java.io.Console;

import cdu.CDUcadastrarPerformance;

public class FormPerformance extends Form {
    private String episodioID;
    private String personagemID;
    private String atorID;
    private CDUcadastrarPerformance cduper;

    public void setcduper(CDUcadastrarPerformance cduper){
        this.cduper = cduper;
    }

    public void exibe(){
        Console c = System.console();
        boolean termina = false;
        String continuar;

        System.out.println("CADASTRANDO PERFORMANCE\n");

        while(!termina){
            episodioID = c.readLine("ID episódio: ");
            personagemID = c.readLine("ID personagem: ");
            atorID = c.readLine("ID ator: ");

            continuar = c.readLine("Deseja continuar?(s/n): ");
            termina = continuar.toLowerCase().equals("n");

            cduper.salvarPerformance();
        }
    }

    public String getidep(){
        return episodioID;
    }

    public String getidperson(){
        return personagemID;
    }

    public String getidator(){
        return atorID;
    }
}
