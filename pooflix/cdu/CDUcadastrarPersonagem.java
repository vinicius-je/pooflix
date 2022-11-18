package cdu;

import ui.*;
import dominio.*;
import persistence.DBConnection;

public class CDUcadastrarPersonagem extends CDU {
    private Personagem personagem;
    private FormPersonagem formPersonagem;
    DBConnection db;

    public CDUcadastrarPersonagem(FormPersonagem formPersonagem, DBConnection db){
        this.formPersonagem = formPersonagem;
        this.formPersonagem.setcdupe(this);
        this.db = db;
    }

    public void exec(){
        formPersonagem.exibe();
    }

    public void salvarPersonagem(){
        String id = formPersonagem.getid();
        String nome = formPersonagem.getnome();

        personagem = new Personagem(id, nome);
        db.salvarPersonagem(personagem);
        //bd.salvarPersonagem
        //System.out.println("Salvando no banco de dados..." + personagem); 
    }
}
