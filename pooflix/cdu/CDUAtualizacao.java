package cdu;

import java.sql.Connection;

import ui.FormAtor;
import ui.FormAtualizacao;
import ui.FormPersonagem;

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
            case "1": ; break;
            case "2": ; break;
            case "3": atualizaAtor(); break;
            case "4": atualizaPersonagem(); break;
        }
    }

    public void atualizaAtor(){
        FormAtor formAtor = new FormAtor();
        CDUAtualizarAtor casoUsoAtor = new CDUAtualizarAtor(formAtor, con);
        casoUsoAtor.exec();
    }

    public void atualizaPersonagem(){
        FormPersonagem formPersonagem = new FormPersonagem();
        CDUAtualizarPersonagem casoUsoPersonagem = new CDUAtualizarPersonagem(formPersonagem, con);
        casoUsoPersonagem.exec();
    }
}
