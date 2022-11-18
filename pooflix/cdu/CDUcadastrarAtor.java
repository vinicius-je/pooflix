package cdu;

import ui.*;
import dominio.*;
import persistence.DBConnection;

public class CDUcadastrarAtor extends CDU {
    private Ator ator;
    private FormAtor formAtor;
    DBConnection db;

    public CDUcadastrarAtor(FormAtor formAtor, DBConnection db){
        this.formAtor = formAtor;
        this.formAtor.setcduca(this);
        this.db = db;
    }

    public void exec(){
        formAtor.exibe();
    }

    public void salvarAtor(){
        String id = formAtor.getid();
        String nome = formAtor.getnome();
        String nacionalidade = formAtor.getnacionalidade();
        
        ator = new Ator(id, nome, nacionalidade);
        db.salvarAtor(ator);
        //bd.salvarAtor(ator)
        //System.out.println("Salvando no banco de dados.." + ator.getnome());
    }
}
