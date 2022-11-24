package cdu;

import ui.*;

import java.sql.Connection;

import dominio.*;
import persistence.DAOEpisodio;
import persistence.DBConnection;

public class CDUcadastrarEpis extends CDU {
    private Episodio episodio = null;
    private FormEpisodio formEpisodio;
    Connection con;

    public void exec() {
        formEpisodio.exibe();
    }

    public CDUcadastrarEpis(FormEpisodio formEpisodio, Connection con){
        this.formEpisodio = formEpisodio;
        this.formEpisodio.setcdu(this);
        this.con = con;

    }

    public String getNomeSerie(int idserie) {
        DAOEpisodio dao = new DAOEpisodio(con);
        Serie serie = dao.getSerie(idserie); 
        return serie.gettitulo();
    }

    public void salvarEpisodio() {
        String id = formEpisodio.getid();
        String idserie = formEpisodio.getidserie();
        String temporada = formEpisodio.gettemporada();
        String titulo = formEpisodio.gettitulo();
        String resumo = formEpisodio.getresumo();

        episodio = new Episodio(id, titulo, temporada, resumo, idserie);   
        DAOEpisodio dao = new DAOEpisodio(con);
        int rs = dao.add(episodio);

        if(rs == 0){
            System.out.println("Episódio: " + episodio.gettitulo() + " cadastrado com sucesso!");
        }else{
            System.out.println("Não foi possível salvar o episódio: " + episodio.gettitulo() + " no banco de dados!");
        }
    }
}