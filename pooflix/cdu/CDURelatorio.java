package cdu;

import java.sql.*;

import persistence.DBConnection;
import ui.*;

public class CDURelatorio extends CDU {
    private FormRelatorio formRelatorio;
    private DBConnection db;

    public CDURelatorio(FormRelatorio formRelatorio, DBConnection db){
        this.formRelatorio = formRelatorio;
        formRelatorio.setcdur(this);
        this.db = db;
    }

    public void exec(){
        formRelatorio.exibe();
    }

    public void processaOpcao(String opcao){
        switch(opcao) {
            case "3": queryAtorTable(); break;
        }
    }

    public void queryAtorTable(){
        String sql = "SELECT * FROM ator";
        ResultSet res = db.queryTable(sql);

        try {
            while(res.next()){
                String id = res.getString("id");
                String nome =  res.getString("nome");
                String nacionalidade = res.getString("nacionalidade");
                System.out.println("ID: " + id + " Nome: " + nome + " Nacionalidade: " + nacionalidade);
            }   
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
  
    }
}
