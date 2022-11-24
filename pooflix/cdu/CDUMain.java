package cdu;

import java.sql.Connection;
import persistence.DBConnection;
import ui.*;

public class CDUMain extends CDU {
    private FormMain formMain;
    private String url = "jdbc:postgresql://babar.db.elephantsql.com/stmhqghf";
    private String usuario = "stmhqghf";
    private String senha = "ddks5Z_6nS_Ef4sZLU64ZpCcE9-4RpIV";
    DBConnection db = null;
    Connection con = null;

    public CDUMain(FormMain formMain){
        this.formMain = formMain;
        this.formMain.setcdu(this);
    }  
    
    public void exec() {
        db = new DBConnection(url, usuario, senha);
        con = db.connection();

        if(con != null){
            System.out.println("Banco de dados conectado com sucesso!");
            formMain.exibe();
        }
    }

    public void processaOpcao(String opcao){
        switch(opcao) {
            case "1": execCadSerie(); break;
            case "2": execCadEpisodio(); break;
            case "3": execCadAtor(); break;
            case "4": execCadPersonagem(); break;
            case "5": execCadPerformance(); break;
            case "6": execCadRelatorio(); break;
        }
    }

    public void execCadSerie(){
        FormSerie telaSerie = new FormSerie();
        CDUcadastrarSerie casoUsoSerie = new CDUcadastrarSerie(telaSerie, db.getConnection());
        casoUsoSerie.exec();
    }

    public void execCadEpisodio(){
        FormEpisodio telaEpisodio = new FormEpisodio();
        CDUcadastrarEpis casoUsoEpis = new CDUcadastrarEpis(telaEpisodio, db.getConnection());
        casoUsoEpis.exec();        
    }

    public void execCadAtor(){
        FormAtor telaAtor = new FormAtor();
        CDUcadastrarAtor casoUsoAtor = new CDUcadastrarAtor(telaAtor, db.getConnection());
        casoUsoAtor.exec();        
    }

    public void execCadPersonagem(){
        FormPersonagem telaPersonagem = new FormPersonagem();
        CDUcadastrarPersonagem casoUsoPersonagem = new CDUcadastrarPersonagem(telaPersonagem, db.getConnection());
        casoUsoPersonagem.exec();        
    }

    public void execCadPerformance(){
        FormPerformance telaPerformance = new FormPerformance();
        CDUcadastrarPerformance casoUsoPerformance = new CDUcadastrarPerformance(telaPerformance, db.getConnection());
        casoUsoPerformance.exec();        
    }

    public void execCadRelatorio(){
        FormRelatorio telaRelatorio = new FormRelatorio();
        CDURelatorio casoUsoRelatorio = new CDURelatorio(telaRelatorio, db);
        casoUsoRelatorio.exec();        
    }
}
