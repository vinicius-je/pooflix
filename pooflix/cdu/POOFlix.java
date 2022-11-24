package cdu;

import ui.*;

/*
 * POOFLIX 
 * CADASTRA: Ator, Personagem, Performance, Serie e Episódio
 * FALTA: Adicionar Categorias e Episódios em series
 */

public class POOFlix {
    public static void main(String[] args){
        FormMain telaMain = new FormMain();
        CDUMain casoUsoMain = new CDUMain(telaMain);
        casoUsoMain.exec();
    }
}