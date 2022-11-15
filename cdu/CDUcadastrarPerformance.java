package cdu;

import ui.*;
import dominio.*;

public class CDUcadastrarPerformance extends CDU{
    private Performance performance;
    private FormPerformance formPerformance;

    public CDUcadastrarPerformance(FormPerformance formPerformance){
        this.formPerformance = formPerformance;
        this.formPerformance.setcduper(this);
    }

    public void exec(){
        formPerformance.exibe();
    }

    public void salvarPerformance(){
        String episodioID = formPerformance.getidep();
        String personagemID = formPerformance.getidperson();
        String atorID = formPerformance.getator();

        /*
         * Pegar os dados de episodio, personagem e ator do banco de dados e criar uma classe para passar
         * na instância de Performance
         */

        //performance = new Performance(episodio, personagem, ator);
        //bd.salvarPerformance
        System.out.println("Salvando no banco de dados..." + performance); 
    }
}
