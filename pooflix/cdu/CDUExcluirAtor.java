package cdu;

import java.sql.Connection;

import dominio.Ator;
import persistence.DAOAtor;
import ui.FormAtor;

public class CDUExcluirAtor {
    private FormAtor formAtor;
    Connection con;

    public CDUExcluirAtor(FormAtor formAtor, Connection con){
        this.formAtor = formAtor;
        this.formAtor.setcduea(this);
        this.con = con;
    }

    public void exec(){
        formAtor.exibeDeletarAtor();
    }

    public Ator getAtor(String id){
        DAOAtor dao = new DAOAtor(con);
        return dao.getAtorByID(id);
    }

    public void deletarSerie(){
        String id = formAtor.getid();
        DAOAtor dao = new DAOAtor(con);
        int rs = dao.remove(id);

        if(rs == 0){
            System.out.println("Ator excluído com sucesso!");
        }else{
            System.out.println("Não foi possível excluir o ator");
        }
    }
}
