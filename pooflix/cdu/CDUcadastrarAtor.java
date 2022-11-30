package cdu;

import ui.*;
import dominio.*;
import java.sql.Connection;

import persistence.DAOAtor;

public class CDUcadastrarAtor extends CDU {
    private Ator ator;
    private FormAtor formAtor;
    Connection con;

    public CDUcadastrarAtor(FormAtor formAtor, Connection con){
        this.formAtor = formAtor;
        this.formAtor.setcduca(this);
        this.con = con;
    }

    public void exec(){
        formAtor.exibe();
    }

    public void salvarAtor(){
        String id = formAtor.getid();
        String nome = formAtor.getnome();
        String nacionalidade = formAtor.getnacionalidade();
        
        ator = new Ator(id, nome, nacionalidade);
        DAOAtor dao = new DAOAtor(con);
        int rs = dao.add(ator);
        
        if(rs == 0){
            System.out.println("Ator: " + ator.getnome() +" cadastrado!");
        }else{
            System.out.println("Não foi possível salvar o ator: " + ator.getnome() +" no banco de dados!");
        }
    }
}
