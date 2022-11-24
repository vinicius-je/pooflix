package cdu;

import ui.*;

import java.sql.Connection;

import dominio.*;
import persistence.DAOPerformance;

public class CDUcadastrarPerformance extends CDU{
    private Performance performance;
    private FormPerformance formPerformance;
    Connection con;

    public CDUcadastrarPerformance(FormPerformance formPerformance, Connection con){
        this.formPerformance = formPerformance;
        this.formPerformance.setcduper(this);
        this.con = con;
    }

    public void exec(){
        formPerformance.exibe();
    }

    public void salvarPerformance(){
        String episodioID = formPerformance.getidep();
        String personagemID = formPerformance.getidperson();
        String atorID = formPerformance.getidator();

        performance = new Performance(episodioID, personagemID, atorID);
        DAOPerformance dao = new DAOPerformance(con);
        int rs = dao.add(performance);
        
        if(rs == 0){
            System.out.println("Performance cadastrado com sucesso!");
        }else{
            System.out.println("Não foi possível salvar a performance no banco de dados!");
        }
    }
}
