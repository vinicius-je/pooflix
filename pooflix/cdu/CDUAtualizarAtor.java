package cdu;

import ui.*;
import dominio.*;
import java.sql.Connection;
import persistence.DAOAtor;

public class CDUAtualizarAtor {
    private Ator ator;
    private FormAtor formAtor;
    Connection con;

    public CDUAtualizarAtor(FormAtor formAtor, Connection con){
        this.formAtor = formAtor;
        this.formAtor.setcduaa(this);
        this.con = con;
    }

    public void exec(){
        formAtor.exibeAtualizarAtor();
    }

    public Ator getAtor(String id){
        DAOAtor dao = new DAOAtor(con);
        return dao.getAtorByID(id);
    }

    public void atualizarAtor(){
        String id = formAtor.getid();
        String nome = formAtor.getnome();
        String nacionalidade = formAtor.getnacionalidade();

        ator = new Ator(id, nome, nacionalidade);
        DAOAtor dao = new DAOAtor(con);
        int rs = dao.update(ator);

        if(rs == 0){
            ator = getAtor(id);
            System.out.println("Ator: " + ator.getnome() + " atualizado com sucesso" + "\n" + ator);
        }else{
            System.out.println("Não foi possível realizar a atualização no ator: " + ator.getnome());
        }
    }
}
