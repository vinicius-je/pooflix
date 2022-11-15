package cdu;

import ui.*;
import dominio.*;

public class CDUcadastrarPersonagem extends CDU {
    private Personagem personagem;
    private FormPersonagem formPersonagem;

    public CDUcadastrarPersonagem(FormPersonagem formPersonagem){
        this.formPersonagem = formPersonagem;
        this.formPersonagem.setcdupe(this);
    }

    public void exec(){
        formPersonagem.exibe();
    }

    public void salvarPersonagem(){
        String id = formPersonagem.getid();
        String nome = formPersonagem.getnome();

        personagem = new Personagem(id, nome);
        //bd.salvarPersonagem
        System.out.println("Salvando no banco de dados..." + personagem); 
    }
}
