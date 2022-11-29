package cdu;

import java.sql.Connection;

import persistence.DAOAtor;
import ui.FormAtor;
import ui.FormAtualizacao;

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
            case "4": ; break;
        }
    }

    public void atualizaAtor(){
        FormAtor formAtor = new FormAtor();
        CDUAtualizarAtor casoUsoAtor = new CDUAtualizarAtor(formAtor, con);
        casoUsoAtor.exec();
    }

}
