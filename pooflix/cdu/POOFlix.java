package cdu;
import ui.*;

/***********************************************************
 *
 * POOFLIX 
 * Autores:  Isabella Sampaio e Vinícius Estevam 
 * Disciplina: Programação Orientada a Objetos - IFES SERRA
 * 
 ***********************************************************/

public class POOFlix {
    public static void main(String[] args){
        FormMain telaMain = new FormMain();
        CDUMain casoUsoMain = new CDUMain(telaMain);
        casoUsoMain.exec();
    }
}