package cdu;

import java.sql.Connection;

import ui.FormAtor;
import ui.FormEpisodio;
import ui.FormExclusao;
import ui.FormPersonagem;
import ui.FormSerie;

public class CDUExclusao {
    private FormExclusao formExclusao;
    private Connection con;

    public CDUExclusao(FormExclusao formExclusao, Connection con){
        this.formExclusao = formExclusao;
        formExclusao.setcdue(this);
        this.con = con;
    }

    public void exec(){
        formExclusao.exibe();
    }

    public void processaOpcao(String opcao){
        switch(opcao) {
            case "1": excluirSerie(); break;
            case "2": excluirEpisodio(); break;
            case "3": excluirAtor(); break;
            case "4": excluirPersonagem(); break;
        }
    }

    public void excluirSerie(){
        FormSerie formSerie = new FormSerie();
        CDUExcluirSerie casoUsoSerie = new CDUExcluirSerie(formSerie, con);
        casoUsoSerie.exec();
    }

    public void excluirEpisodio(){
        FormEpisodio formEpisodio = new FormEpisodio();
        CDUExcluirEpisodio casoUsoEpisodio = new CDUExcluirEpisodio(formEpisodio, con);
        casoUsoEpisodio.exec();
    }

    public void excluirAtor(){
        FormAtor formAtor = new FormAtor();
        CDUExcluirAtor casoUsoAtor = new CDUExcluirAtor(formAtor, con);
        casoUsoAtor.exec();
    }

    public void excluirPersonagem(){
        FormPersonagem formPersonagem = new FormPersonagem();
        CDUExcluirPersonagem casoUsoPersonagem = new CDUExcluirPersonagem(formPersonagem, con);
        casoUsoPersonagem.exec();
    }
}
