package cdu;

import java.sql.Connection;

import dominio.Episodio;
import persistence.DAOEpisodio;
import ui.FormEpisodio;

public class CDUExcluirEpisodio {
    private FormEpisodio formEpisodio;
    Connection con;

    public CDUExcluirEpisodio(FormEpisodio formEpisodio, Connection con){
        this.formEpisodio = formEpisodio;
        this.formEpisodio.setcduep(this);
        this.con = con;
    }

    public void exec(){
        formEpisodio.exibeDeletarEpisodio();
    }

    public Episodio getEpisodio(String id){
        DAOEpisodio dao = new DAOEpisodio(con);
        return dao.getEpisodioByID(id);
    }

    public void deletarEpisodio(){
        String id = formEpisodio.getid();
        DAOEpisodio dao = new DAOEpisodio(con);
        int rs = dao.remove(id);

        if(rs == 0){
            System.out.println("Episódio excluído com sucesso!");
        }else{
            System.out.println("Não foi possível excluir o episódio");
        }
    }
}
