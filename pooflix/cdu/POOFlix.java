package cdu;
import ui.*;

/*******************************************************
 *
 * POOFLIX 
 * Autores:  Isabella Sampaio e Vinícius Estevam 
 * 
 ********************************************************/

public class POOFlix {
    public static void main(String[] args){
        FormMain telaMain = new FormMain();
        CDUMain casoUsoMain = new CDUMain(telaMain);
        casoUsoMain.exec();
    }
}