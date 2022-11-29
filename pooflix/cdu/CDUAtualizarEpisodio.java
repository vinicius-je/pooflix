package cdu;

import java.sql.Connection;

import dominio.Episodio;
import persistence.DAOEpisodio;
import ui.FormEpisodio;

public class CDUAtualizarEpisodio {
    private Episodio episodio;
    private FormEpisodio formEpisodio;
    Connection con;

    public CDUAtualizarEpisodio(FormEpisodio formEpisodio, Connection con){
        this.formEpisodio = formEpisodio;
        this.formEpisodio.setcduae(this);
        this.con = con;
    }

    public void exec(){
        formEpisodio.exibeAtualizarEpisodio();
    }

    public Episodio getEpisodio(String id){
        DAOEpisodio dao = new DAOEpisodio(con);
        return dao.getEpisodioByID(id);
    }

    public void atualizarEpisodio(){
        String id = formEpisodio.getid();
        String titulo = formEpisodio.gettitulo();
        String temporada = formEpisodio.gettemporada();
        String resumo = formEpisodio.getresumo();
        String idSerie = formEpisodio.getidserie();
    
        episodio = new Episodio(id, titulo, temporada, resumo, idSerie);
        DAOEpisodio dao = new DAOEpisodio(con);
        int rs = dao.update(episodio);

        if(rs == 0){
            episodio = getEpisodio(id);
            System.out.println("Episódio: " + episodio.gettitulo() + " atualizado com sucesso" + "\n" + episodio);
        }else{
            System.out.println("Não foi possível realizar a atualização na serie: " + episodio.gettitulo());
        }
    }
}
