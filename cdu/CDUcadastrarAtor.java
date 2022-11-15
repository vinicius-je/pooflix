package cdu;

import ui.*;
import dominio.*;

public class CDUcadastrarAtor extends CDU {
    private Ator ator;
    private FormAtor formAtor;

    public CDUcadastrarAtor(FormAtor formAtor){
        this.formAtor = formAtor;
        this.formAtor.setcduca(this);
    }

    public void exec(){
        formAtor.exibe();
    }

    public void salvarAtor(){
        String id = formAtor.getid();
        String nome = formAtor.getnome();
        String nacionalidade = formAtor.getnacionalidade();

        ator = new Ator(id, nome, nacionalidade);
        //bd.salvarAtor(ator)
        System.out.println("Salvando no banco de dados.." + ator);
    }
}
