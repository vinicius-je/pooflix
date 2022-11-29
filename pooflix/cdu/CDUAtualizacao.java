package cdu;

import java.sql.Connection;

import ui.FormAtor;
import ui.FormAtualizacao;
import ui.FormEpisodio;
import ui.FormPersonagem;
import ui.FormSerie;

public class CDUAtualizacao {
    private FormAtualizacao formAtualizacao;
    private Connection con;

    public CDUAtualizacao(FormAtualizacao formAtualizacao, Connection con){
        this.formAtualizacao = formAtualizacao;
        formAtualizacao.setcua(this);
        this.con = con;
    }

    public void exec(){
        formAtualizacao.exibe();
    }

    public void processaOpcao(String opcao){
        switch(opcao) {
            case "1": atualizarSerie(); break;
            case "2": atualizarEpisodio(); break;
            case "3": atualizarAtor(); break;
            case "4": atualizarPersonagem(); break;
        }
    }

    public void atualizarSerie(){
        FormSerie formSerie = new FormSerie();
        CDUAtualizarSerie casoUsoSerie = new CDUAtualizarSerie(formSerie, con);
        casoUsoSerie.exec();
    }

    public void atualizarEpisodio(){
        FormEpisodio formEpisodio = new FormEpisodio();
        CDUAtualizarEpisodio casoUsoEpisodio = new CDUAtualizarEpisodio(formEpisodio, con);
        casoUsoEpisodio.exec();
    }

    public void atualizarAtor(){
        FormAtor formAtor = new FormAtor();
        CDUAtualizarAtor casoUsoAtor = new CDUAtualizarAtor(formAtor, con);
        casoUsoAtor.exec();
    }

    public void atualizarPersonagem(){
        FormPersonagem formPersonagem = new FormPersonagem();
        CDUAtualizarPersonagem casoUsoPersonagem = new CDUAtualizarPersonagem(formPersonagem, con);
        casoUsoPersonagem.exec();
    }
}
