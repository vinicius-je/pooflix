package cdu;

import java.sql.Connection;

import ui.FormAtor;
import ui.FormExclusao;
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

    }

    public void excluirAtor(){
        FormAtor formAtor = new FormAtor();
        CDUExcluirAtor casuUsoAtor = new CDUExcluirAtor(formAtor, con);
        casuUsoAtor.exec();
    }

    public void excluirPersonagem(){
        
    }
}
