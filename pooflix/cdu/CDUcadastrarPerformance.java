package cdu;

import ui.*;
import dominio.*;
import persistence.DBConnection;

public class CDUcadastrarPerformance extends CDU{
    private Performance performance;
    private FormPerformance formPerformance;
    DBConnection db;

    public CDUcadastrarPerformance(FormPerformance formPerformance, DBConnection db){
        this.formPerformance = formPerformance;
        this.formPerformance.setcduper(this);
        this.db = db;
    }

    public void exec(){
        formPerformance.exibe();
    }

    public void salvarPerformance(){
        String episodioID = formPerformance.getidep();
        String personagemID = formPerformance.getidperson();
        String atorID = formPerformance.getidator();

        performance = new Performance(episodioID, personagemID, atorID);
        db.salvarPerformance(performance);
    }
}
