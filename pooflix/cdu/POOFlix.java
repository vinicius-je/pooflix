package cdu;
import ui.*;

/*
 * POOFLIX 
 * Autor: Vinícius Estevam
 * Cadastra: Ator, Personagem, Performance, Serie e Episódio
 * Relatório: Série, Episódio, Ator e Personagem
 * Pendente: Adicionar Categorias, Episódios em series, atualizar e deletar no banco de dados
 */

public class POOFlix {
    public static void main(String[] args){
        FormMain telaMain = new FormMain();
        CDUMain casoUsoMain = new CDUMain(telaMain);
        casoUsoMain.exec();
    }
}