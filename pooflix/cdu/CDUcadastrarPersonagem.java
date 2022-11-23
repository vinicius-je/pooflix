package cdu;

import ui.*;

import java.sql.Connection;

import dominio.*;
import persistence.DAOPersonagem;

public class CDUcadastrarPersonagem extends CDU {
    private Personagem personagem;
    private FormPersonagem formPersonagem;
    Connection con;

    public CDUcadastrarPersonagem(FormPersonagem formPersonagem, Connection con){
        this.formPersonagem = formPersonagem;
        this.formPersonagem.setcdupe(this);
        this.con = con;
    }

    public void exec(){
        formPersonagem.exibe();
    }

    public void salvarPersonagem(){
        String id = formPersonagem.getid();
        String nome = formPersonagem.getnome();

        personagem = new Personagem(id, nome);
        DAOPersonagem dao = new DAOPersonagem(con);
        int rs = dao.add(personagem);

        if(rs == 0){
            System.out.println("Personagem: " + personagem.getnome() + " cadastrado!");
        }else{
            System.out.println("Não foi possível salvar o personagem: " + personagem.getnome() + " no banco de dados!");
        }
    }
}
