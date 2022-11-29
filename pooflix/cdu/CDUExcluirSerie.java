package cdu;

import ui.*;

import java.sql.Connection;

import dominio.*;
import persistence.DAOSerie;

public class CDUExcluirSerie {
    private FormSerie formSerie;
    Connection con;

    public CDUExcluirSerie(FormSerie formSerie, Connection con){
        this.formSerie = formSerie;
        this.formSerie.setcdues(this);
        this.con = con;
    }

    public void exec(){
        formSerie.exibeDeletarSerie();
    }

    public Serie getSerie(String id){
        DAOSerie dao = new DAOSerie(con);
        return dao.getSerieByID(id);
    }

    public void deletarSerie(){
        String id = formSerie.getid();
        DAOSerie dao = new DAOSerie(con);
        int rs = dao.remove(id);

        if(rs == 0){
            System.out.println("Serie excluída com sucesso!");
        }else{
            System.out.println("Não foi possível excluir serie");
        }
    }
}
