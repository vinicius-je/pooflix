package cdu;

import ui.*;
import dominio.*;
import persistence.DBConnection;

public class CDUcadastrarSerie  extends CDU {
    private Serie serie;
    private FormSerie formSerie;
    DBConnection db;

    public CDUcadastrarSerie(FormSerie formSerie, DBConnection db){
        this.formSerie = formSerie;
        this.formSerie.setcdu(this);
        this.db = db;
    }

    public void exec() {
        formSerie.exibe();
    }

    public void salvarSerie() {
        String id = formSerie.getid();
        String titulo = formSerie.gettitulo();
        int idade = Integer.valueOf(formSerie.getidademin());

        serie = new Serie(id,titulo,idade);

        db.salvarSerie(serie);
        // System.out.println("Salvando no banco de dados.." + serie);
    }
}