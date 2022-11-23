package cdu;

import ui.*;
import dominio.*;
import persistence.DBConnection;

public class CDUcadastrarEpis extends CDU {
    private Episodio episodio = null;
    private FormEpisodio formEpisodio;
    DBConnection db;

    public void exec() {
        formEpisodio.exibe();
    }

    public CDUcadastrarEpis(FormEpisodio formEpisodio, DBConnection db){
        this.formEpisodio = formEpisodio;
        this.formEpisodio.setcdu(this);
        this.db = db;

    }

    public String getNomeSerie(int idserie) {
        Serie serie = db.getSerie(idserie); 
        return serie.gettitulo();
    }

    public void salvarEpisodio() {
        String id = formEpisodio.getid();
        String idserie = formEpisodio.getidserie();
        String temporada = formEpisodio.gettemporada();
        String titulo = formEpisodio.gettitulo();
        String resumo = formEpisodio.getresumo();

        episodio = new Episodio(id, titulo, temporada, resumo, idserie);   

        db.salvarEpisodio(episodio);
    }
}