package cdu;

import ui.*;

public class CDUMain  extends CDU {
    private FormMain formMain;

    public CDUMain(FormMain formMain){
        this.formMain = formMain;
        this.formMain.setcdu(this);
    }  
    
    public void exec() {
        formMain.exibe();
    }

    public void processaOpcao(String opcao){
        switch(opcao) {
            case "1": execCadSerie(); break;
            case "2": execCadEpisodio(); break;
            case "3": execCadAtor(); break;
            case "4": execCadPersonagem(); break;
            case "5": execCadPerformance(); break;
        }
    }

    public void execCadSerie(){
        FormSerie telaSerie = new FormSerie();
        CDUcadastrarSerie casoUsoSerie = new CDUcadastrarSerie(telaSerie);
        casoUsoSerie.exec();
    }

    public void execCadEpisodio(){
        FormEpisodio telaEpisodio = new FormEpisodio();
        CDUcadastrarEpis casoUsoEpis = new CDUcadastrarEpis(telaEpisodio);
        casoUsoEpis.exec();        
    }

    public void execCadAtor(){
        FormAtor telaAtor = new FormAtor();
        CDUcadastrarAtor casoUsoAtor = new CDUcadastrarAtor(telaAtor);
        casoUsoAtor.exec();        
    }

    public void execCadPersonagem(){
        FormPersonagem telaPersonagem = new FormPersonagem();
        CDUcadastrarPersonagem casoUsoPersonagem = new CDUcadastrarPersonagem(telaPersonagem);
        casoUsoPersonagem.exec();        
    }

    public void execCadPerformance(){
        FormPerformance telaPerformance = new FormPerformance();
        CDUcadastrarPerformance casoUsoPerformance = new CDUcadastrarPerformance(telaPerformance);
        casoUsoPerformance.exec();        
    }
}