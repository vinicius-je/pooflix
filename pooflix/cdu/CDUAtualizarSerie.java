package cdu;

import ui.*;
import dominio.*;
import persistence.DAOSerie;

import java.sql.Connection;


public class CDUAtualizarSerie {
    private Serie serie;
    private FormSerie formSerie;
    Connection con;

    public CDUAtualizarSerie(FormSerie formSerie, Connection con){
        this.formSerie = formSerie;
        this.formSerie.setcduas(this);
        this.con = con;
    }

    public void exec(){
        formSerie.exibeAtulizarSerie();
    }

    public Serie getSerie(String id){
        DAOSerie dao = new DAOSerie(con);
        return dao.getSerieByID(id);
    }

    public void atualizarSerie(){
        String id = formSerie.getid();
        String titulo = formSerie.gettitulo();
        int classeEtaria = Integer.parseInt(formSerie.getidademin());

        serie = new Serie(id, titulo, classeEtaria);
        DAOSerie dao = new DAOSerie(con);
        int rs = dao.update(serie);

        if(rs == 0){
            serie = getSerie(id);
            System.out.println("Serie: " + serie.gettitulo() + " atualizado com sucesso" + "\n" + serie);
        }else{
            System.out.println("Não foi possível realizar a atualização na serie: " + serie.gettitulo());
        }
    }

}
